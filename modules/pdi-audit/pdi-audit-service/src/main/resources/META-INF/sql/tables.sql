create table AUDIT_AuditEntry (
	uuid_ VARCHAR(75) null,
	auditEntryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	entityName VARCHAR(75) null,
	entityId LONG,
	action VARCHAR(75) null,
	fieldName VARCHAR(75) null,
	oldValue VARCHAR(75) null,
	newValue VARCHAR(75) null
);