package com.accenture.training.data;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "shift")
public class Shift {

    @Id
    @Column(name = "shift_id")
    private int shiftId;

    @OneToMany(mappedBy = "shiftId", cascade=CascadeType.ALL, targetEntity=EmpShift.class, orphanRemoval = true)
    private List<EmpShift> empShiftList;

    @Column(name = "shift_start")
    private String shift_start;

    @Column(name = "shift_end")
    private String shift_end;

    @Column(name = "shift_break")
    private String shift_break;

    @Column(name = "shift_name")
    private String shift_name;

    public String getShift_name() {
		return shift_name;
	}

	public void setShift_name(String shift_name) {
		this.shift_name = shift_name;
	}

	public int getShift_id() {
		return shiftId;
	}

	public void setShift_id(int shift_id) {
		this.shiftId = shift_id;
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

}

