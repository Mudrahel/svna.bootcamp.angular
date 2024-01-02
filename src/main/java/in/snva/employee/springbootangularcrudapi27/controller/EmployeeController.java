package in.snva.employee.springbootangularcrudapi27.controller;

import in.snva.employee.springbootangularcrudapi27.model.Employee;
import in.snva.employee.springbootangularcrudapi27.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO create Rest API
@RestController
@RequestMapping("/api/v1") //Standard end point we use in Rest APIs
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @CrossOrigin(origins = "http://localhost:4200")// Angular address
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    //Create an Employee Rest API
    @CrossOrigin(origins = "http://localhost:4200")// Angular address
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}
