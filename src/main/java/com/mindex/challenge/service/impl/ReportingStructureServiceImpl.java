package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    private int totalReports;

    /**
     * This is the implementation of the interface method accepts an employeeId and returns a fully-filled out reporting
     * structure for that employeeId.
     * @param employeeId Employee Id for which we have to create the reporting structure
     * @return ReportingStructure object for the given employeeId
     */
    @Override
    public ReportingStructure createReportingStructure(String employeeId) {
        LOG.debug("Creating ReportingStructure with employeeId [{}]", employeeId);
        totalReports = 0;
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        // get totalReports for all employees recursively
        getTotalNumberOfReports(employee);
        return new ReportingStructure(totalReports, employee);
    }

    /**
     * This method recursively calculates all the distinct reports a particular employee has.
     * @param currentEmployee Current employee for whom we need to calculate distinct reports
     */
    public void getTotalNumberOfReports(Employee currentEmployee){
        List<Employee> directReports = currentEmployee.getDirectReports();
        if(directReports != null) {
            totalReports += directReports.size();
            for (Employee reportingEmployee : directReports) {
                getTotalNumberOfReports(employeeRepository.findByEmployeeId(reportingEmployee.getEmployeeId()));
            }
        }
        // http://localhost:8080/createReportingStructure/16a596ae-edd3-4847-99fe-c4518e82c86f
    }

}
