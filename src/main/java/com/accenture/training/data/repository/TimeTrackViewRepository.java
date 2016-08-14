package com.accenture.training.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.accenture.training.data.ViewTimeTracker;

public interface TimeTrackViewRepository extends Repository<ViewTimeTracker, String> {
	//added
	List<ViewTimeTracker> findByempId(long empId);
	
    List<ViewTimeTracker> findByttId(int ttId);

    List<ViewTimeTracker> findAll();

    @Query("SELECT v.emp_username, v.emp_fullname, v.tt_date, v.time_in, v.time_out FROM ViewTimeTracker v WHERE v.empId=?1 AND v.tt_date=?2")
    List<ViewTimeTracker> displayByEmpDateAttendance(int empId, String tt_date);
    
    //added
    @Query("SELECT v.tt_date, v.time_in, v.time_out FROM ViewTimeTracker v WHERE v.empId=?1")
    List<ViewTimeTracker> displayByEmpIdAttendance(int empId);

	//added
    @Query("SELECT t.time_in FROM ViewTimeTracker t WHERE t.empId=?1 AND t.tt_date=?2")
    String findTimeInByEmpidTTdate(int empId, String tt_date);

}

