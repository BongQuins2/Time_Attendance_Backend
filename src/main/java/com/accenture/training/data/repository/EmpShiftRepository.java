package com.accenture.training.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.training.data.EmpShift;


public interface EmpShiftRepository extends CrudRepository<EmpShift, String> {
	EmpShift findByEmpShiftId(int empShiftId);

    void deleteByempShiftId(int empShiftId);

    @Query("SELECT COALESCE(MAX(empShiftId),0) FROM EmpShift")
    int maxByEmpShiftID();

    @Query("SELECT COUNT(u) FROM EmpShift e WHERE e.empShiftId=?1")
    long countByEmpShift(int empShiftId);

}

