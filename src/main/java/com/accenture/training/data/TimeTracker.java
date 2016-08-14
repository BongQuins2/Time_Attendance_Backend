package com.accenture.training.data;

import javax.persistence.*;

@Entity
@Table(name = "timetracker")
public class TimeTracker {

    @Id
    @Column(name = "tt_id")
    private int ttId;

    @Column(name = "tt_date")
    private String tt_date;
    
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee emp_id;

    @Column(name = "time_in")
    private String time_in;

    @Column(name = "time_out")
    private String time_out;

	public int getTt_id() {
		return ttId;
	}

	public void setTt_id(int tt_id) {
		this.ttId = tt_id;
	}

	public Employee getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee emp_id) {
		this.emp_id = emp_id;
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

	public String getTt_date() {
		return tt_date;
	}

	public void setTt_date(String tt_date) {
		this.tt_date = tt_date;
	}

    
}
