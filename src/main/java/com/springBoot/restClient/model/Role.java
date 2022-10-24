package com.springBoot.restClient.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ROLE")
@XmlRootElement(name="role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ROLE_ID", updatable = false, nullable = false)
	private int id;
	
	@Column(name="ROLE_NAME", updatable = true, nullable = false)
	private String roleName;

	public Role() {
		super();
	}

	public Role(String rolename) {
		super();
		this.roleName = rolename;
	}
	
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getRolename() {
		return roleName;
	}
	@XmlElement
	public void setRolename(String rolename) {
		this.roleName = rolename;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + roleName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	

	public int compareTo(Role role) {
		return this.roleName.compareTo(role.getRolename());
	}
	
	
	
}
