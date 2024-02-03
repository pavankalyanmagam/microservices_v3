package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.model.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("/api/v1/department/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);


}
