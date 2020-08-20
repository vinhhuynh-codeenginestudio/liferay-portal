/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.saml.persistence.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.saml.persistence.model.SamlIdpSpConnection;
import com.liferay.saml.persistence.model.SamlIdpSpConnectionModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SamlIdpSpConnection service. Represents a row in the &quot;SamlIdpSpConnection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SamlIdpSpConnectionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SamlIdpSpConnectionImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlIdpSpConnectionImpl
 * @generated
 */
public class SamlIdpSpConnectionModelImpl
	extends BaseModelImpl<SamlIdpSpConnection>
	implements SamlIdpSpConnectionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a saml idp sp connection model instance should use the <code>SamlIdpSpConnection</code> interface instead.
	 */
	public static final String TABLE_NAME = "SamlIdpSpConnection";

	public static final Object[][] TABLE_COLUMNS = {
		{"samlIdpSpConnectionId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"samlSpEntityId", Types.VARCHAR}, {"assertionLifetime", Types.INTEGER},
		{"attributeNames", Types.VARCHAR}, {"attributesEnabled", Types.BOOLEAN},
		{"attributesNamespaceEnabled", Types.BOOLEAN},
		{"enabled", Types.BOOLEAN}, {"encryptionForced", Types.BOOLEAN},
		{"metadataUrl", Types.VARCHAR}, {"metadataXml", Types.CLOB},
		{"metadataUpdatedDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"nameIdAttribute", Types.VARCHAR}, {"nameIdFormat", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("samlIdpSpConnectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("samlSpEntityId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("assertionLifetime", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("attributeNames", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("attributesEnabled", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("attributesNamespaceEnabled", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("enabled", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("encryptionForced", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("metadataUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("metadataXml", Types.CLOB);
		TABLE_COLUMNS_MAP.put("metadataUpdatedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nameIdAttribute", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nameIdFormat", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SamlIdpSpConnection (samlIdpSpConnectionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,samlSpEntityId VARCHAR(1024) null,assertionLifetime INTEGER,attributeNames STRING null,attributesEnabled BOOLEAN,attributesNamespaceEnabled BOOLEAN,enabled BOOLEAN,encryptionForced BOOLEAN,metadataUrl VARCHAR(1024) null,metadataXml TEXT null,metadataUpdatedDate DATE null,name VARCHAR(75) null,nameIdAttribute VARCHAR(1024) null,nameIdFormat VARCHAR(1024) null)";

	public static final String TABLE_SQL_DROP =
		"drop table SamlIdpSpConnection";

	public static final String ORDER_BY_JPQL =
		" ORDER BY samlIdpSpConnection.samlIdpSpConnectionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SamlIdpSpConnection.samlIdpSpConnectionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SAMLSPENTITYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SAMLIDPSPCONNECTIONID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public SamlIdpSpConnectionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _samlIdpSpConnectionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSamlIdpSpConnectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _samlIdpSpConnectionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SamlIdpSpConnection.class;
	}

	@Override
	public String getModelClassName() {
		return SamlIdpSpConnection.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SamlIdpSpConnection, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SamlIdpSpConnection, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SamlIdpSpConnection, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SamlIdpSpConnection)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SamlIdpSpConnection, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SamlIdpSpConnection, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SamlIdpSpConnection)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SamlIdpSpConnection, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SamlIdpSpConnection, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SamlIdpSpConnection>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SamlIdpSpConnection.class.getClassLoader(),
			SamlIdpSpConnection.class, ModelWrapper.class);

		try {
			Constructor<SamlIdpSpConnection> constructor =
				(Constructor<SamlIdpSpConnection>)proxyClass.getConstructor(
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

	private static final Map<String, Function<SamlIdpSpConnection, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SamlIdpSpConnection, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SamlIdpSpConnection, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<SamlIdpSpConnection, Object>>();
		Map<String, BiConsumer<SamlIdpSpConnection, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<SamlIdpSpConnection, ?>>();

		attributeGetterFunctions.put(
			"samlIdpSpConnectionId",
			SamlIdpSpConnection::getSamlIdpSpConnectionId);
		attributeSetterBiConsumers.put(
			"samlIdpSpConnectionId",
			(BiConsumer<SamlIdpSpConnection, Long>)
				SamlIdpSpConnection::setSamlIdpSpConnectionId);
		attributeGetterFunctions.put(
			"companyId", SamlIdpSpConnection::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SamlIdpSpConnection, Long>)
				SamlIdpSpConnection::setCompanyId);
		attributeGetterFunctions.put("userId", SamlIdpSpConnection::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<SamlIdpSpConnection, Long>)
				SamlIdpSpConnection::setUserId);
		attributeGetterFunctions.put(
			"userName", SamlIdpSpConnection::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SamlIdpSpConnection, String>)
				SamlIdpSpConnection::setUserName);
		attributeGetterFunctions.put(
			"createDate", SamlIdpSpConnection::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SamlIdpSpConnection, Date>)
				SamlIdpSpConnection::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SamlIdpSpConnection::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SamlIdpSpConnection, Date>)
				SamlIdpSpConnection::setModifiedDate);
		attributeGetterFunctions.put(
			"samlSpEntityId", SamlIdpSpConnection::getSamlSpEntityId);
		attributeSetterBiConsumers.put(
			"samlSpEntityId",
			(BiConsumer<SamlIdpSpConnection, String>)
				SamlIdpSpConnection::setSamlSpEntityId);
		attributeGetterFunctions.put(
			"assertionLifetime", SamlIdpSpConnection::getAssertionLifetime);
		attributeSetterBiConsumers.put(
			"assertionLifetime",
			(BiConsumer<SamlIdpSpConnection, Integer>)
				SamlIdpSpConnection::setAssertionLifetime);
		attributeGetterFunctions.put(
			"attributeNames", SamlIdpSpConnection::getAttributeNames);
		attributeSetterBiConsumers.put(
			"attributeNames",
			(BiConsumer<SamlIdpSpConnection, String>)
				SamlIdpSpConnection::setAttributeNames);
		attributeGetterFunctions.put(
			"attributesEnabled", SamlIdpSpConnection::getAttributesEnabled);
		attributeSetterBiConsumers.put(
			"attributesEnabled",
			(BiConsumer<SamlIdpSpConnection, Boolean>)
				SamlIdpSpConnection::setAttributesEnabled);
		attributeGetterFunctions.put(
			"attributesNamespaceEnabled",
			SamlIdpSpConnection::getAttributesNamespaceEnabled);
		attributeSetterBiConsumers.put(
			"attributesNamespaceEnabled",
			(BiConsumer<SamlIdpSpConnection, Boolean>)
				SamlIdpSpConnection::setAttributesNamespaceEnabled);
		attributeGetterFunctions.put(
			"enabled", SamlIdpSpConnection::getEnabled);
		attributeSetterBiConsumers.put(
			"enabled",
			(BiConsumer<SamlIdpSpConnection, Boolean>)
				SamlIdpSpConnection::setEnabled);
		attributeGetterFunctions.put(
			"encryptionForced", SamlIdpSpConnection::getEncryptionForced);
		attributeSetterBiConsumers.put(
			"encryptionForced",
			(BiConsumer<SamlIdpSpConnection, Boolean>)
				SamlIdpSpConnection::setEncryptionForced);
		attributeGetterFunctions.put(
			"metadataUrl", SamlIdpSpConnection::getMetadataUrl);
		attributeSetterBiConsumers.put(
			"metadataUrl",
			(BiConsumer<SamlIdpSpConnection, String>)
				SamlIdpSpConnection::setMetadataUrl);
		attributeGetterFunctions.put(
			"metadataXml", SamlIdpSpConnection::getMetadataXml);
		attributeSetterBiConsumers.put(
			"metadataXml",
			(BiConsumer<SamlIdpSpConnection, String>)
				SamlIdpSpConnection::setMetadataXml);
		attributeGetterFunctions.put(
			"metadataUpdatedDate", SamlIdpSpConnection::getMetadataUpdatedDate);
		attributeSetterBiConsumers.put(
			"metadataUpdatedDate",
			(BiConsumer<SamlIdpSpConnection, Date>)
				SamlIdpSpConnection::setMetadataUpdatedDate);
		attributeGetterFunctions.put("name", SamlIdpSpConnection::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<SamlIdpSpConnection, String>)
				SamlIdpSpConnection::setName);
		attributeGetterFunctions.put(
			"nameIdAttribute", SamlIdpSpConnection::getNameIdAttribute);
		attributeSetterBiConsumers.put(
			"nameIdAttribute",
			(BiConsumer<SamlIdpSpConnection, String>)
				SamlIdpSpConnection::setNameIdAttribute);
		attributeGetterFunctions.put(
			"nameIdFormat", SamlIdpSpConnection::getNameIdFormat);
		attributeSetterBiConsumers.put(
			"nameIdFormat",
			(BiConsumer<SamlIdpSpConnection, String>)
				SamlIdpSpConnection::setNameIdFormat);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getSamlIdpSpConnectionId() {
		return _samlIdpSpConnectionId;
	}

	@Override
	public void setSamlIdpSpConnectionId(long samlIdpSpConnectionId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("samlIdpSpConnectionId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_samlIdpSpConnectionId = samlIdpSpConnectionId;
	}

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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(getColumnOriginalValue("companyId"));
	}

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

	@Override
	public String getSamlSpEntityId() {
		if (_samlSpEntityId == null) {
			return "";
		}
		else {
			return _samlSpEntityId;
		}
	}

	@Override
	public void setSamlSpEntityId(String samlSpEntityId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("samlSpEntityId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_samlSpEntityId = samlSpEntityId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalSamlSpEntityId() {
		return getColumnOriginalValue("samlSpEntityId");
	}

	@Override
	public int getAssertionLifetime() {
		return _assertionLifetime;
	}

	@Override
	public void setAssertionLifetime(int assertionLifetime) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("assertionLifetime");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_assertionLifetime = assertionLifetime;
	}

	@Override
	public String getAttributeNames() {
		if (_attributeNames == null) {
			return "";
		}
		else {
			return _attributeNames;
		}
	}

	@Override
	public void setAttributeNames(String attributeNames) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("attributeNames");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_attributeNames = attributeNames;
	}

	@Override
	public boolean getAttributesEnabled() {
		return _attributesEnabled;
	}

	@Override
	public boolean isAttributesEnabled() {
		return _attributesEnabled;
	}

	@Override
	public void setAttributesEnabled(boolean attributesEnabled) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("attributesEnabled");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_attributesEnabled = attributesEnabled;
	}

	@Override
	public boolean getAttributesNamespaceEnabled() {
		return _attributesNamespaceEnabled;
	}

	@Override
	public boolean isAttributesNamespaceEnabled() {
		return _attributesNamespaceEnabled;
	}

	@Override
	public void setAttributesNamespaceEnabled(
		boolean attributesNamespaceEnabled) {

		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("attributesNamespaceEnabled");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_attributesNamespaceEnabled = attributesNamespaceEnabled;
	}

	@Override
	public boolean getEnabled() {
		return _enabled;
	}

	@Override
	public boolean isEnabled() {
		return _enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("enabled");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_enabled = enabled;
	}

	@Override
	public boolean getEncryptionForced() {
		return _encryptionForced;
	}

	@Override
	public boolean isEncryptionForced() {
		return _encryptionForced;
	}

	@Override
	public void setEncryptionForced(boolean encryptionForced) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("encryptionForced");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_encryptionForced = encryptionForced;
	}

	@Override
	public String getMetadataUrl() {
		if (_metadataUrl == null) {
			return "";
		}
		else {
			return _metadataUrl;
		}
	}

	@Override
	public void setMetadataUrl(String metadataUrl) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("metadataUrl");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_metadataUrl = metadataUrl;
	}

	@Override
	public String getMetadataXml() {
		if (_metadataXml == null) {
			return "";
		}
		else {
			return _metadataXml;
		}
	}

	@Override
	public void setMetadataXml(String metadataXml) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("metadataXml");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_metadataXml = metadataXml;
	}

	@Override
	public Date getMetadataUpdatedDate() {
		return _metadataUpdatedDate;
	}

	@Override
	public void setMetadataUpdatedDate(Date metadataUpdatedDate) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("metadataUpdatedDate");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_metadataUpdatedDate = metadataUpdatedDate;
	}

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

	@Override
	public String getNameIdAttribute() {
		if (_nameIdAttribute == null) {
			return "";
		}
		else {
			return _nameIdAttribute;
		}
	}

	@Override
	public void setNameIdAttribute(String nameIdAttribute) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("nameIdAttribute");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_nameIdAttribute = nameIdAttribute;
	}

	@Override
	public String getNameIdFormat() {
		if (_nameIdFormat == null) {
			return "";
		}
		else {
			return _nameIdFormat;
		}
	}

	@Override
	public void setNameIdFormat(String nameIdFormat) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("nameIdFormat");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_nameIdFormat = nameIdFormat;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), SamlIdpSpConnection.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SamlIdpSpConnection toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SamlIdpSpConnection>
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
		SamlIdpSpConnectionImpl samlIdpSpConnectionImpl =
			new SamlIdpSpConnectionImpl();

		samlIdpSpConnectionImpl.setSamlIdpSpConnectionId(
			getSamlIdpSpConnectionId());
		samlIdpSpConnectionImpl.setCompanyId(getCompanyId());
		samlIdpSpConnectionImpl.setUserId(getUserId());
		samlIdpSpConnectionImpl.setUserName(getUserName());
		samlIdpSpConnectionImpl.setCreateDate(getCreateDate());
		samlIdpSpConnectionImpl.setModifiedDate(getModifiedDate());
		samlIdpSpConnectionImpl.setSamlSpEntityId(getSamlSpEntityId());
		samlIdpSpConnectionImpl.setAssertionLifetime(getAssertionLifetime());
		samlIdpSpConnectionImpl.setAttributeNames(getAttributeNames());
		samlIdpSpConnectionImpl.setAttributesEnabled(isAttributesEnabled());
		samlIdpSpConnectionImpl.setAttributesNamespaceEnabled(
			isAttributesNamespaceEnabled());
		samlIdpSpConnectionImpl.setEnabled(isEnabled());
		samlIdpSpConnectionImpl.setEncryptionForced(isEncryptionForced());
		samlIdpSpConnectionImpl.setMetadataUrl(getMetadataUrl());
		samlIdpSpConnectionImpl.setMetadataXml(getMetadataXml());
		samlIdpSpConnectionImpl.setMetadataUpdatedDate(
			getMetadataUpdatedDate());
		samlIdpSpConnectionImpl.setName(getName());
		samlIdpSpConnectionImpl.setNameIdAttribute(getNameIdAttribute());
		samlIdpSpConnectionImpl.setNameIdFormat(getNameIdFormat());

		samlIdpSpConnectionImpl.resetOriginalValues();

		return samlIdpSpConnectionImpl;
	}

	@Override
	public int compareTo(SamlIdpSpConnection samlIdpSpConnection) {
		long primaryKey = samlIdpSpConnection.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SamlIdpSpConnection)) {
			return false;
		}

		SamlIdpSpConnection samlIdpSpConnection = (SamlIdpSpConnection)object;

		long primaryKey = samlIdpSpConnection.getPrimaryKey();

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
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<SamlIdpSpConnection> toCacheModel() {
		SamlIdpSpConnectionCacheModel samlIdpSpConnectionCacheModel =
			new SamlIdpSpConnectionCacheModel();

		samlIdpSpConnectionCacheModel.samlIdpSpConnectionId =
			getSamlIdpSpConnectionId();

		samlIdpSpConnectionCacheModel.companyId = getCompanyId();

		samlIdpSpConnectionCacheModel.userId = getUserId();

		samlIdpSpConnectionCacheModel.userName = getUserName();

		String userName = samlIdpSpConnectionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			samlIdpSpConnectionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			samlIdpSpConnectionCacheModel.createDate = createDate.getTime();
		}
		else {
			samlIdpSpConnectionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			samlIdpSpConnectionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			samlIdpSpConnectionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		samlIdpSpConnectionCacheModel.samlSpEntityId = getSamlSpEntityId();

		String samlSpEntityId = samlIdpSpConnectionCacheModel.samlSpEntityId;

		if ((samlSpEntityId != null) && (samlSpEntityId.length() == 0)) {
			samlIdpSpConnectionCacheModel.samlSpEntityId = null;
		}

		samlIdpSpConnectionCacheModel.assertionLifetime =
			getAssertionLifetime();

		samlIdpSpConnectionCacheModel.attributeNames = getAttributeNames();

		String attributeNames = samlIdpSpConnectionCacheModel.attributeNames;

		if ((attributeNames != null) && (attributeNames.length() == 0)) {
			samlIdpSpConnectionCacheModel.attributeNames = null;
		}

		samlIdpSpConnectionCacheModel.attributesEnabled = isAttributesEnabled();

		samlIdpSpConnectionCacheModel.attributesNamespaceEnabled =
			isAttributesNamespaceEnabled();

		samlIdpSpConnectionCacheModel.enabled = isEnabled();

		samlIdpSpConnectionCacheModel.encryptionForced = isEncryptionForced();

		samlIdpSpConnectionCacheModel.metadataUrl = getMetadataUrl();

		String metadataUrl = samlIdpSpConnectionCacheModel.metadataUrl;

		if ((metadataUrl != null) && (metadataUrl.length() == 0)) {
			samlIdpSpConnectionCacheModel.metadataUrl = null;
		}

		samlIdpSpConnectionCacheModel.metadataXml = getMetadataXml();

		String metadataXml = samlIdpSpConnectionCacheModel.metadataXml;

		if ((metadataXml != null) && (metadataXml.length() == 0)) {
			samlIdpSpConnectionCacheModel.metadataXml = null;
		}

		Date metadataUpdatedDate = getMetadataUpdatedDate();

		if (metadataUpdatedDate != null) {
			samlIdpSpConnectionCacheModel.metadataUpdatedDate =
				metadataUpdatedDate.getTime();
		}
		else {
			samlIdpSpConnectionCacheModel.metadataUpdatedDate = Long.MIN_VALUE;
		}

		samlIdpSpConnectionCacheModel.name = getName();

		String name = samlIdpSpConnectionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			samlIdpSpConnectionCacheModel.name = null;
		}

		samlIdpSpConnectionCacheModel.nameIdAttribute = getNameIdAttribute();

		String nameIdAttribute = samlIdpSpConnectionCacheModel.nameIdAttribute;

		if ((nameIdAttribute != null) && (nameIdAttribute.length() == 0)) {
			samlIdpSpConnectionCacheModel.nameIdAttribute = null;
		}

		samlIdpSpConnectionCacheModel.nameIdFormat = getNameIdFormat();

		String nameIdFormat = samlIdpSpConnectionCacheModel.nameIdFormat;

		if ((nameIdFormat != null) && (nameIdFormat.length() == 0)) {
			samlIdpSpConnectionCacheModel.nameIdFormat = null;
		}

		return samlIdpSpConnectionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SamlIdpSpConnection, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SamlIdpSpConnection, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SamlIdpSpConnection, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SamlIdpSpConnection)this));
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
		Map<String, Function<SamlIdpSpConnection, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SamlIdpSpConnection, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SamlIdpSpConnection, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SamlIdpSpConnection)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SamlIdpSpConnection>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _samlIdpSpConnectionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _samlSpEntityId;
	private int _assertionLifetime;
	private String _attributeNames;
	private boolean _attributesEnabled;
	private boolean _attributesNamespaceEnabled;
	private boolean _enabled;
	private boolean _encryptionForced;
	private String _metadataUrl;
	private String _metadataXml;
	private Date _metadataUpdatedDate;
	private String _name;
	private String _nameIdAttribute;
	private String _nameIdFormat;

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

		_columnOriginalValues.put(
			"samlIdpSpConnectionId", _samlIdpSpConnectionId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("samlSpEntityId", _samlSpEntityId);
		_columnOriginalValues.put("assertionLifetime", _assertionLifetime);
		_columnOriginalValues.put("attributeNames", _attributeNames);
		_columnOriginalValues.put("attributesEnabled", _attributesEnabled);
		_columnOriginalValues.put(
			"attributesNamespaceEnabled", _attributesNamespaceEnabled);
		_columnOriginalValues.put("enabled", _enabled);
		_columnOriginalValues.put("encryptionForced", _encryptionForced);
		_columnOriginalValues.put("metadataUrl", _metadataUrl);
		_columnOriginalValues.put("metadataXml", _metadataXml);
		_columnOriginalValues.put("metadataUpdatedDate", _metadataUpdatedDate);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("nameIdAttribute", _nameIdAttribute);
		_columnOriginalValues.put("nameIdFormat", _nameIdFormat);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new LinkedHashMap<>();

		columnBitmasks.put("samlIdpSpConnectionId", 1L);

		columnBitmasks.put("companyId", 2L);

		columnBitmasks.put("userId", 4L);

		columnBitmasks.put("userName", 8L);

		columnBitmasks.put("createDate", 16L);

		columnBitmasks.put("modifiedDate", 32L);

		columnBitmasks.put("samlSpEntityId", 64L);

		columnBitmasks.put("assertionLifetime", 128L);

		columnBitmasks.put("attributeNames", 256L);

		columnBitmasks.put("attributesEnabled", 512L);

		columnBitmasks.put("attributesNamespaceEnabled", 1024L);

		columnBitmasks.put("enabled", 2048L);

		columnBitmasks.put("encryptionForced", 4096L);

		columnBitmasks.put("metadataUrl", 8192L);

		columnBitmasks.put("metadataXml", 16384L);

		columnBitmasks.put("metadataUpdatedDate", 32768L);

		columnBitmasks.put("name", 65536L);

		columnBitmasks.put("nameIdAttribute", 131072L);

		columnBitmasks.put("nameIdFormat", 262144L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private transient Map<String, Object> _columnOriginalValues;
	private long _columnBitmask;
	private SamlIdpSpConnection _escapedModel;

}