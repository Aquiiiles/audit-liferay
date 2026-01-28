/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.audit.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.audit.exception.NoSuchAuditEntryException;
import com.liferay.audit.model.AuditEntry;
import com.liferay.audit.service.AuditEntryLocalServiceUtil;
import com.liferay.audit.service.persistence.AuditEntryPersistence;
import com.liferay.audit.service.persistence.AuditEntryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AuditEntryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.audit.service"));

	@Before
	public void setUp() {
		_persistence = AuditEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AuditEntry> iterator = _auditEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AuditEntry auditEntry = _persistence.create(pk);

		Assert.assertNotNull(auditEntry);

		Assert.assertEquals(auditEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AuditEntry newAuditEntry = addAuditEntry();

		_persistence.remove(newAuditEntry);

		AuditEntry existingAuditEntry = _persistence.fetchByPrimaryKey(
			newAuditEntry.getPrimaryKey());

		Assert.assertNull(existingAuditEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAuditEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AuditEntry newAuditEntry = _persistence.create(pk);

		newAuditEntry.setUuid(RandomTestUtil.randomString());

		newAuditEntry.setGroupId(RandomTestUtil.nextLong());

		newAuditEntry.setCompanyId(RandomTestUtil.nextLong());

		newAuditEntry.setUserId(RandomTestUtil.nextLong());

		newAuditEntry.setUserName(RandomTestUtil.randomString());

		newAuditEntry.setCreateDate(RandomTestUtil.nextDate());

		newAuditEntry.setModifiedDate(RandomTestUtil.nextDate());

		newAuditEntry.setEntityName(RandomTestUtil.randomString());

		newAuditEntry.setEntityId(RandomTestUtil.nextLong());

		newAuditEntry.setAction(RandomTestUtil.randomString());

		newAuditEntry.setFieldName(RandomTestUtil.randomString());

		newAuditEntry.setOldValue(RandomTestUtil.randomString());

		newAuditEntry.setNewValue(RandomTestUtil.randomString());

		_auditEntries.add(_persistence.update(newAuditEntry));

		AuditEntry existingAuditEntry = _persistence.findByPrimaryKey(
			newAuditEntry.getPrimaryKey());

		Assert.assertEquals(
			existingAuditEntry.getUuid(), newAuditEntry.getUuid());
		Assert.assertEquals(
			existingAuditEntry.getAuditEntryId(),
			newAuditEntry.getAuditEntryId());
		Assert.assertEquals(
			existingAuditEntry.getGroupId(), newAuditEntry.getGroupId());
		Assert.assertEquals(
			existingAuditEntry.getCompanyId(), newAuditEntry.getCompanyId());
		Assert.assertEquals(
			existingAuditEntry.getUserId(), newAuditEntry.getUserId());
		Assert.assertEquals(
			existingAuditEntry.getUserName(), newAuditEntry.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAuditEntry.getCreateDate()),
			Time.getShortTimestamp(newAuditEntry.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAuditEntry.getModifiedDate()),
			Time.getShortTimestamp(newAuditEntry.getModifiedDate()));
		Assert.assertEquals(
			existingAuditEntry.getEntityName(), newAuditEntry.getEntityName());
		Assert.assertEquals(
			existingAuditEntry.getEntityId(), newAuditEntry.getEntityId());
		Assert.assertEquals(
			existingAuditEntry.getAction(), newAuditEntry.getAction());
		Assert.assertEquals(
			existingAuditEntry.getFieldName(), newAuditEntry.getFieldName());
		Assert.assertEquals(
			existingAuditEntry.getOldValue(), newAuditEntry.getOldValue());
		Assert.assertEquals(
			existingAuditEntry.getNewValue(), newAuditEntry.getNewValue());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AuditEntry newAuditEntry = addAuditEntry();

		AuditEntry existingAuditEntry = _persistence.findByPrimaryKey(
			newAuditEntry.getPrimaryKey());

		Assert.assertEquals(existingAuditEntry, newAuditEntry);
	}

	@Test(expected = NoSuchAuditEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AuditEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AUDIT_AuditEntry", "uuid", true, "auditEntryId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "entityName", true,
			"entityId", true, "action", true, "fieldName", true, "oldValue",
			true, "newValue", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AuditEntry newAuditEntry = addAuditEntry();

		AuditEntry existingAuditEntry = _persistence.fetchByPrimaryKey(
			newAuditEntry.getPrimaryKey());

		Assert.assertEquals(existingAuditEntry, newAuditEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AuditEntry missingAuditEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAuditEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AuditEntry newAuditEntry1 = addAuditEntry();
		AuditEntry newAuditEntry2 = addAuditEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuditEntry1.getPrimaryKey());
		primaryKeys.add(newAuditEntry2.getPrimaryKey());

		Map<Serializable, AuditEntry> auditEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, auditEntries.size());
		Assert.assertEquals(
			newAuditEntry1, auditEntries.get(newAuditEntry1.getPrimaryKey()));
		Assert.assertEquals(
			newAuditEntry2, auditEntries.get(newAuditEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AuditEntry> auditEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(auditEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AuditEntry newAuditEntry = addAuditEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuditEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AuditEntry> auditEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, auditEntries.size());
		Assert.assertEquals(
			newAuditEntry, auditEntries.get(newAuditEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AuditEntry> auditEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(auditEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AuditEntry newAuditEntry = addAuditEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAuditEntry.getPrimaryKey());

		Map<Serializable, AuditEntry> auditEntries =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, auditEntries.size());
		Assert.assertEquals(
			newAuditEntry, auditEntries.get(newAuditEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AuditEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AuditEntry>() {

				@Override
				public void performAction(AuditEntry auditEntry) {
					Assert.assertNotNull(auditEntry);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AuditEntry newAuditEntry = addAuditEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AuditEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"auditEntryId", newAuditEntry.getAuditEntryId()));

		List<AuditEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AuditEntry existingAuditEntry = result.get(0);

		Assert.assertEquals(existingAuditEntry, newAuditEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AuditEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"auditEntryId", RandomTestUtil.nextLong()));

		List<AuditEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AuditEntry newAuditEntry = addAuditEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AuditEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("auditEntryId"));

		Object newAuditEntryId = newAuditEntry.getAuditEntryId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"auditEntryId", new Object[] {newAuditEntryId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAuditEntryId = result.get(0);

		Assert.assertEquals(existingAuditEntryId, newAuditEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AuditEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("auditEntryId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"auditEntryId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AuditEntry newAuditEntry = addAuditEntry();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAuditEntry.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		AuditEntry newAuditEntry = addAuditEntry();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AuditEntry.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"auditEntryId", newAuditEntry.getAuditEntryId()));

		List<AuditEntry> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(AuditEntry auditEntry) {
		Assert.assertEquals(
			auditEntry.getUuid(),
			ReflectionTestUtil.invoke(
				auditEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(auditEntry.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				auditEntry, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected AuditEntry addAuditEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AuditEntry auditEntry = _persistence.create(pk);

		auditEntry.setUuid(RandomTestUtil.randomString());

		auditEntry.setGroupId(RandomTestUtil.nextLong());

		auditEntry.setCompanyId(RandomTestUtil.nextLong());

		auditEntry.setUserId(RandomTestUtil.nextLong());

		auditEntry.setUserName(RandomTestUtil.randomString());

		auditEntry.setCreateDate(RandomTestUtil.nextDate());

		auditEntry.setModifiedDate(RandomTestUtil.nextDate());

		auditEntry.setEntityName(RandomTestUtil.randomString());

		auditEntry.setEntityId(RandomTestUtil.nextLong());

		auditEntry.setAction(RandomTestUtil.randomString());

		auditEntry.setFieldName(RandomTestUtil.randomString());

		auditEntry.setOldValue(RandomTestUtil.randomString());

		auditEntry.setNewValue(RandomTestUtil.randomString());

		_auditEntries.add(_persistence.update(auditEntry));

		return auditEntry;
	}

	private List<AuditEntry> _auditEntries = new ArrayList<AuditEntry>();
	private AuditEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}