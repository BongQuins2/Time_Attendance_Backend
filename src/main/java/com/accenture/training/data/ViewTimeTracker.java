package com.accenture.training.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_tt_info")
public class ViewTimeTracker {
	
	@Id
	@Column(name = "tt_id")
    private int ttId;

	@Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_username")
    private String emp_username;
    
    @Column(name = "emp_fullname")
    private String emp_fullname;

    @Column(name = "tt_date")
    private String tt_date;
    
    @Column(name = "time_in")
    private String time_in;

    @Column(name = "time_out")
    private String time_out;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_fullname() {
		return emp_fullname;
	}

	public void setEmp_fullname(String emp_fullname) {
		this.emp_fullname = emp_fullname;
	}

	public String getTt_date() {
		return tt_date;
	}

	public void setTt_date(String tt_date) {
		this.tt_date = tt_date;
	}

	public String getTime_in() {
		return time_in;
	}

	public void setTime_in(String time_in) {
		this.time_in = time_in;
	}

	public String getTime_out() {
		return time_out;
	}

	public void setTime_out(String time_out) {
		this.time_out = time_out;
	}

	public int getTtId() {
		return ttId;
	}

	public void setTtId(int ttId) {
		this.ttId = ttId;
	}
    
}
