# IDP – Custom Audit Viewer for Liferay DXP

This project is a **Individual Development Plan (IDP)** focused on building a **custom audit infrastructure for Liferay DXP**, designed as a foundation for future product-level features such as automatic auditing of **Liferay Objects**.

---

## 🎯 Purpose

- Explore how a custom audit feature can be implemented in Liferay
- Practice **Service Builder**, modular architecture, and MVCPortlets
- Validate infrastructure incrementally before adding automation
- Prepare a scalable audit model for future integrations

---

## 🧱 Architecture

- **API**: exposes audit contracts
- **Service**: persistence and business logic (Service Builder)
- **Web**: Audit Viewer portlet (UI)

---

## 📄 AuditEntry Model

The `AuditEntry` entity stores:

- Scope (`companyId`, `groupId`)
- User metadata (`userId`, `userName`)
- Audited entity (`entityName`, `entityId`)
- Change details (`action`, `fieldName`, `oldValue`, `newValue`)
- Timestamps (`createDate`, `modifiedDate`)

The model is intentionally generic to support multiple audited sources.

---

## 🧪 Validation Approach

The solution was validated incrementally:

- **Level 1**: Service Builder and persistence
- **Level 1.5**: Service + UI integration via Audit Viewer portlet

This ensured a stable foundation before introducing listeners or automation.

---

## 🖥️ Audit Viewer

- MVCPortlet using `liferay-ui:search-container`
- Displays audit entries in a paginated table
- Compatible with **Liferay DXP Quarterly (Jakarta)**

---

## 🔮 Next Steps

- Automatic auditing of **Liferay Objects**
- Field-level change detection
- Filtering and search
- Headless API exposure
- Integration tests

---

## 🧑‍💻 Author

Developed as a **Individual Development Plan** to deepen knowledge of Liferay DXP internals and feature-oriented design.
