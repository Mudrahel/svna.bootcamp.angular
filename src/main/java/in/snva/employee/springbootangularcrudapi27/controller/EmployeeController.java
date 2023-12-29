package in.snva.employee.springbootangularcrudapi27.controller;

import in.snva.employee.springbootangularcrudapi27.model.Employee;
import in.snva.employee.springbootangularcrudapi27.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO create Rest API
@RestController
@RequestMapping("/api/v1") //Standard end point we use in Rest APIs
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @CrossOrigin(origins="http://localhost:4200")// Angular address
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
