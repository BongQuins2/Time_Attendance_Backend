package com.accenture.training.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_emplogin_info")
public class ViewLoginInfo {

	@Id
	@Column(name = "emp_id")
    private int empId;

	@Column(name = "user_id")
    private int userId;

    @Column(name = "emp_username")
    private String emp_username;
    
    @Column(name = "emp_fullname")
    private String emp_fullname;

    @Column(name = "emp_level")
    private String emp_level;

    @Column(name = "user_password")
    private String user_password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public String getEmp_level() {
		return emp_level;
	}

	public void setEmp_level(String emp_level) {
		this.emp_level = emp_level;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	
	
}