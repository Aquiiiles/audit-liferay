/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc.
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package pdi.audit.web.internal.listener;

import com.liferay.audit.service.AuditEntryLocalService;
import com.liferay.object.model.ObjectEntry;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Aquiles Duarte
 */
@Component(service = ModelListener.class)
public class ObjectEntryAuditListener
        extends BaseModelListener<ObjectEntry> {

    @Override
    public void onAfterCreate(ObjectEntry objectEntry)
            throws ModelListenerException {

        ServiceContext serviceContext =
                ServiceContextThreadLocal.getServiceContext();

        if (serviceContext == null) {
            return;
        }

        try {
            _auditEntryLocalService.addAuditEntry(
                    serviceContext,
                    objectEntry.getModelClassName(),
                    objectEntry.getObjectEntryId(),
                    "CREATED",
                    null,
                    null,
                    objectEntry.getTitleValue()
            );
        }
        catch (PortalException exception) {
            throw new ModelListenerException(exception);
        }
    }

    @Override
    public void onAfterUpdate(
            ObjectEntry originalObjectEntry,
            ObjectEntry objectEntry)
            throws ModelListenerException {

        ServiceContext serviceContext =
                ServiceContextThreadLocal.getServiceContext();

        if (serviceContext == null) {
            return;
        }

        Map<String, Serializable> oldValues =
                originalObjectEntry.getValues();

        Map<String, Serializable> newValues =
                objectEntry.getValues();

        for (String fieldName : newValues.keySet()) {
            Serializable oldValue = oldValues.get(fieldName);
            Serializable newValue = newValues.get(fieldName);

            if (Objects.equals(oldValue, newValue)) {
                continue;
            }

            _auditEntryLocalService.addAuditEntry(
                    serviceContext,
                    objectEntry.getModelClassName(),
                    objectEntry.getObjectEntryId(),
                    "UPDATED",
                    fieldName,
                    (oldValue != null) ? oldValue.toString() : null,
                    (newValue != null) ? newValue.toString() : null
            );
        }
    }

    @Override
    public void onAfterRemove(ObjectEntry objectEntry)
            throws ModelListenerException {

        ServiceContext serviceContext =
                ServiceContextThreadLocal.getServiceContext();

        if (serviceContext == null) {
            return;
        }

        try {
            _auditEntryLocalService.addAuditEntry(
                    serviceContext,
                    objectEntry.getModelClassName(),
                    objectEntry.getObjectEntryId(),
                    "DELETED",
                    null,
                    objectEntry.getTitleValue(),
                    null
            );
        }
        catch (PortalException exception) {
            throw new ModelListenerException(exception);
        }
    }

    @Reference
    private AuditEntryLocalService _auditEntryLocalService;

}
