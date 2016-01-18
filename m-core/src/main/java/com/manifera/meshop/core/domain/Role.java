package com.manifera.meshop.core.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.manifera.meshop.core.domain.common.AuditSection;
import com.manifera.meshop.core.domain.common.Auditable;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Entity
@Table(name = "es_role")
public class Role implements Auditable, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "role_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "role_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="table_generator")
	private Long id;
	
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<Customer> customers = new HashSet<Customer>();
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name="es_role_permission",
	joinColumns = {@JoinColumn(name="role_id")},
	inverseJoinColumns = {@JoinColumn(name = "permission_id")})
	private Set<Permission> permissions = new HashSet<Permission>();
	
	@Embedded
	private AuditSection auditSection = new AuditSection();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public AuditSection getAuditSection() {
		return auditSection;
	}

	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}
}
