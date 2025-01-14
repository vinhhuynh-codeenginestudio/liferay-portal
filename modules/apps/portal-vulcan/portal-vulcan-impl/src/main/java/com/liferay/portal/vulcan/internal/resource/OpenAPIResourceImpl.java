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

package com.liferay.portal.vulcan.internal.resource;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.openapi.DTOProperty;
import com.liferay.portal.vulcan.openapi.OpenAPISchemaFilter;
import com.liferay.portal.vulcan.resource.OpenAPIResource;
import com.liferay.portal.vulcan.util.UriInfoUtil;

import io.swagger.v3.core.filter.AbstractSpecFilter;
import io.swagger.v3.core.filter.OpenAPISpecFilter;
import io.swagger.v3.core.filter.SpecFilter;
import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.jaxrs2.integration.JaxrsOpenApiContextBuilder;
import io.swagger.v3.oas.integration.GenericOpenApiContext;
import io.swagger.v3.oas.integration.api.OpenAPIConfiguration;
import io.swagger.v3.oas.integration.api.OpenApiContext;
import io.swagger.v3.oas.integration.api.OpenApiScanner;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.servers.Server;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;

/**
 * @author Javier Gamarra
 */
@Component(service = OpenAPIResource.class)
public class OpenAPIResourceImpl implements OpenAPIResource {

	@Override
	public Response getOpenAPI(
			OpenAPISchemaFilter openAPISchemaFilter,
			Set<Class<?>> resourceClasses, String type, UriInfo uriInfo)
		throws Exception {

		JaxrsOpenApiContextBuilder jaxrsOpenApiContextBuilder =
			new JaxrsOpenApiContextBuilder();

		OpenApiContext openApiContext = jaxrsOpenApiContextBuilder.buildContext(
			true);

		GenericOpenApiContext genericOpenApiContext =
			(GenericOpenApiContext)openApiContext;

		genericOpenApiContext.setCacheTTL(0L);
		genericOpenApiContext.setOpenApiScanner(
			new OpenApiScanner() {

				@Override
				public Set<Class<?>> classes() {
					return resourceClasses;
				}

				@Override
				public Map<String, Object> resources() {
					return new HashMap<>();
				}

				@Override
				public void setConfiguration(
					OpenAPIConfiguration openAPIConfiguration) {
				}

			});

		OpenAPI openAPI = openApiContext.read();

		if (openAPISchemaFilter != null) {
			SpecFilter specFilter = new SpecFilter();

			openAPI = specFilter.filter(
				openAPI, _toOpenAPISpecFilter(openAPISchemaFilter),
				uriInfo.getQueryParameters(), null, null);
		}

		if (openAPI == null) {
			return Response.status(
				404
			).build();
		}

		if (uriInfo != null) {
			Server server = new Server();

			server.setUrl(UriInfoUtil.getBasePath(uriInfo));

			openAPI.setServers(Collections.singletonList(server));
		}

		if (StringUtil.equalsIgnoreCase("yaml", type)) {
			return Response.status(
				Response.Status.OK
			).entity(
				Yaml.pretty(openAPI)
			).type(
				"application/yaml"
			).build();
		}

		return Response.status(
			Response.Status.OK
		).entity(
			openAPI
		).type(
			MediaType.APPLICATION_JSON_TYPE
		).build();
	}

	@Override
	public Response getOpenAPI(Set<Class<?>> resourceClasses, String type)
		throws Exception {

		return getOpenAPI(resourceClasses, type, null);
	}

	@Override
	public Response getOpenAPI(
			Set<Class<?>> resourceClasses, String type, UriInfo uriInfo)
		throws Exception {

		return getOpenAPI(null, resourceClasses, type, uriInfo);
	}

	private OpenAPISpecFilter _toOpenAPISpecFilter(
		OpenAPISchemaFilter openAPISchemaFilter) {

		return new AbstractSpecFilter() {

			@Override
			public Optional<Schema> filterSchema(
				Schema schema, Map<String, List<String>> params,
				Map<String, String> cookies,
				Map<String, List<String>> headers) {

				DTOProperty dtoProperty = openAPISchemaFilter.getDTOProperty();

				if (Objects.equals(dtoProperty.getName(), schema.getName())) {
					for (DTOProperty childDTOProperty :
							dtoProperty.getDTOProperties()) {

						schema.addProperties(
							childDTOProperty.getName(),
							_addSchema(childDTOProperty));
					}

					return Optional.of(schema);
				}

				return super.filterSchema(schema, params, cookies, headers);
			}

			private Schema<Object> _addSchema(DTOProperty dtoProperty) {
				Schema<Object> schema = new Schema<>();

				schema.setName(dtoProperty.getName());

				String type = dtoProperty.getType();

				if (type.equals("Boolean")) {
					schema.setType("boolean");
				}
				else if (type.equals("Date")) {
					schema.setFormat("date");
					schema.setType("string");
				}
				else if (type.equals("Double")) {
					schema.setFormat("double");
					schema.setType("number");
				}
				else if (type.equals("Integer")) {
					schema.setFormat("int32");
					schema.setType("integer");
				}
				else if (type.equals("Long")) {
					schema.setFormat("int64");
					schema.setType("integer");
				}
				else if (type.equals("String")) {
					schema.setType("string");
				}
				else {
					schema.setType("object");
				}

				for (DTOProperty childDTOProperty :
						dtoProperty.getDTOProperties()) {

					schema.addProperties(
						childDTOProperty.getName(),
						_addSchema(childDTOProperty));
				}

				return schema;
			}

		};
	}

}