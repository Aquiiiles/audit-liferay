<%@ taglib uri="http://xmlns.jcp.org/portlet_3_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<h2>Audit Entries</h2>

<liferay-ui:search-container
	emptyResultsMessage="no-audit-entries"
	total="${auditEntriesTotal}"
	delta="20">

	<liferay-ui:search-container-results results="${auditEntries}" />

	<liferay-ui:search-container-row
		className="com.liferay.audit.model.AuditEntry"
		modelVar="auditEntry">

		<liferay-ui:search-container-column-text name="Entity"
			value="${auditEntry.entityName}" />

		<liferay-ui:search-container-column-text name="Entity ID"
			value="${auditEntry.entityId}" />

		<liferay-ui:search-container-column-text name="Action"
			value="${auditEntry.action}" />

		<liferay-ui:search-container-column-text name="Field"
			value="${auditEntry.fieldName}" />

		<liferay-ui:search-container-column-text name="Old Value"
			value="${auditEntry.oldValue}" />

		<liferay-ui:search-container-column-text name="New Value"
			value="${auditEntry.newValue}" />

		<liferay-ui:search-container-column-text name="User"
			value="${auditEntry.userName}" />

		<liferay-ui:search-container-column-date name="Date"
			value="${auditEntry.createDate}" />

		<liferay-ui:search-container-column-text name="Actions">
			<portlet:actionURL name="/audit/delete_entry" var="deleteAuditEntryURL">
				<portlet:param name="auditEntryId" value="${auditEntry.auditEntryId}" />
			</portlet:actionURL>

			<aui:form action="${deleteAuditEntryURL}" method="post">
				<aui:button
					type="submit"
					value="Delete"
					onClick="return confirm('Delete this audit entry?');"
				/>
			</aui:form>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
