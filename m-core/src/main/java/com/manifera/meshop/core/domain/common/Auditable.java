package com.manifera.meshop.core.domain.common;

public interface Auditable {
	
	public AuditSection getAuditSection();
	
	public void setAuditSection(AuditSection auditSection);
}
