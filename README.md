# IDP – Custom Audit Viewer for Liferay DXP

This project is an **Individual Development Plan (IDP)** focused on designing and implementing a **custom audit infrastructure for Liferay DXP**, with real integration into **Liferay Objects** lifecycle events.

The goal is to explore how a product-level audit feature could be built incrementally, using Liferay’s native extension points and best practices.

---

## 🎯 Purpose

- Understand how auditing can be implemented outside the default Liferay Audit framework
- Practice **Service Builder**, **ModelListeners**, and modular architecture
- Capture **CREATE, UPDATE and DELETE** operations from **Liferay Objects**
- Build a reusable and extensible audit foundation
- Validate the solution end-to-end (Service → Listener → UI)

---

## 🧱 Architecture

The solution is split into three modules:

- **API**
    - Defines the audit contracts and model access

- **Service**
    - Service Builder–based persistence
    - Centralized `AuditEntryLocalService`
    - Custom finder support (e.g. by `groupId`)

- **Web**
    - MVCPortlet-based **Audit Viewer**
    - Displays audit data in a paginated table
    - Action handling via `MVCActionCommand`

---

## 📄 AuditEntry Model

The `AuditEntry` entity stores generic audit data to support multiple sources:

- Scope
    - `companyId`
    - `groupId`

- User metadata
    - `userId`
    - `userName`

- Audited target
    - `entityName`
    - `entityId`

- Change data
    - `action` (CREATED, UPDATED, DELETED)
    - `fieldName`
    - `oldValue`
    - `newValue`

- Timestamps
    - `createDate`
    - `modifiedDate`

The model is intentionally generic to allow auditing of different domain entities without schema changes.

---

## 🔔 ObjectEntry Auditing

The project integrates with **Liferay Objects** using a `ModelListener<ObjectEntry>`.

### Implemented Events

- `onAfterCreate`
- `onAfterUpdate`
- `onAfterRemove`

### Behavior

- CREATE
    - Records object creation with the resolved title value
- UPDATE
    - Detects field-level changes
    - Stores old and new values per field
- DELETE
    - Registers deletion events
    - Captures the user responsible for the action

The listener relies on `ServiceContextThreadLocal` to correctly associate user and scope data.

---

## 🖥️ Audit Viewer Portlet

- Built using `MVCPortlet`
- Uses `liferay-ui:search-container`
- Displays:
    - Entity
    - Entity ID
    - Action
    - Field
    - Old Value
    - New Value
    - User
    - Date

### Actions

- **Clear audit history** (by scope)
- **Delete individual audit entries**

All actions are implemented via `MVCActionCommand`.

---

## 🧪 Validation Strategy

The implementation was validated incrementally:

1. **Service Builder**
    - Entity modeling
    - Persistence and custom finders

2. **UI Integration**
    - Data rendering via Audit Viewer
    - Pagination and actions

3. **Automation**
    - ObjectEntry lifecycle listeners
    - Field-level diff detection
    - DELETE auditing

This ensured correctness and stability at each layer before progressing.

---

## ⚠️ Important Note on Object Titles

Audit readability depends on proper **Object Definition configuration**:

- If an Object **does not define a Title Field**, Liferay falls back to `ObjectEntryId`
- To achieve meaningful audit values, Objects should define a **text-based Title Field**

This behavior is expected and aligns with Liferay’s Object framework.

---

## 🔮 Next Steps

- Improve entity name normalization (remove internal identifiers)
- Add filtering (by entity, user, action)
- Link audit entries back to Object Entry views
- Group multiple updates from the same request
- Expose audit data via a Headless API
- Add integration tests

---

## 🧑‍💻 Author

Developed as an **Individual Development Plan** to deepen knowledge of **Liferay DXP internals**, lifecycle extension points, and feature-oriented modular design.
