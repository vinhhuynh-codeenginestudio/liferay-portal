/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import '../../css/main.scss';

import dom from 'metal-dom';
import Soy from 'metal-soy';
import React, {
	useCallback,
	useEffect,
	useImperativeHandle,
	useRef,
} from 'react';

import {EVENT_TYPES} from '../actions/eventTypes.es';
import Pages from '../components/Pages.es';
import {FormProvider, useForm} from '../hooks/useForm.es';
import formValidate from '../thunks/formValidate.es';
import {getConnectedReactComponentAdapter} from '../util/ReactComponentAdapter.es';
import {evaluate} from '../util/evaluation.es';
import {getFormId, getFormNode} from '../util/formId.es';
import templates from './Form.soy';

const Form = React.forwardRef(
	(
		{
			activePage,
			defaultLanguageId,
			description,
			editingLanguageId,
			name,
			pages,
			paginationMode,
			portletNamespace,
			rules,
			successPageSettings,
			...otherProps
		},
		ref
	) => {
		const dispatch = useForm();
		const containerRef = useRef(null);

		const validate = useCallback(
			() =>
				dispatch(
					formValidate({
						activePage,
						defaultLanguageId,
						editingLanguageId,
						pages,
						portletNamespace,
						rules,
					})
				),
			[
				dispatch,
				activePage,
				defaultLanguageId,
				editingLanguageId,
				pages,
				portletNamespace,
				rules,
			]
		);

		const handleFormSubmitted = useCallback(
			(event) => {
				event.preventDefault();

				validate()
					.then((validForm) => {
						if (validForm) {
							Liferay.Util.submitForm(event.target);

							Liferay.fire('ddmFormSubmit', {
								formId: getFormId(
									getFormNode(containerRef.current)
								),
							});
						}
					})
					.catch((error) => {
						console.error(error);
					});
			},
			[containerRef, validate]
		);

		useImperativeHandle(ref, () => ({
			evaluate: (editingLanguageId) =>
				evaluate(null, {
					defaultLanguageId,
					editingLanguageId,
					pages,
					portletNamespace,
					rules,
				}),
			get: (key) => {
				const props = {
					activePage,
					defaultLanguageId,
					description,
					editingLanguageId,
					name,
					pages,
					paginationMode,
					portletNamespace,
					rules,
					successPageSettings,
					...otherProps,
				};

				return props[key];
			},
			getFormNode: () =>
				containerRef.current && getFormNode(containerRef.current),
			toJSON: () => ({
				defaultLanguageId,
				description,
				editingLanguageId,
				name,
				pages,
				paginationMode,
				portletNamespace,
				rules,
				successPageSettings,
			}),
			updateEditingLanguageId: ({editingLanguageId}) =>
				dispatch({
					payload: {editingLanguageId},
					type: EVENT_TYPES.ALL,
				}),
			validate,
		}));

		useEffect(() => {
			if (containerRef.current) {
				Liferay.fire('ddmFormPageShow', {
					formId: getFormId(getFormNode(containerRef.current)),
					page: activePage,
					title: pages[activePage].title,
				});
			}
			// eslint-disable-next-line react-hooks/exhaustive-deps
		}, []);

		useEffect(() => {
			let onHandle;

			let submitHandle;

			if (containerRef.current) {
				const form = getFormNode(containerRef.current);

				if (form) {
					onHandle = Liferay.on(
						'submitForm',
						(event) => {
							if (event.form && event.form.getDOM() === form) {
								event.preventDefault();
							}
						},
						this
					);

					submitHandle = dom.on(form, 'submit', handleFormSubmitted);
				}
			}

			return () => {
				if (onHandle) {
					onHandle.detach();
				}

				if (submitHandle) {
					submitHandle.removeListener();
				}
			};
		}, [containerRef, handleFormSubmitted]);

		return (
			<Pages
				activePage={activePage}
				defaultLanguageId={defaultLanguageId}
				description={description}
				editingLanguageId={editingLanguageId}
				name={name}
				pages={pages}
				paginationMode={paginationMode}
				portletNamespace={portletNamespace}
				rules={rules}
				successPageSettings={successPageSettings}
				{...otherProps}
				ref={containerRef}
			/>
		);
	}
);

Form.displayName = 'Form';

const FormProxy = React.forwardRef(
	(
		{
			instance,
			activePage = 0,
			defaultLanguageId = themeDisplay.getLanguageId(),
			...otherProps
		},
		ref
	) => (
		<FormProvider
			onEvent={(type, payload) => instance.emit(type, payload)}
			value={{...otherProps, activePage, defaultLanguageId}}
		>
			{(props) => <Form {...props} ref={ref} />}
		</FormProvider>
	)
);

FormProxy.displayName = 'FormProxy';

const ReactFormAdapter = getConnectedReactComponentAdapter(FormProxy);

Soy.register(ReactFormAdapter, templates);

export default ReactFormAdapter;
