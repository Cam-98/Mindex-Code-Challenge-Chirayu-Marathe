package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

public interface CompensationService {
    /**
     * This interface method updates the compensation object, inserts it into the repository and returns the updated
     * compensation object.
     * @param compensation Compensation object we need to update and insert into the repository
     * @return Updated compensation object
     */
    Compensation create(Compensation compensation);

    /**
     * This interface method queries the repository for the compensation object corresponding to
     * the given employeeId.
     * @param employeeId Employee Id for a given employee
     * @return Compensation object corresponding to the given employeeId
     */
    Compensation read(String employeeId);
}
