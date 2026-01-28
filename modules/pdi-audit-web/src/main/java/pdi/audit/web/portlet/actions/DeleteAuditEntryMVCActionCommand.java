package pdi.audit.web.portlet.actions;

import com.liferay.audit.service.AuditEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import com.liferay.portal.kernel.util.ParamUtil;
import jakarta.portlet.ActionRequest;
import jakarta.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import pdi.audit.web.constants.PdiAuditWebPortletKeys;

/**
 * @author Aquiles Duarte
 */
@Component(
        property = {
                "jakarta.portlet.name=" + PdiAuditWebPortletKeys.PDIAUDITWEB,
                "mvc.command.name=/audit/delete_entry"
        },
        service = MVCActionCommand.class
)
public class DeleteAuditEntryMVCActionCommand
        implements MVCActionCommand {

    @Override
    public boolean processAction(
            ActionRequest actionRequest,
            ActionResponse actionResponse) {

        long auditEntryId = ParamUtil.getLong(
                actionRequest, "auditEntryId");

        try {
            _auditEntryLocalService.deleteAuditEntry(auditEntryId);
        } catch (PortalException portalException) {
            throw new RuntimeException(portalException);
        }

        return true;
    }

    @Reference
    private AuditEntryLocalService _auditEntryLocalService;
}


