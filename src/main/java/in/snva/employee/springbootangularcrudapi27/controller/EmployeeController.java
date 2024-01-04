package in.snva.employee.springbootangularcrudapi27.controller;

import in.snva.employee.springbootangularcrudapi27.exception.ResourceNotFoundException;
import in.snva.employee.springbootangularcrudapi27.model.Employee;
import in.snva.employee.springbootangularcrudapi27.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO create Rest API
@RestController
@RequestMapping("/api/v1") //Standard end point we use in Rest APIs
@CrossOrigin(origins = "http://localhost:4200")// Angular address binding
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    //Create an Employee Rest API
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    //get an Employee by id Rest API
    //@PathVariable
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with id: " + id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with id: " + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);

    }

    //delete employee rest api
    //deleteEmployee return a Map and we delete record based on the employee id
    //if not found, throws an Exception using orElseThrow()
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exist with id: " + id));

        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
