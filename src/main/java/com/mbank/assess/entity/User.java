package com.mbank.assess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends AbstractAuditingEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5210814041329345230L;

	@Id
    @Column(name = "id", length = 36)
	private String id;

    @Column(name = "name", nullable = false, length = 100)
	private String name;

    @Column(name = "email", length = 50)
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
