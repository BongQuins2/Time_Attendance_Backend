package com.accenture.training.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.training.data.Login;

public interface LoginRepository extends CrudRepository<Login, String> {

    Login findByUsername(String username);

//    void deleteByUsername(String username);
    
    void deleteByUserId(int userId);
    
    Login findByUserId(int userId);

    @Query("SELECT COALESCE(MAX(l.userId),0) FROM Login l")
    int maxByuserID();

    @Query("SELECT COUNT(l) FROM Login l WHERE l.username=?1")
    int countByName(String username);
    
    @Query("SELECT COUNT(l) FROM Login l WHERE l.username=?1 AND l.user_password=?2")
    int checkByNamePassword(String username, String password);
    

}
