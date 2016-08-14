package com.accenture.training.data.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.accenture.training.data.ViewEmpShift;

public interface EmpShiftViewRepository extends Repository<ViewEmpShift, String> {

    List<ViewEmpShift> findByempId(int empId);

    List<ViewEmpShift> findAll();

}
