package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {

    private String createReportingStructureUrl;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        createReportingStructureUrl = "http://localhost:" + port + "/createReportingStructure/{employeeId}";
    }

    @Test
    /*
      This method tests the implementation of the reportingStructureService interface to determine if the
      reporting structure for the employee with employeeId "16a596ae-edd3-4847-99fe-c4518e82c86f" is being computed
      correctly or not.
     */
    public void testCreateReportingStructure(){
        ReportingStructure readReportingStructure = restTemplate.getForEntity(createReportingStructureUrl,
                ReportingStructure.class, "16a596ae-edd3-4847-99fe-c4518e82c86f").getBody();
        assertEquals(readReportingStructure.getNumberOfReports(), 4);
    }

    @After
    public void teardown() {
        createReportingStructureUrl = null;
    }
}
