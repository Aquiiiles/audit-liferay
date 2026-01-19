package pdi.audit.web.portlet;

import com.liferay.audit.model.AuditEntry;
import com.liferay.audit.service.AuditEntryLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import jakarta.portlet.Portlet;
import jakarta.portlet.PortletException;
import jakarta.portlet.RenderRequest;
import jakarta.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import pdi.audit.web.constants.PdiAuditWebPortletKeys;

/**
 * @author Aquiles Duarte
 */
@Component(
		property = {
				"jakarta.portlet.display-name=Audit Viewer",
				"jakarta.portlet.init-param.template-path=/",
				"jakarta.portlet.init-param.view-template=/view.jsp",
				"com.liferay.portlet.display-category=category.pdi",
				"com.liferay.portlet.instanceable=true",
				"jakarta.portlet.name=" + PdiAuditWebPortletKeys.PDIAUDITWEB,
				"jakarta.portlet.version=3.0",
				"jakarta.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class PdiAuditWebPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest,
			RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay =
				(ThemeDisplay)renderRequest.getAttribute(
						WebKeys.THEME_DISPLAY);

        ServiceContext serviceContext = null;
        try {
            serviceContext = ServiceContextFactory.getInstance(
                    AuditEntry.class.getName(), renderRequest);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        _auditEntryLocalService.addAuditEntry(
				serviceContext,
				"ManualTest",
				1L,
				"CREATE",
				"field",
				null,
				"value"
		);

		List<AuditEntry> auditEntries =
				_auditEntryLocalService.getAuditEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS
				);


		renderRequest.setAttribute("auditEntries", auditEntries);

		super.doView(renderRequest, renderResponse);
	}
	@Reference
	private AuditEntryLocalService _auditEntryLocalService;
}
