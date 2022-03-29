package tech.getarrays.EmployeeManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.EmployeeManagement.Exception.UserNotFoundException;
import tech.getarrays.EmployeeManagement.Model.Employee;
import tech.getarrays.EmployeeManagement.Repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id"+id+"was not found"));
    }
    public void deleteEmployee(Long id) {
        boolean exists=employeeRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("employee" +
                    id+"does not exists");
        }
        employeeRepo.deleteById(id);
    }

}
