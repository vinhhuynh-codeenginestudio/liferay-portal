<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
SearchResultContentDisplayBuilder searchResultContentDisplayBuilder = new SearchResultContentDisplayBuilder();

searchResultContentDisplayBuilder.setAssetEntryId(ParamUtil.getLong(request, "assetEntryId"));
searchResultContentDisplayBuilder.setLocale(locale);
searchResultContentDisplayBuilder.setPermissionChecker(permissionChecker);
searchResultContentDisplayBuilder.setPortal(PortalUtil.getPortal());
searchResultContentDisplayBuilder.setRenderRequest(renderRequest);
searchResultContentDisplayBuilder.setRenderResponse(renderResponse);
searchResultContentDisplayBuilder.setType(ParamUtil.getString(request, "type"));

SearchResultContentDisplayContext searchResultContentDisplayContext = searchResultContentDisplayBuilder.build();
%>

<c:if test="<%= searchResultContentDisplayContext.isVisible() %>">
	<liferay-ui:header
		localizeTitle="<%= false %>"
		title="<%= searchResultContentDisplayContext.getHeaderTitle() %>"
	/>

	<c:if test="<%= searchResultContentDisplayContext.hasEditPermission() %>">
		<div class="asset-actions lfr-meta-actions">

			<%
			Map<String, Object> data = new HashMap<String, Object>();

			data.put("destroyOnHide", true);
			data.put("id", HtmlUtil.escape(portletDisplay.getNamespace()) + "editAsset");
			data.put("title", LanguageUtil.format(request, "edit-x", HtmlUtil.escape(searchResultContentDisplayContext.getIconEditTarget()), false));
			%>

			<liferay-ui:icon
				cssClass="visible-interaction"
				data="<%= data %>"
				icon="pencil"
				label="<%= false %>"
				markupView="lexicon"
				message='<%= LanguageUtil.format(request, "edit-x-x", new Object[] {"hide-accessible", HtmlUtil.escape(searchResultContentDisplayContext.getIconEditTarget())}, false) %>'
				method="get"
				url="<%= searchResultContentDisplayContext.getIconURLString() %>"
				useDialog="<%= true %>"
			/>
		</div>
	</c:if>

	<liferay-asset:asset-display
		assetEntry="<%= searchResultContentDisplayContext.getAssetEntry() %>"
		assetRenderer="<%= searchResultContentDisplayContext.getAssetRenderer() %>"
		assetRendererFactory="<%= searchResultContentDisplayContext.getAssetRendererFactory() %>"
	/>
</c:if>