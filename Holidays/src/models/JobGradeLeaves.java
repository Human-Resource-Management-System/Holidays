package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ch_jobgradewiseleaves")
public class JobGradeLeaves {
	@Id
	@Column(name = "jbgr_id")
	private String jbgr_id;

	@Column(name = "jbgr_totalnol")
	private int jbgr_totalnol;

	@Column(name = "jbgr_nocl")
	private int jbgr_nocl;

	@Column(name = "jbgr_nosl")
	private int jbgr_nosl;

	@Column(name = "jbgr_nool")
	private int jbgr_nool;

	public String getJbgr_id() {
		return jbgr_id;
	}

	public void setJbgr_id(String jbgr_id) {
		this.jbgr_id = jbgr_id;
	}

	public int getJbgr_totalnol() {
		return jbgr_totalnol;
	}

	public void setJbgr_totalnol(int jbgr_totalnol) {
		this.jbgr_totalnol = jbgr_totalnol;
	}

	public int getJbgr_nocl() {
		return jbgr_nocl;
	}

	public void setJbgr_nocl(int jbgr_nocl) {
		this.jbgr_nocl = jbgr_nocl;
	}

	public int getJbgr_nosl() {
		return jbgr_nosl;
	}

	public void setJbgr_nosl(int jbgr_nosl) {
		this.jbgr_nosl = jbgr_nosl;
	}

	public int getJbgr_nool() {
		return jbgr_nool;
	}

	public void setJbgr_nool(int jbgr_nool) {
		this.jbgr_nool = jbgr_nool;
	}

	// Add other job grade wise leaves properties as needed

	// Generate getters and setters
}