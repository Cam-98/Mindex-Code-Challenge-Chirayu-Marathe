package com.mindex.challenge.service;

import com.mindex.challenge.data.ReportingStructure;

public interface ReportingStructureService {
    /**
     * This method accepts an employeeId and returns a fully-filled out reporting structure for that employeeId.
     * @param employeeId Employee Id for which we have to create the reporting structure
     * @return ReportingStructure object for the given employeeId
     */
    ReportingStructure createReportingStructure(String employeeId);
}
