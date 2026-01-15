/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.audit.model.impl;

import com.liferay.audit.model.AuditEntry;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AuditEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuditEntryCacheModel
	implements CacheModel<AuditEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AuditEntryCacheModel)) {
			return false;
		}

		AuditEntryCacheModel auditEntryCacheModel =
			(AuditEntryCacheModel)object;

		if (auditEntryId == auditEntryCacheModel.auditEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, auditEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", auditEntryId=");
		sb.append(auditEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", entityName=");
		sb.append(entityName);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", fieldName=");
		sb.append(fieldName);
		sb.append(", oldValue=");
		sb.append(oldValue);
		sb.append(", newValue=");
		sb.append(newValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AuditEntry toEntityModel() {
		AuditEntryImpl auditEntryImpl = new AuditEntryImpl();

		if (uuid == null) {
			auditEntryImpl.setUuid("");
		}
		else {
			auditEntryImpl.setUuid(uuid);
		}

		auditEntryImpl.setAuditEntryId(auditEntryId);
		auditEntryImpl.setGroupId(groupId);
		auditEntryImpl.setCompanyId(companyId);
		auditEntryImpl.setUserId(userId);

		if (userName == null) {
			auditEntryImpl.setUserName("");
		}
		else {
			auditEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			auditEntryImpl.setCreateDate(null);
		}
		else {
			auditEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			auditEntryImpl.setModifiedDate(null);
		}
		else {
			auditEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (entityName == null) {
			auditEntryImpl.setEntityName("");
		}
		else {
			auditEntryImpl.setEntityName(entityName);
		}

		auditEntryImpl.setEntityId(entityId);

		if (action == null) {
			auditEntryImpl.setAction("");
		}
		else {
			auditEntryImpl.setAction(action);
		}

		if (fieldName == null) {
			auditEntryImpl.setFieldName("");
		}
		else {
			auditEntryImpl.setFieldName(fieldName);
		}

		if (oldValue == null) {
			auditEntryImpl.setOldValue("");
		}
		else {
			auditEntryImpl.setOldValue(oldValue);
		}

		if (newValue == null) {
			auditEntryImpl.setNewValue("");
		}
		else {
			auditEntryImpl.setNewValue(newValue);
		}

		auditEntryImpl.resetOriginalValues();

		return auditEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		auditEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		entityName = objectInput.readUTF();

		entityId = objectInput.readLong();
		action = objectInput.readUTF();
		fieldName = objectInput.readUTF();
		oldValue = objectInput.readUTF();
		newValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(auditEntryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (entityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(entityName);
		}

		objectOutput.writeLong(entityId);

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (fieldName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fieldName);
		}

		if (oldValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oldValue);
		}

		if (newValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(newValue);
		}
	}

	public String uuid;
	public long auditEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String entityName;
	public long entityId;
	public String action;
	public String fieldName;
	public String oldValue;
	public String newValue;

}