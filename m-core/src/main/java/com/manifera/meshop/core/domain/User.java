package com.manifera.meshop.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.manifera.meshop.core.domain.common.AuditSection;
import com.manifera.meshop.core.domain.common.Auditable;


/**
 *  
 * @author Phat Nguyen
 * 
 */

@Entity
@Table(name = "es_user")
public class User implements Auditable, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "user_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="table_generator")
	private Long id;
	
	@Column(name = "admin_user_name")
	private String adminUserName;
	
	@Column(name ="admin_password")
	private String adminPassword;
	
	@Column(name ="first_name")
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_access")
	private Date lastAccess;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "login_access")
	private Date loginTime;
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name="es_user_role",
	joinColumns = {@JoinColumn(name="user_id")},
	inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<>();
	
	@Column(name="customer_enable")
	private boolean enable;
	
	@Column(name = "admin_email_address")
	private String adminEmailAddress;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();

	public String getAdminEmailAddress() {
		return adminEmailAddress;
	}

	public void setAdminEmailAddress(String adminEmailAddress) {
		this.adminEmailAddress = adminEmailAddress;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public AuditSection getAuditSection() {
		return auditSection;
	}

	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
