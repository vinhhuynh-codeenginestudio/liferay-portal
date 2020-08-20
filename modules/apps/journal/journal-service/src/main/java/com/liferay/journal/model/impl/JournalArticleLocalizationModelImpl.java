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

package com.liferay.journal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.journal.model.JournalArticleLocalization;
import com.liferay.journal.model.JournalArticleLocalizationModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the JournalArticleLocalization service. Represents a row in the &quot;JournalArticleLocalization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>JournalArticleLocalizationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalArticleLocalizationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleLocalizationImpl
 * @generated
 */
public class JournalArticleLocalizationModelImpl
	extends BaseModelImpl<JournalArticleLocalization>
	implements JournalArticleLocalizationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a journal article localization model instance should use the <code>JournalArticleLocalization</code> interface instead.
	 */
	public static final String TABLE_NAME = "JournalArticleLocalization";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"ctCollectionId", Types.BIGINT},
		{"articleLocalizationId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"articlePK", Types.BIGINT}, {"title", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"languageId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ctCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("articleLocalizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("articlePK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table JournalArticleLocalization (mvccVersion LONG default 0 not null,ctCollectionId LONG default 0 not null,articleLocalizationId LONG not null,companyId LONG,articlePK LONG,title VARCHAR(400) null,description STRING null,languageId VARCHAR(75) null,primary key (articleLocalizationId, ctCollectionId))";

	public static final String TABLE_SQL_DROP =
		"drop table JournalArticleLocalization";

	public static final String ORDER_BY_JPQL =
		" ORDER BY journalArticleLocalization.articleLocalizationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY JournalArticleLocalization.articleLocalizationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ARTICLEPK_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long LANGUAGEID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long TITLE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ARTICLELOCALIZATIONID_COLUMN_BITMASK = 16L;

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

	public JournalArticleLocalizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _articleLocalizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setArticleLocalizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _articleLocalizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JournalArticleLocalization.class;
	}

	@Override
	public String getModelClassName() {
		return JournalArticleLocalization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<JournalArticleLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<JournalArticleLocalization, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalArticleLocalization, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(JournalArticleLocalization)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<JournalArticleLocalization, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<JournalArticleLocalization, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(JournalArticleLocalization)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<JournalArticleLocalization, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<JournalArticleLocalization, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, JournalArticleLocalization>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			JournalArticleLocalization.class.getClassLoader(),
			JournalArticleLocalization.class, ModelWrapper.class);

		try {
			Constructor<JournalArticleLocalization> constructor =
				(Constructor<JournalArticleLocalization>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String, Function<JournalArticleLocalization, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<JournalArticleLocalization, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<JournalArticleLocalization, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<JournalArticleLocalization, Object>>();
		Map<String, BiConsumer<JournalArticleLocalization, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<JournalArticleLocalization, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", JournalArticleLocalization::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<JournalArticleLocalization, Long>)
				JournalArticleLocalization::setMvccVersion);
		attributeGetterFunctions.put(
			"ctCollectionId", JournalArticleLocalization::getCtCollectionId);
		attributeSetterBiConsumers.put(
			"ctCollectionId",
			(BiConsumer<JournalArticleLocalization, Long>)
				JournalArticleLocalization::setCtCollectionId);
		attributeGetterFunctions.put(
			"articleLocalizationId",
			JournalArticleLocalization::getArticleLocalizationId);
		attributeSetterBiConsumers.put(
			"articleLocalizationId",
			(BiConsumer<JournalArticleLocalization, Long>)
				JournalArticleLocalization::setArticleLocalizationId);
		attributeGetterFunctions.put(
			"companyId", JournalArticleLocalization::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<JournalArticleLocalization, Long>)
				JournalArticleLocalization::setCompanyId);
		attributeGetterFunctions.put(
			"articlePK", JournalArticleLocalization::getArticlePK);
		attributeSetterBiConsumers.put(
			"articlePK",
			(BiConsumer<JournalArticleLocalization, Long>)
				JournalArticleLocalization::setArticlePK);
		attributeGetterFunctions.put(
			"title", JournalArticleLocalization::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<JournalArticleLocalization, String>)
				JournalArticleLocalization::setTitle);
		attributeGetterFunctions.put(
			"description", JournalArticleLocalization::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<JournalArticleLocalization, String>)
				JournalArticleLocalization::setDescription);
		attributeGetterFunctions.put(
			"languageId", JournalArticleLocalization::getLanguageId);
		attributeSetterBiConsumers.put(
			"languageId",
			(BiConsumer<JournalArticleLocalization, String>)
				JournalArticleLocalization::setLanguageId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

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

	@Override
	public long getCtCollectionId() {
		return _ctCollectionId;
	}

	@Override
	public void setCtCollectionId(long ctCollectionId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("ctCollectionId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_ctCollectionId = ctCollectionId;
	}

	@Override
	public long getArticleLocalizationId() {
		return _articleLocalizationId;
	}

	@Override
	public void setArticleLocalizationId(long articleLocalizationId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("articleLocalizationId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_articleLocalizationId = articleLocalizationId;
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
	public long getArticlePK() {
		return _articlePK;
	}

	@Override
	public void setArticlePK(long articlePK) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("articlePK");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_articlePK = articlePK;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalArticlePK() {
		return GetterUtil.getLong(getColumnOriginalValue("articlePK"));
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("title");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_title = title;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTitle() {
		return getColumnOriginalValue("title");
	}

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

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("languageId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_languageId = languageId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLanguageId() {
		return getColumnOriginalValue("languageId");
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), JournalArticleLocalization.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JournalArticleLocalization toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, JournalArticleLocalization>
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
		JournalArticleLocalizationImpl journalArticleLocalizationImpl =
			new JournalArticleLocalizationImpl();

		journalArticleLocalizationImpl.setMvccVersion(getMvccVersion());
		journalArticleLocalizationImpl.setCtCollectionId(getCtCollectionId());
		journalArticleLocalizationImpl.setArticleLocalizationId(
			getArticleLocalizationId());
		journalArticleLocalizationImpl.setCompanyId(getCompanyId());
		journalArticleLocalizationImpl.setArticlePK(getArticlePK());
		journalArticleLocalizationImpl.setTitle(getTitle());
		journalArticleLocalizationImpl.setDescription(getDescription());
		journalArticleLocalizationImpl.setLanguageId(getLanguageId());

		journalArticleLocalizationImpl.resetOriginalValues();

		return journalArticleLocalizationImpl;
	}

	@Override
	public int compareTo(
		JournalArticleLocalization journalArticleLocalization) {

		long primaryKey = journalArticleLocalization.getPrimaryKey();

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

		if (!(object instanceof JournalArticleLocalization)) {
			return false;
		}

		JournalArticleLocalization journalArticleLocalization =
			(JournalArticleLocalization)object;

		long primaryKey = journalArticleLocalization.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<JournalArticleLocalization> toCacheModel() {
		JournalArticleLocalizationCacheModel
			journalArticleLocalizationCacheModel =
				new JournalArticleLocalizationCacheModel();

		journalArticleLocalizationCacheModel.mvccVersion = getMvccVersion();

		journalArticleLocalizationCacheModel.ctCollectionId =
			getCtCollectionId();

		journalArticleLocalizationCacheModel.articleLocalizationId =
			getArticleLocalizationId();

		journalArticleLocalizationCacheModel.companyId = getCompanyId();

		journalArticleLocalizationCacheModel.articlePK = getArticlePK();

		journalArticleLocalizationCacheModel.title = getTitle();

		String title = journalArticleLocalizationCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			journalArticleLocalizationCacheModel.title = null;
		}

		journalArticleLocalizationCacheModel.description = getDescription();

		String description = journalArticleLocalizationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			journalArticleLocalizationCacheModel.description = null;
		}

		journalArticleLocalizationCacheModel.languageId = getLanguageId();

		String languageId = journalArticleLocalizationCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			journalArticleLocalizationCacheModel.languageId = null;
		}

		return journalArticleLocalizationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<JournalArticleLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<JournalArticleLocalization, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalArticleLocalization, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(JournalArticleLocalization)this));
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
		Map<String, Function<JournalArticleLocalization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<JournalArticleLocalization, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalArticleLocalization, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(JournalArticleLocalization)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, JournalArticleLocalization>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _ctCollectionId;
	private long _articleLocalizationId;
	private long _companyId;
	private long _articlePK;
	private String _title;
	private String _description;
	private String _languageId;

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
		_columnOriginalValues.put("ctCollectionId", _ctCollectionId);
		_columnOriginalValues.put(
			"articleLocalizationId", _articleLocalizationId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("articlePK", _articlePK);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("languageId", _languageId);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new LinkedHashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("ctCollectionId", 2L);

		columnBitmasks.put("articleLocalizationId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("articlePK", 16L);

		columnBitmasks.put("title", 32L);

		columnBitmasks.put("description", 64L);

		columnBitmasks.put("languageId", 128L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private transient Map<String, Object> _columnOriginalValues;
	private long _columnBitmask;
	private JournalArticleLocalization _escapedModel;

}