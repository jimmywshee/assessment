package com.mbank.assess.bo;

import javax.validation.constraints.NotBlank;

public class UserBO extends AbstractAuditingBO {

	private String id;

	@NotBlank(message = "name is mandatory field")
	private String name;

	@NotBlank(message = "email is mandatory field")
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

	@Override
	public String toString() {
		return "UserBO [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
