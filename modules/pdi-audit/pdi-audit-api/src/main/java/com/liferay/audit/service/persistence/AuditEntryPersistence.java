/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.audit.service.persistence;

import com.liferay.audit.exception.NoSuchAuditEntryException;
import com.liferay.audit.model.AuditEntry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the audit entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryUtil
 * @generated
 */
@ProviderType
public interface AuditEntryPersistence extends BasePersistence<AuditEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditEntryUtil} to access the audit entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the audit entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching audit entries
	 */
	public java.util.List<AuditEntry> findByUuid(String uuid);

	/**
	 * Returns a range of all the audit entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the audit entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the audit entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	public AuditEntry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the first audit entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	public AuditEntry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns the last audit entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	public AuditEntry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the last audit entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	public AuditEntry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns the audit entries before and after the current audit entry in the ordered set where uuid = &#63;.
	 *
	 * @param auditEntryId the primary key of the current audit entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	public AuditEntry[] findByUuid_PrevAndNext(
			long auditEntryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Removes all the audit entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of audit entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching audit entries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the audit entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuditEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	public AuditEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the audit entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	public AuditEntry fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the audit entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	public AuditEntry fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the audit entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the audit entry that was removed
	 */
	public AuditEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the number of audit entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching audit entries
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the audit entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching audit entries
	 */
	public java.util.List<AuditEntry> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the audit entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the audit entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the audit entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	public AuditEntry findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the first audit entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	public AuditEntry fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns the last audit entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	public AuditEntry findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the last audit entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	public AuditEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns the audit entries before and after the current audit entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param auditEntryId the primary key of the current audit entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	public AuditEntry[] findByUuid_C_PrevAndNext(
			long auditEntryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Removes all the audit entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of audit entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching audit entries
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the audit entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching audit entries
	 */
	public java.util.List<AuditEntry> findByGroupId(long groupId);

	/**
	 * Returns a range of all the audit entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the audit entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the audit entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching audit entries
	 */
	public java.util.List<AuditEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first audit entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	public AuditEntry findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the first audit entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	public AuditEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns the last audit entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry
	 * @throws NoSuchAuditEntryException if a matching audit entry could not be found
	 */
	public AuditEntry findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the last audit entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching audit entry, or <code>null</code> if a matching audit entry could not be found
	 */
	public AuditEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns the audit entries before and after the current audit entry in the ordered set where groupId = &#63;.
	 *
	 * @param auditEntryId the primary key of the current audit entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	public AuditEntry[] findByGroupId_PrevAndNext(
			long auditEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
				orderByComparator)
		throws NoSuchAuditEntryException;

	/**
	 * Removes all the audit entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of audit entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching audit entries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the audit entry in the entity cache if it is enabled.
	 *
	 * @param auditEntry the audit entry
	 */
	public void cacheResult(AuditEntry auditEntry);

	/**
	 * Caches the audit entries in the entity cache if it is enabled.
	 *
	 * @param auditEntries the audit entries
	 */
	public void cacheResult(java.util.List<AuditEntry> auditEntries);

	/**
	 * Creates a new audit entry with the primary key. Does not add the audit entry to the database.
	 *
	 * @param auditEntryId the primary key for the new audit entry
	 * @return the new audit entry
	 */
	public AuditEntry create(long auditEntryId);

	/**
	 * Removes the audit entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param auditEntryId the primary key of the audit entry
	 * @return the audit entry that was removed
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	public AuditEntry remove(long auditEntryId)
		throws NoSuchAuditEntryException;

	public AuditEntry updateImpl(AuditEntry auditEntry);

	/**
	 * Returns the audit entry with the primary key or throws a <code>NoSuchAuditEntryException</code> if it could not be found.
	 *
	 * @param auditEntryId the primary key of the audit entry
	 * @return the audit entry
	 * @throws NoSuchAuditEntryException if a audit entry with the primary key could not be found
	 */
	public AuditEntry findByPrimaryKey(long auditEntryId)
		throws NoSuchAuditEntryException;

	/**
	 * Returns the audit entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param auditEntryId the primary key of the audit entry
	 * @return the audit entry, or <code>null</code> if a audit entry with the primary key could not be found
	 */
	public AuditEntry fetchByPrimaryKey(long auditEntryId);

	/**
	 * Returns all the audit entries.
	 *
	 * @return the audit entries
	 */
	public java.util.List<AuditEntry> findAll();

	/**
	 * Returns a range of all the audit entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @return the range of audit entries
	 */
	public java.util.List<AuditEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the audit entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of audit entries
	 */
	public java.util.List<AuditEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the audit entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuditEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of audit entries
	 * @param end the upper bound of the range of audit entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of audit entries
	 */
	public java.util.List<AuditEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuditEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the audit entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of audit entries.
	 *
	 * @return the number of audit entries
	 */
	public int countAll();

}