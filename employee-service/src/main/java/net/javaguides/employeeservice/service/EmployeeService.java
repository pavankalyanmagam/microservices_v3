package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.model.APIResponse;
import net.javaguides.employeeservice.model.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto dto);

    APIResponse getEmployeeById(Long id);
}
