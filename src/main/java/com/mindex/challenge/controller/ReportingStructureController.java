package com.mindex.challenge.controller;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class);

    @Autowired
    private ReportingStructureService reportingStructureService;

    /**
     * This method calls the API endpoint and computes the fully filled-out reporting structure for a given
     * employeeId.
     * @param employeeId Employee id
     * @return ReportingStructure object for the given employeeId
     */
    @GetMapping("/createReportingStructure/{employeeId}")
    public ReportingStructure createReportingStructure(@PathVariable String employeeId) {
        LOG.debug("Received createReportingStructure request for employeeId [{}]", employeeId);
        return reportingStructureService.createReportingStructure(employeeId);
    }
}
