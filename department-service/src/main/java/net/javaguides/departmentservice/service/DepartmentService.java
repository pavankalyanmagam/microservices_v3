package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.model.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String code);


}
