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

package com.liferay.commerce.product.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CPDisplayLayout service. Represents a row in the &quot;CPDisplayLayout&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.product.model.impl.CPDisplayLayoutModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.product.model.impl.CPDisplayLayoutImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CPDisplayLayout
 * @see com.liferay.commerce.product.model.impl.CPDisplayLayoutImpl
 * @see com.liferay.commerce.product.model.impl.CPDisplayLayoutModelImpl
 * @generated
 */
@ProviderType
public interface CPDisplayLayoutModel extends AttachedModel,
	BaseModel<CPDisplayLayout>, GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cp display layout model instance should use the {@link CPDisplayLayout} interface instead.
	 */

	/**
	 * Returns the primary key of this cp display layout.
	 *
	 * @return the primary key of this cp display layout
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cp display layout.
	 *
	 * @param primaryKey the primary key of this cp display layout
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this cp display layout.
	 *
	 * @return the uuid of this cp display layout
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this cp display layout.
	 *
	 * @param uuid the uuid of this cp display layout
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the cp friendly url entry ID of this cp display layout.
	 *
	 * @return the cp friendly url entry ID of this cp display layout
	 */
	public long getCPFriendlyURLEntryId();

	/**
	 * Sets the cp friendly url entry ID of this cp display layout.
	 *
	 * @param CPFriendlyURLEntryId the cp friendly url entry ID of this cp display layout
	 */
	public void setCPFriendlyURLEntryId(long CPFriendlyURLEntryId);

	/**
	 * Returns the group ID of this cp display layout.
	 *
	 * @return the group ID of this cp display layout
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this cp display layout.
	 *
	 * @param groupId the group ID of this cp display layout
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this cp display layout.
	 *
	 * @return the company ID of this cp display layout
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this cp display layout.
	 *
	 * @param companyId the company ID of this cp display layout
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this cp display layout.
	 *
	 * @return the user ID of this cp display layout
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this cp display layout.
	 *
	 * @param userId the user ID of this cp display layout
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this cp display layout.
	 *
	 * @return the user uuid of this cp display layout
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this cp display layout.
	 *
	 * @param userUuid the user uuid of this cp display layout
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this cp display layout.
	 *
	 * @return the user name of this cp display layout
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this cp display layout.
	 *
	 * @param userName the user name of this cp display layout
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this cp display layout.
	 *
	 * @return the create date of this cp display layout
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this cp display layout.
	 *
	 * @param createDate the create date of this cp display layout
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this cp display layout.
	 *
	 * @return the modified date of this cp display layout
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this cp display layout.
	 *
	 * @param modifiedDate the modified date of this cp display layout
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this cp display layout.
	 *
	 * @return the fully qualified class name of this cp display layout
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this cp display layout.
	 *
	 * @return the class name ID of this cp display layout
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this cp display layout.
	 *
	 * @param classNameId the class name ID of this cp display layout
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this cp display layout.
	 *
	 * @return the class pk of this cp display layout
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this cp display layout.
	 *
	 * @param classPK the class pk of this cp display layout
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the layout uuid of this cp display layout.
	 *
	 * @return the layout uuid of this cp display layout
	 */
	@AutoEscape
	public String getLayoutUuid();

	/**
	 * Sets the layout uuid of this cp display layout.
	 *
	 * @param layoutUuid the layout uuid of this cp display layout
	 */
	public void setLayoutUuid(String layoutUuid);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(CPDisplayLayout cpDisplayLayout);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CPDisplayLayout> toCacheModel();

	@Override
	public CPDisplayLayout toEscapedModel();

	@Override
	public CPDisplayLayout toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}