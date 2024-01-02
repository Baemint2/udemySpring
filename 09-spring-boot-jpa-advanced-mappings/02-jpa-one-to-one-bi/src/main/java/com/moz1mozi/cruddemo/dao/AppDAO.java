package com.moz1mozi.cruddemo.dao;

import com.moz1mozi.cruddemo.entity.Instructor;
import com.moz1mozi.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);


    void deleteInstructorById(int theId);
//    Instructor deleteInstructorById(int theId);

   InstructorDetail findInstructorDetailById(int theId);

   void deleteInstructorDetailById(int theId);


}
