package tech.getarrays.EmployeeManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.EmployeeManagement.Model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
     void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
