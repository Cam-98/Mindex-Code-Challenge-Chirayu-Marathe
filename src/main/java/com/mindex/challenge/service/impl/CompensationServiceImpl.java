package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private EmployeeService employeeService;

    /**
     * This implementation of the interface method updates the employee field for the given compensation object and
     * inserts it into the mongo repository.
     * @param compensation Compensation object for a particular employee
     * @return Updated Compensation object
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation [{}]", compensation);
        Employee currentEmployee = employeeService.read(compensation.getEmployee().getEmployeeId());
        compensation.setEmployee(currentEmployee);
        compensationRepository.insert(compensation);
        return compensation;
    }

    /**
     * This implementation of the interface method queries the repository for the compensation object corresponding to
     * the given employeeId.
     * @param employeeId Employee Id for a given employee
     * @return Compensation object corresponding to the given employeeId
     */
    @Override
    public Compensation read(String employeeId) {
        LOG.debug("Reading employee with id [{}]", employeeId);
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        Compensation employeeCompensation = compensationRepository.findByEmployee(employee);
        if(employee == null || employeeCompensation == null){
            throw new RuntimeException("Invalid employee Id: "+employeeId);
        }
        return employeeCompensation;
    }
}
