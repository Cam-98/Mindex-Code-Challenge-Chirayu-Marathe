package com.mindex.challenge.dao;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.Compensation;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
/*
 * This interface method is used to find the compensation object corresponding to a particular employee.
 */
public interface CompensationRepository extends MongoRepository<Compensation, String>{
    Compensation findByEmployee(Employee employee);
}

