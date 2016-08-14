package com.accenture.training.data.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.accenture.training.data.Employee;
import com.accenture.training.data.TimeTracker;

public interface TimeTrackerRepository extends CrudRepository<TimeTracker, String> {
	TimeTracker findByttId(int ttId);

    void deleteByttId(int ttId);

    @Query("SELECT COALESCE(MAX(ttId),0) FROM TimeTracker")
    int maxByTimeTrackerID();

    @Query("SELECT COUNT(u) FROM TimeTracker t WHERE t.ttId=?1")
    long countByTimeTracker(int ttId);

    @Query("SELECT t.time_in FROM TimeTracker t WHERE t.emp_id=?1 AND t.tt_date=?2")
    String displayTimeIn(Employee emp_id, String tt_date);

    @Query("SELECT t.time_out FROM TimeTracker t WHERE t.emp_id=?1 AND t.tt_date=?2")
    String displayTimeOut(Employee emp_id, String tt_date);

    @Modifying
    @Query("update TimeTracker t set t.time_out = ?1 WHERE t.emp_id=?2 AND t.tt_date=?3")
    void updateTimeTrackerByEmpIdttDate(String time_out, Employee emp_id, String tt_date);
    
}