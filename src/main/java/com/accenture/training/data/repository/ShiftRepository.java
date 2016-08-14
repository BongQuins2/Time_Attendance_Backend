package com.accenture.training.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.training.data.Shift;

public interface ShiftRepository extends CrudRepository<Shift, String> {
	Shift findByShiftId(int shiftId);

    void deleteByShiftId(int shiftId);
    
    List<Shift> findAll();

    @Query("SELECT COALESCE(MAX(shiftId),0) FROM Shift")
    int maxByShiftID();

    @Query("SELECT COUNT(u) FROM Shift s WHERE s.shiftId=?1")
    long countByShift(int shiftId);

}
