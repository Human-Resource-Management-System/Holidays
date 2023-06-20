package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrms_jobgrades")
public class JobGrade {
	@Id
	@Column(name = "jbgr_id")
	private String jbgr_id;

	private String jbgr_name;
	private String jbgr_desc;

	// Other job grade properties
	public String getJbgr_id() {
		return jbgr_id;
	}

	public void setJbgr_id(String jbgr_id) {
		this.jbgr_id = jbgr_id;
	}

	public String getJbgr_name() {
		return jbgr_name;
	}

	public void setJbgr_name(String jbgr_name) {
		this.jbgr_name = jbgr_name;
	}

	public String getJbgr_desc() {
		return jbgr_desc;
	}

	public void setJbgr_desc(String jbgr_desc) {
		this.jbgr_desc = jbgr_desc;
	}

	// Getters and setters
}
