/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.audit.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAuditEntryException extends NoSuchModelException {

	public NoSuchAuditEntryException() {
	}

	public NoSuchAuditEntryException(String msg) {
		super(msg);
	}

	public NoSuchAuditEntryException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAuditEntryException(Throwable throwable) {
		super(throwable);
	}

}