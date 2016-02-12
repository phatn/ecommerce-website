package com.manifera.meshop.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.manifera.meshop.core.domain.common.AuditListener;
import com.manifera.meshop.core.domain.common.AuditSection;
import com.manifera.meshop.core.domain.common.Auditable;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "es_country")
public class Country implements Auditable, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "country_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "country_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
	private Long id;
	
	@Column(name = "code")
	private String code;

	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	public AuditSection getAuditSection() {
		return auditSection;
	}

	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
}
