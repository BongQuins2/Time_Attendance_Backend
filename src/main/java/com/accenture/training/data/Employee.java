package com.accenture.training.data;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    private int empId;

    @OneToMany(mappedBy = "emp_id", cascade=CascadeType.ALL, targetEntity=TimeTracker.class, orphanRemoval = true)
    private List<TimeTracker> timetrackerList;

    @OneToMany(mappedBy = "empId", cascade=CascadeType.ALL, targetEntity=EmpShift.class, orphanRemoval = true)
    private List<EmpShift> empShiftList;

    @Column(name = "emp_username")
    private String emp_username;
    
    @Column(name = "emp_fullname")
    private String emp_fullname;

    @Column(name = "emp_level")
    private int emp_level;

    public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getEmp_level() {
		return emp_level;
	}

	public void setEmp_level(int emp_level) {
		this.emp_level = emp_level;
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

}
