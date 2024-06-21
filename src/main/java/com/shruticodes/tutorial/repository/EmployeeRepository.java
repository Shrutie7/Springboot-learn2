package com.shruticodes.tutorial.repository;

import com.shruticodes.tutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}

