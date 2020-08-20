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

package com.liferay.portal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LayoutSetBranch;
import com.liferay.portal.kernel.model.LayoutSetBranchModel;
import com.liferay.portal.kernel.model.LayoutSetBranchSoap;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the LayoutSetBranch service. Represents a row in the &quot;LayoutSetBranch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>LayoutSetBranchModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutSetBranchImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetBranchImpl
 * @generated
 */
@JSON(strict = true)
public class LayoutSetBranchModelImpl
	extends BaseModelImpl<LayoutSetBranch> implements LayoutSetBranchModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout set branch model instance should use the <code>LayoutSetBranch</code> interface instead.
	 */
	public static final String TABLE_NAME = "LayoutSetBranch";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"layoutSetBranchId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"privateLayout", Types.BOOLEAN}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"master", Types.BOOLEAN},
		{"logoId", Types.BIGINT}, {"themeId", Types.VARCHAR},
		{"colorSchemeId", Types.VARCHAR}, {"css", Types.CLOB},
		{"settings_", Types.CLOB}, {"layoutSetPrototypeUuid", Types.VARCHAR},
		{"layoutSetPrototypeLinkEnabled", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("layoutSetBranchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("privateLayout", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("master", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("logoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("themeId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("colorSchemeId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("css", Types.CLOB);
		TABLE_COLUMNS_MAP.put("settings_", Types.CLOB);
		TABLE_COLUMNS_MAP.put("layoutSetPrototypeUuid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("layoutSetPrototypeLinkEnabled", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LayoutSetBranch (mvccVersion LONG default 0 not null,layoutSetBranchId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,privateLayout BOOLEAN,name VARCHAR(75) null,description STRING null,master BOOLEAN,logoId LONG,themeId VARCHAR(75) null,colorSchemeId VARCHAR(75) null,css TEXT null,settings_ TEXT null,layoutSetPrototypeUuid VARCHAR(75) null,layoutSetPrototypeLinkEnabled BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table LayoutSetBranch";

	public static final String ORDER_BY_JPQL =
		" ORDER BY layoutSetBranch.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LayoutSetBranch.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long MASTER_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long PRIVATELAYOUT_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static LayoutSetBranch toModel(LayoutSetBranchSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LayoutSetBranch model = new LayoutSetBranchImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setLayoutSetBranchId(soapModel.getLayoutSetBranchId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPrivateLayout(soapModel.isPrivateLayout());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setMaster(soapModel.isMaster());
		model.setLogoId(soapModel.getLogoId());
		model.setThemeId(soapModel.getThemeId());
		model.setColorSchemeId(soapModel.getColorSchemeId());
		model.setCss(soapModel.getCss());
		model.setSettings(soapModel.getSettings());
		model.setLayoutSetPrototypeUuid(soapModel.getLayoutSetPrototypeUuid());
		model.setLayoutSetPrototypeLinkEnabled(
			soapModel.isLayoutSetPrototypeLinkEnabled());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<LayoutSetBranch> toModels(
		LayoutSetBranchSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<LayoutSetBranch> models = new ArrayList<LayoutSetBranch>(
			soapModels.length);

		for (LayoutSetBranchSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.LayoutSetBranch"));

	public LayoutSetBranchModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _layoutSetBranchId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLayoutSetBranchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutSetBranchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutSetBranch.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutSetBranch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LayoutSetBranch, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LayoutSetBranch, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutSetBranch, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((LayoutSetBranch)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LayoutSetBranch, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LayoutSetBranch, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LayoutSetBranch)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LayoutSetBranch, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LayoutSetBranch, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, LayoutSetBranch>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			LayoutSetBranch.class.getClassLoader(), LayoutSetBranch.class,
			ModelWrapper.class);

		try {
			Constructor<LayoutSetBranch> constructor =
				(Constructor<LayoutSetBranch>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<LayoutSetBranch, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LayoutSetBranch, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LayoutSetBranch, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<LayoutSetBranch, Object>>();
		Map<String, BiConsumer<LayoutSetBranch, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<LayoutSetBranch, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", LayoutSetBranch::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<LayoutSetBranch, Long>)LayoutSetBranch::setMvccVersion);
		attributeGetterFunctions.put(
			"layoutSetBranchId", LayoutSetBranch::getLayoutSetBranchId);
		attributeSetterBiConsumers.put(
			"layoutSetBranchId",
			(BiConsumer<LayoutSetBranch, Long>)
				LayoutSetBranch::setLayoutSetBranchId);
		attributeGetterFunctions.put("groupId", LayoutSetBranch::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<LayoutSetBranch, Long>)LayoutSetBranch::setGroupId);
		attributeGetterFunctions.put(
			"companyId", LayoutSetBranch::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<LayoutSetBranch, Long>)LayoutSetBranch::setCompanyId);
		attributeGetterFunctions.put("userId", LayoutSetBranch::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<LayoutSetBranch, Long>)LayoutSetBranch::setUserId);
		attributeGetterFunctions.put("userName", LayoutSetBranch::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<LayoutSetBranch, String>)LayoutSetBranch::setUserName);
		attributeGetterFunctions.put(
			"createDate", LayoutSetBranch::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<LayoutSetBranch, Date>)LayoutSetBranch::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", LayoutSetBranch::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<LayoutSetBranch, Date>)
				LayoutSetBranch::setModifiedDate);
		attributeGetterFunctions.put(
			"privateLayout", LayoutSetBranch::getPrivateLayout);
		attributeSetterBiConsumers.put(
			"privateLayout",
			(BiConsumer<LayoutSetBranch, Boolean>)
				LayoutSetBranch::setPrivateLayout);
		attributeGetterFunctions.put("name", LayoutSetBranch::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<LayoutSetBranch, String>)LayoutSetBranch::setName);
		attributeGetterFunctions.put(
			"description", LayoutSetBranch::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<LayoutSetBranch, String>)
				LayoutSetBranch::setDescription);
		attributeGetterFunctions.put("master", LayoutSetBranch::getMaster);
		attributeSetterBiConsumers.put(
			"master",
			(BiConsumer<LayoutSetBranch, Boolean>)LayoutSetBranch::setMaster);
		attributeGetterFunctions.put("logoId", LayoutSetBranch::getLogoId);
		attributeSetterBiConsumers.put(
			"logoId",
			(BiConsumer<LayoutSetBranch, Long>)LayoutSetBranch::setLogoId);
		attributeGetterFunctions.put("themeId", LayoutSetBranch::getThemeId);
		attributeSetterBiConsumers.put(
			"themeId",
			(BiConsumer<LayoutSetBranch, String>)LayoutSetBranch::setThemeId);
		attributeGetterFunctions.put(
			"colorSchemeId", LayoutSetBranch::getColorSchemeId);
		attributeSetterBiConsumers.put(
			"colorSchemeId",
			(BiConsumer<LayoutSetBranch, String>)
				LayoutSetBranch::setColorSchemeId);
		attributeGetterFunctions.put("css", LayoutSetBranch::getCss);
		attributeSetterBiConsumers.put(
			"css",
			(BiConsumer<LayoutSetBranch, String>)LayoutSetBranch::setCss);
		attributeGetterFunctions.put("settings", LayoutSetBranch::getSettings);
		attributeSetterBiConsumers.put(
			"settings",
			(BiConsumer<LayoutSetBranch, String>)LayoutSetBranch::setSettings);
		attributeGetterFunctions.put(
			"layoutSetPrototypeUuid",
			LayoutSetBranch::getLayoutSetPrototypeUuid);
		attributeSetterBiConsumers.put(
			"layoutSetPrototypeUuid",
			(BiConsumer<LayoutSetBranch, String>)
				LayoutSetBranch::setLayoutSetPrototypeUuid);
		attributeGetterFunctions.put(
			"layoutSetPrototypeLinkEnabled",
			LayoutSetBranch::getLayoutSetPrototypeLinkEnabled);
		attributeSetterBiConsumers.put(
			"layoutSetPrototypeLinkEnabled",
			(BiConsumer<LayoutSetBranch, Boolean>)
				LayoutSetBranch::setLayoutSetPrototypeLinkEnabled);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("mvccVersion");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getLayoutSetBranchId() {
		return _layoutSetBranchId;
	}

	@Override
	public void setLayoutSetBranchId(long layoutSetBranchId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("layoutSetBranchId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_layoutSetBranchId = layoutSetBranchId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("groupId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("companyId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("userId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("userName");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("createDate");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("modifiedDate");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public boolean getPrivateLayout() {
		return _privateLayout;
	}

	@JSON
	@Override
	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	@Override
	public void setPrivateLayout(boolean privateLayout) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("privateLayout");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_privateLayout = privateLayout;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalPrivateLayout() {
		return GetterUtil.getBoolean(getColumnOriginalValue("privateLayout"));
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("name");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("description");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_description = description;
	}

	@JSON
	@Override
	public boolean getMaster() {
		return _master;
	}

	@JSON
	@Override
	public boolean isMaster() {
		return _master;
	}

	@Override
	public void setMaster(boolean master) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("master");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_master = master;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalMaster() {
		return GetterUtil.getBoolean(getColumnOriginalValue("master"));
	}

	@JSON
	@Override
	public long getLogoId() {
		return _logoId;
	}

	@Override
	public void setLogoId(long logoId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("logoId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_logoId = logoId;
	}

	@JSON
	@Override
	public String getThemeId() {
		if (_themeId == null) {
			return "";
		}
		else {
			return _themeId;
		}
	}

	@Override
	public void setThemeId(String themeId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("themeId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_themeId = themeId;
	}

	@JSON
	@Override
	public String getColorSchemeId() {
		if (_colorSchemeId == null) {
			return "";
		}
		else {
			return _colorSchemeId;
		}
	}

	@Override
	public void setColorSchemeId(String colorSchemeId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("colorSchemeId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_colorSchemeId = colorSchemeId;
	}

	@JSON
	@Override
	public String getCss() {
		if (_css == null) {
			return "";
		}
		else {
			return _css;
		}
	}

	@Override
	public void setCss(String css) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("css");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_css = css;
	}

	@JSON
	@Override
	public String getSettings() {
		if (_settings == null) {
			return "";
		}
		else {
			return _settings;
		}
	}

	@Override
	public void setSettings(String settings) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("settings_");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_settings = settings;
	}

	@JSON
	@Override
	public String getLayoutSetPrototypeUuid() {
		if (_layoutSetPrototypeUuid == null) {
			return "";
		}
		else {
			return _layoutSetPrototypeUuid;
		}
	}

	@Override
	public void setLayoutSetPrototypeUuid(String layoutSetPrototypeUuid) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("layoutSetPrototypeUuid");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_layoutSetPrototypeUuid = layoutSetPrototypeUuid;
	}

	@JSON
	@Override
	public boolean getLayoutSetPrototypeLinkEnabled() {
		return _layoutSetPrototypeLinkEnabled;
	}

	@JSON
	@Override
	public boolean isLayoutSetPrototypeLinkEnabled() {
		return _layoutSetPrototypeLinkEnabled;
	}

	@Override
	public void setLayoutSetPrototypeLinkEnabled(
		boolean layoutSetPrototypeLinkEnabled) {

		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get(
				"layoutSetPrototypeLinkEnabled");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_layoutSetPrototypeLinkEnabled = layoutSetPrototypeLinkEnabled;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), LayoutSetBranch.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LayoutSetBranch toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LayoutSetBranch>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LayoutSetBranchImpl layoutSetBranchImpl = new LayoutSetBranchImpl();

		layoutSetBranchImpl.setMvccVersion(getMvccVersion());
		layoutSetBranchImpl.setLayoutSetBranchId(getLayoutSetBranchId());
		layoutSetBranchImpl.setGroupId(getGroupId());
		layoutSetBranchImpl.setCompanyId(getCompanyId());
		layoutSetBranchImpl.setUserId(getUserId());
		layoutSetBranchImpl.setUserName(getUserName());
		layoutSetBranchImpl.setCreateDate(getCreateDate());
		layoutSetBranchImpl.setModifiedDate(getModifiedDate());
		layoutSetBranchImpl.setPrivateLayout(isPrivateLayout());
		layoutSetBranchImpl.setName(getName());
		layoutSetBranchImpl.setDescription(getDescription());
		layoutSetBranchImpl.setMaster(isMaster());
		layoutSetBranchImpl.setLogoId(getLogoId());
		layoutSetBranchImpl.setThemeId(getThemeId());
		layoutSetBranchImpl.setColorSchemeId(getColorSchemeId());
		layoutSetBranchImpl.setCss(getCss());
		layoutSetBranchImpl.setSettings(getSettings());
		layoutSetBranchImpl.setLayoutSetPrototypeUuid(
			getLayoutSetPrototypeUuid());
		layoutSetBranchImpl.setLayoutSetPrototypeLinkEnabled(
			isLayoutSetPrototypeLinkEnabled());

		layoutSetBranchImpl.resetOriginalValues();

		return layoutSetBranchImpl;
	}

	@Override
	public int compareTo(LayoutSetBranch layoutSetBranch) {
		int value = 0;

		value = getName().compareTo(layoutSetBranch.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LayoutSetBranch)) {
			return false;
		}

		LayoutSetBranch layoutSetBranch = (LayoutSetBranch)object;

		long primaryKey = layoutSetBranch.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutSetBranch> toCacheModel() {
		LayoutSetBranchCacheModel layoutSetBranchCacheModel =
			new LayoutSetBranchCacheModel();

		layoutSetBranchCacheModel.mvccVersion = getMvccVersion();

		layoutSetBranchCacheModel.layoutSetBranchId = getLayoutSetBranchId();

		layoutSetBranchCacheModel.groupId = getGroupId();

		layoutSetBranchCacheModel.companyId = getCompanyId();

		layoutSetBranchCacheModel.userId = getUserId();

		layoutSetBranchCacheModel.userName = getUserName();

		String userName = layoutSetBranchCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			layoutSetBranchCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			layoutSetBranchCacheModel.createDate = createDate.getTime();
		}
		else {
			layoutSetBranchCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			layoutSetBranchCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			layoutSetBranchCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		layoutSetBranchCacheModel.privateLayout = isPrivateLayout();

		layoutSetBranchCacheModel.name = getName();

		String name = layoutSetBranchCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			layoutSetBranchCacheModel.name = null;
		}

		layoutSetBranchCacheModel.description = getDescription();

		String description = layoutSetBranchCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			layoutSetBranchCacheModel.description = null;
		}

		layoutSetBranchCacheModel.master = isMaster();

		layoutSetBranchCacheModel.logoId = getLogoId();

		layoutSetBranchCacheModel.themeId = getThemeId();

		String themeId = layoutSetBranchCacheModel.themeId;

		if ((themeId != null) && (themeId.length() == 0)) {
			layoutSetBranchCacheModel.themeId = null;
		}

		layoutSetBranchCacheModel.colorSchemeId = getColorSchemeId();

		String colorSchemeId = layoutSetBranchCacheModel.colorSchemeId;

		if ((colorSchemeId != null) && (colorSchemeId.length() == 0)) {
			layoutSetBranchCacheModel.colorSchemeId = null;
		}

		layoutSetBranchCacheModel.css = getCss();

		String css = layoutSetBranchCacheModel.css;

		if ((css != null) && (css.length() == 0)) {
			layoutSetBranchCacheModel.css = null;
		}

		layoutSetBranchCacheModel.settings = getSettings();

		String settings = layoutSetBranchCacheModel.settings;

		if ((settings != null) && (settings.length() == 0)) {
			layoutSetBranchCacheModel.settings = null;
		}

		layoutSetBranchCacheModel.layoutSetPrototypeUuid =
			getLayoutSetPrototypeUuid();

		String layoutSetPrototypeUuid =
			layoutSetBranchCacheModel.layoutSetPrototypeUuid;

		if ((layoutSetPrototypeUuid != null) &&
			(layoutSetPrototypeUuid.length() == 0)) {

			layoutSetBranchCacheModel.layoutSetPrototypeUuid = null;
		}

		layoutSetBranchCacheModel.layoutSetPrototypeLinkEnabled =
			isLayoutSetPrototypeLinkEnabled();

		return layoutSetBranchCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LayoutSetBranch, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LayoutSetBranch, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutSetBranch, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((LayoutSetBranch)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<LayoutSetBranch, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LayoutSetBranch, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutSetBranch, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((LayoutSetBranch)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, LayoutSetBranch>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _layoutSetBranchId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private boolean _privateLayout;
	private String _name;
	private String _description;
	private boolean _master;
	private long _logoId;
	private String _themeId;
	private String _colorSchemeId;
	private String _css;
	private String _settings;
	private String _layoutSetPrototypeUuid;
	private boolean _layoutSetPrototypeLinkEnabled;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("layoutSetBranchId", _layoutSetBranchId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("privateLayout", _privateLayout);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("master", _master);
		_columnOriginalValues.put("logoId", _logoId);
		_columnOriginalValues.put("themeId", _themeId);
		_columnOriginalValues.put("colorSchemeId", _colorSchemeId);
		_columnOriginalValues.put("css", _css);
		_columnOriginalValues.put("settings_", _settings);
		_columnOriginalValues.put(
			"layoutSetPrototypeUuid", _layoutSetPrototypeUuid);
		_columnOriginalValues.put(
			"layoutSetPrototypeLinkEnabled", _layoutSetPrototypeLinkEnabled);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new LinkedHashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("layoutSetBranchId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("privateLayout", 256L);

		columnBitmasks.put("name", 512L);

		columnBitmasks.put("description", 1024L);

		columnBitmasks.put("master", 2048L);

		columnBitmasks.put("logoId", 4096L);

		columnBitmasks.put("themeId", 8192L);

		columnBitmasks.put("colorSchemeId", 16384L);

		columnBitmasks.put("css", 32768L);

		columnBitmasks.put("settings_", 65536L);

		columnBitmasks.put("layoutSetPrototypeUuid", 131072L);

		columnBitmasks.put("layoutSetPrototypeLinkEnabled", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private transient Map<String, Object> _columnOriginalValues;
	private long _columnBitmask;
	private LayoutSetBranch _escapedModel;

}