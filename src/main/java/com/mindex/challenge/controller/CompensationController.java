package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    private CompensationService compensationService;

    /**
     * This method calls the API endpoint and creates an entry in the repository for the given compensation object
     * @param compensation Compensation object that we need to update and insert into the mongo repository.
     * @return Updated compensation object
     */
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensation create request for [{}]", compensation);
        return compensationService.create(compensation);
    }

    /**
     * This method calls the API endpoint and returns the compensation object corresponding to an employeeId.
     * @param employeeId Employee Id for a given employee
     * @return Compensation object corresponding to the employee containing the given employeeId.
     */
    @GetMapping("/compensation/{employeeId}")
    public Compensation read(@PathVariable String employeeId) {
        LOG.debug("Received compensation read request for id [{}]", employeeId);
        return compensationService.read(employeeId);
    }
}
