package com.accenture.training.data.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.accenture.training.data.ViewLoginInfo;

public interface LoginViewRepository extends Repository<ViewLoginInfo, String> {

	List<ViewLoginInfo> findByempId(int empId);

	List<ViewLoginInfo> findAll();
}
