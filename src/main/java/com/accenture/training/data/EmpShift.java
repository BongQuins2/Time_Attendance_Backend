package com.accenture.training.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp_shift")
public class EmpShift {

    @Id
    @Column(name = "emp_shift_id")
    private int empShiftId;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee empId;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    private Shift shiftId;

	public int getEmpShiftId() {
		return empShiftId;
	}

	public void setEmpShiftId(int empShiftId) {
		this.empShiftId = empShiftId;
	}

	public Employee getEmp_id() {
		return empId;
	}

	public void setEmp_id(Employee emp_id) {
		this.empId = emp_id;
	}

	public Shift getShift_id() {
		return shiftId;
	}

	public void setShift_id(Shift shift_id) {
		this.shiftId = shift_id;
	}
   
}
