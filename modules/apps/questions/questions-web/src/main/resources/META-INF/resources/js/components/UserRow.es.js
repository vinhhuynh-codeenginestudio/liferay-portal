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

import React from 'react';

import UserAvatar from './UserAvatar.es';

export default ({answer, creator}) => (
	<div className="autofit-padded autofit-row">
		<div className="autofit-col">
			<UserAvatar user={creator} />
		</div>
		<div className="text-right">
			<p className="mb-0">
				<small>
					{answer
						? Liferay.Language.get('answered-by')
						: Liferay.Language.get('asked-by')}
				</small>
			</p>
			<p>
				<strong>{creator.name}</strong>
			</p>
		</div>
	</div>
);
