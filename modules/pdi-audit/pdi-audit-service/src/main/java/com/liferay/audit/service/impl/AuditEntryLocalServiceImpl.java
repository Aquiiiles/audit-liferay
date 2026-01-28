/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.audit.service.impl;

import com.liferay.audit.model.AuditEntry;
import com.liferay.audit.service.base.AuditEntryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.audit.model.AuditEntry",
	service = AopService.class
)
public class AuditEntryLocalServiceImpl
		extends AuditEntryLocalServiceBaseImpl {

	public AuditEntry addAuditEntry(
			ServiceContext serviceContext,
			String entityName,
			long entityId,
			String action,
			String fieldName,
			String oldValue,
			String newValue) {

		long auditEntryId = counterLocalService.increment();

		AuditEntry auditEntry =
				auditEntryPersistence.create(auditEntryId);

		auditEntry.setGroupId(serviceContext.getScopeGroupId());
		auditEntry.setCompanyId(serviceContext.getCompanyId());

		auditEntry.setUserId(serviceContext.getUserId());

		User user = _userLocalService.fetchUser(
				serviceContext.getUserId());

		if (user != null) {
			auditEntry.setUserName(user.getFullName());
		}

		auditEntry.setCreateDate(
				serviceContext.getCreateDate(new Date()));
		auditEntry.setModifiedDate(
				serviceContext.getModifiedDate(new Date()));

		auditEntry.setEntityName(entityName);
		auditEntry.setEntityId(entityId);

		auditEntry.setAction(action);
		auditEntry.setFieldName(fieldName);
		auditEntry.setOldValue(oldValue);
		auditEntry.setNewValue(newValue);

		return auditEntryPersistence.update(auditEntry);
	}

	public void deleteAuditEntriesByGroupId(long groupId) {
		auditEntryPersistence.removeByGroupId(groupId);
	}

	@Reference
	private UserLocalService _userLocalService;
}
