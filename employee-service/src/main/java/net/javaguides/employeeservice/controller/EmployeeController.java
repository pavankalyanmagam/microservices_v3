package net.javaguides.employeeservice.controller;

import net.javaguides.employeeservice.model.APIResponse;
import net.javaguides.employeeservice.model.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto dto) {
        EmployeeDto employeeDto = employeeService.saveEmployee(dto);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getEmployees(@PathVariable Long id) {
        APIResponse apiResponse = employeeService.getEmployeeById(id);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
