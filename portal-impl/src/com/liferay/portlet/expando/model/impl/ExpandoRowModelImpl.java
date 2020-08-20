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

package com.liferay.portlet.expando.model.impl;

import com.liferay.expando.kernel.model.ExpandoRow;
import com.liferay.expando.kernel.model.ExpandoRowModel;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

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
 * The base model implementation for the ExpandoRow service. Represents a row in the &quot;ExpandoRow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ExpandoRowModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExpandoRowImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoRowImpl
 * @generated
 */
public class ExpandoRowModelImpl
	extends BaseModelImpl<ExpandoRow> implements ExpandoRowModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a expando row model instance should use the <code>ExpandoRow</code> interface instead.
	 */
	public static final String TABLE_NAME = "ExpandoRow";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"ctCollectionId", Types.BIGINT},
		{"rowId_", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"modifiedDate", Types.TIMESTAMP}, {"tableId", Types.BIGINT},
		{"classPK", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ctCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("rowId_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("tableId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ExpandoRow (mvccVersion LONG default 0 not null,ctCollectionId LONG default 0 not null,rowId_ LONG not null,companyId LONG,modifiedDate DATE null,tableId LONG,classPK LONG,primary key (rowId_, ctCollectionId))";

	public static final String TABLE_SQL_DROP = "drop table ExpandoRow";

	public static final String ORDER_BY_JPQL = " ORDER BY expandoRow.rowId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY ExpandoRow.rowId_ ASC";

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
	public static final long CLASSPK_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long TABLEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ROWID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.expando.kernel.model.ExpandoRow"));

	public ExpandoRowModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _rowId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRowId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rowId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ExpandoRow.class;
	}

	@Override
	public String getModelClassName() {
		return ExpandoRow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ExpandoRow, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ExpandoRow, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExpandoRow, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((ExpandoRow)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ExpandoRow, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ExpandoRow, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ExpandoRow)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ExpandoRow, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ExpandoRow, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ExpandoRow>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ExpandoRow.class.getClassLoader(), ExpandoRow.class,
			ModelWrapper.class);

		try {
			Constructor<ExpandoRow> constructor =
				(Constructor<ExpandoRow>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ExpandoRow, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ExpandoRow, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ExpandoRow, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ExpandoRow, Object>>();
		Map<String, BiConsumer<ExpandoRow, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ExpandoRow, ?>>();

		attributeGetterFunctions.put("mvccVersion", ExpandoRow::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<ExpandoRow, Long>)ExpandoRow::setMvccVersion);
		attributeGetterFunctions.put(
			"ctCollectionId", ExpandoRow::getCtCollectionId);
		attributeSetterBiConsumers.put(
			"ctCollectionId",
			(BiConsumer<ExpandoRow, Long>)ExpandoRow::setCtCollectionId);
		attributeGetterFunctions.put("rowId", ExpandoRow::getRowId);
		attributeSetterBiConsumers.put(
			"rowId", (BiConsumer<ExpandoRow, Long>)ExpandoRow::setRowId);
		attributeGetterFunctions.put("companyId", ExpandoRow::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ExpandoRow, Long>)ExpandoRow::setCompanyId);
		attributeGetterFunctions.put(
			"modifiedDate", ExpandoRow::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ExpandoRow, Date>)ExpandoRow::setModifiedDate);
		attributeGetterFunctions.put("tableId", ExpandoRow::getTableId);
		attributeSetterBiConsumers.put(
			"tableId", (BiConsumer<ExpandoRow, Long>)ExpandoRow::setTableId);
		attributeGetterFunctions.put("classPK", ExpandoRow::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK", (BiConsumer<ExpandoRow, Long>)ExpandoRow::setClassPK);

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
	public long getRowId() {
		return _rowId;
	}

	@Override
	public void setRowId(long rowId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("rowId_");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_rowId = rowId;
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

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("modifiedDate");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getTableId() {
		return _tableId;
	}

	@Override
	public void setTableId(long tableId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("tableId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_tableId = tableId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalTableId() {
		return GetterUtil.getLong(getColumnOriginalValue("tableId"));
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("classPK");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_classPK = classPK;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassPK() {
		return GetterUtil.getLong(getColumnOriginalValue("classPK"));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoRow toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ExpandoRow>
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
		ExpandoRowImpl expandoRowImpl = new ExpandoRowImpl();

		expandoRowImpl.setMvccVersion(getMvccVersion());
		expandoRowImpl.setCtCollectionId(getCtCollectionId());
		expandoRowImpl.setRowId(getRowId());
		expandoRowImpl.setCompanyId(getCompanyId());
		expandoRowImpl.setModifiedDate(getModifiedDate());
		expandoRowImpl.setTableId(getTableId());
		expandoRowImpl.setClassPK(getClassPK());

		expandoRowImpl.resetOriginalValues();

		return expandoRowImpl;
	}

	@Override
	public int compareTo(ExpandoRow expandoRow) {
		long primaryKey = expandoRow.getPrimaryKey();

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

		if (!(object instanceof ExpandoRow)) {
			return false;
		}

		ExpandoRow expandoRow = (ExpandoRow)object;

		long primaryKey = expandoRow.getPrimaryKey();

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

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ExpandoRow> toCacheModel() {
		ExpandoRowCacheModel expandoRowCacheModel = new ExpandoRowCacheModel();

		expandoRowCacheModel.mvccVersion = getMvccVersion();

		expandoRowCacheModel.ctCollectionId = getCtCollectionId();

		expandoRowCacheModel.rowId = getRowId();

		expandoRowCacheModel.companyId = getCompanyId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			expandoRowCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			expandoRowCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		expandoRowCacheModel.tableId = getTableId();

		expandoRowCacheModel.classPK = getClassPK();

		return expandoRowCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ExpandoRow, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ExpandoRow, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExpandoRow, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ExpandoRow)this));
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
		Map<String, Function<ExpandoRow, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ExpandoRow, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExpandoRow, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ExpandoRow)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ExpandoRow>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _ctCollectionId;
	private long _rowId;
	private long _companyId;
	private Date _modifiedDate;
	private long _tableId;
	private long _classPK;

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
		_columnOriginalValues.put("rowId_", _rowId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("tableId", _tableId);
		_columnOriginalValues.put("classPK", _classPK);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new LinkedHashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("ctCollectionId", 2L);

		columnBitmasks.put("rowId_", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("modifiedDate", 16L);

		columnBitmasks.put("tableId", 32L);

		columnBitmasks.put("classPK", 64L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private transient Map<String, Object> _columnOriginalValues;
	private long _columnBitmask;
	private ExpandoRow _escapedModel;

}