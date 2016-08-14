package com.accenture.training.data.repository;

import java.util.List;

import com.accenture.training.data.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, String> {
	Employee findByEmpId(int empId);

    void deleteByempId(int empId);

    List<Employee> findAll();

    @Query("SELECT COALESCE(MAX(empId),0) FROM Employee")
    int maxByEmployeeID();

    @Query("SELECT COUNT(u) FROM Employee e WHERE e.empId=?1")
    long countByEmployee(String empId);
    
    //added
    @Query("SELECT e.empId FROM Employee e WHERE e.emp_username=?1")
    int findByEmpUsername(String emp_username);
   

}
