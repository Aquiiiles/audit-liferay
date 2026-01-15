/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.audit.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AUDIT_AuditEntry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntry
 * @generated
 */
public class AuditEntryTable extends BaseTable<AuditEntryTable> {

	public static final AuditEntryTable INSTANCE = new AuditEntryTable();

	public final Column<AuditEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, Long> auditEntryId = createColumn(
		"auditEntryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AuditEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, String> entityName = createColumn(
		"entityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, String> action = createColumn(
		"action", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, String> fieldName = createColumn(
		"fieldName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, String> oldValue = createColumn(
		"oldValue", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AuditEntryTable, String> newValue = createColumn(
		"newValue", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AuditEntryTable() {
		super("AUDIT_AuditEntry", AuditEntryTable::new);
	}

}