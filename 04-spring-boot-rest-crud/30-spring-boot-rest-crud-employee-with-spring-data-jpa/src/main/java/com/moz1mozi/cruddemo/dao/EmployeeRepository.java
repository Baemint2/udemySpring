package com.moz1mozi.cruddemo.dao;

import com.moz1mozi.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //that's it... no need to write any code LOL!

}
