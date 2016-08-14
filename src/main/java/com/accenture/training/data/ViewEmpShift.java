package com.accenture.training.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_empshift_info")
public class ViewEmpShift {

	@Id
	@Column(name = "emp_shift_id")
    private int empShiftId;

	@Column(name = "emp_id")
    private int empId;

	@Column(name = "shift_id")
    private int shiftId;

    @Column(name = "emp_username")
    private String emp_username;
    
    @Column(name = "emp_fullname")
    private String emp_fullname;

    @Column(name = "shift_start")
    private String shift_start;

    @Column(name = "shift_end")
    private String shift_end;

    @Column(name = "shift_break")
    private String shift_break;

    @Column(name = "shift_name")
    private String shift_name;

	public int getEmpShiftId() {
		return empShiftId;
	}

	public void setEmpShiftId(int empShiftId) {
		this.empShiftId = empShiftId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
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

	public String getShift_start() {
		return shift_start;
	}

	public void setShift_start(String shift_start) {
		this.shift_start = shift_start;
	}

	public String getShift_end() {
		return shift_end;
	}

	public void setShift_end(String shift_end) {
		this.shift_end = shift_end;
	}

	public String getShift_break() {
		return shift_break;
	}

	public void setShift_break(String shift_break) {
		this.shift_break = shift_break;
	}

	public String getShift_name() {
		return shift_name;
	}

	public void setShift_name(String shift_name) {
		this.shift_name = shift_name;
	}
	
}
