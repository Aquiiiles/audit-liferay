/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.audit.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuditEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntry
 * @generated
 */
public class AuditEntryWrapper
	extends BaseModelWrapper<AuditEntry>
	implements AuditEntry, ModelWrapper<AuditEntry> {

	public AuditEntryWrapper(AuditEntry auditEntry) {
		super(auditEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("auditEntryId", getAuditEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entityName", getEntityName());
		attributes.put("entityId", getEntityId());
		attributes.put("action", getAction());
		attributes.put("fieldName", getFieldName());
		attributes.put("oldValue", getOldValue());
		attributes.put("newValue", getNewValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long auditEntryId = (Long)attributes.get("auditEntryId");

		if (auditEntryId != null) {
			setAuditEntryId(auditEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String entityName = (String)attributes.get("entityName");

		if (entityName != null) {
			setEntityName(entityName);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String fieldName = (String)attributes.get("fieldName");

		if (fieldName != null) {
			setFieldName(fieldName);
		}

		String oldValue = (String)attributes.get("oldValue");

		if (oldValue != null) {
			setOldValue(oldValue);
		}

		String newValue = (String)attributes.get("newValue");

		if (newValue != null) {
			setNewValue(newValue);
		}
	}

	@Override
	public AuditEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the action of this audit entry.
	 *
	 * @return the action of this audit entry
	 */
	@Override
	public String getAction() {
		return model.getAction();
	}

	/**
	 * Returns the audit entry ID of this audit entry.
	 *
	 * @return the audit entry ID of this audit entry
	 */
	@Override
	public long getAuditEntryId() {
		return model.getAuditEntryId();
	}

	/**
	 * Returns the company ID of this audit entry.
	 *
	 * @return the company ID of this audit entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this audit entry.
	 *
	 * @return the create date of this audit entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this audit entry.
	 *
	 * @return the entity ID of this audit entry
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the entity name of this audit entry.
	 *
	 * @return the entity name of this audit entry
	 */
	@Override
	public String getEntityName() {
		return model.getEntityName();
	}

	/**
	 * Returns the field name of this audit entry.
	 *
	 * @return the field name of this audit entry
	 */
	@Override
	public String getFieldName() {
		return model.getFieldName();
	}

	/**
	 * Returns the group ID of this audit entry.
	 *
	 * @return the group ID of this audit entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this audit entry.
	 *
	 * @return the modified date of this audit entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the new value of this audit entry.
	 *
	 * @return the new value of this audit entry
	 */
	@Override
	public String getNewValue() {
		return model.getNewValue();
	}

	/**
	 * Returns the old value of this audit entry.
	 *
	 * @return the old value of this audit entry
	 */
	@Override
	public String getOldValue() {
		return model.getOldValue();
	}

	/**
	 * Returns the primary key of this audit entry.
	 *
	 * @return the primary key of this audit entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this audit entry.
	 *
	 * @return the user ID of this audit entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this audit entry.
	 *
	 * @return the user name of this audit entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this audit entry.
	 *
	 * @return the user uuid of this audit entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this audit entry.
	 *
	 * @return the uuid of this audit entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action of this audit entry.
	 *
	 * @param action the action of this audit entry
	 */
	@Override
	public void setAction(String action) {
		model.setAction(action);
	}

	/**
	 * Sets the audit entry ID of this audit entry.
	 *
	 * @param auditEntryId the audit entry ID of this audit entry
	 */
	@Override
	public void setAuditEntryId(long auditEntryId) {
		model.setAuditEntryId(auditEntryId);
	}

	/**
	 * Sets the company ID of this audit entry.
	 *
	 * @param companyId the company ID of this audit entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this audit entry.
	 *
	 * @param createDate the create date of this audit entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this audit entry.
	 *
	 * @param entityId the entity ID of this audit entry
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the entity name of this audit entry.
	 *
	 * @param entityName the entity name of this audit entry
	 */
	@Override
	public void setEntityName(String entityName) {
		model.setEntityName(entityName);
	}

	/**
	 * Sets the field name of this audit entry.
	 *
	 * @param fieldName the field name of this audit entry
	 */
	@Override
	public void setFieldName(String fieldName) {
		model.setFieldName(fieldName);
	}

	/**
	 * Sets the group ID of this audit entry.
	 *
	 * @param groupId the group ID of this audit entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this audit entry.
	 *
	 * @param modifiedDate the modified date of this audit entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the new value of this audit entry.
	 *
	 * @param newValue the new value of this audit entry
	 */
	@Override
	public void setNewValue(String newValue) {
		model.setNewValue(newValue);
	}

	/**
	 * Sets the old value of this audit entry.
	 *
	 * @param oldValue the old value of this audit entry
	 */
	@Override
	public void setOldValue(String oldValue) {
		model.setOldValue(oldValue);
	}

	/**
	 * Sets the primary key of this audit entry.
	 *
	 * @param primaryKey the primary key of this audit entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this audit entry.
	 *
	 * @param userId the user ID of this audit entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this audit entry.
	 *
	 * @param userName the user name of this audit entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this audit entry.
	 *
	 * @param userUuid the user uuid of this audit entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this audit entry.
	 *
	 * @param uuid the uuid of this audit entry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AuditEntryWrapper wrap(AuditEntry auditEntry) {
		return new AuditEntryWrapper(auditEntry);
	}

}