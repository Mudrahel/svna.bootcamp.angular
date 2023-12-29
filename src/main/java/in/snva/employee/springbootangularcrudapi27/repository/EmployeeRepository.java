package in.snva.employee.springbootangularcrudapi27.repository;

import in.snva.employee.springbootangularcrudapi27.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
