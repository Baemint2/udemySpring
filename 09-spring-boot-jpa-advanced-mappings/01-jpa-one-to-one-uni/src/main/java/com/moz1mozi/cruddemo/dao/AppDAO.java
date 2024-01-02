package com.moz1mozi.cruddemo.dao;

import com.moz1mozi.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);


    void deleteInstructorById(int theId);
//    Instructor deleteInstructorById(int theId);
}
