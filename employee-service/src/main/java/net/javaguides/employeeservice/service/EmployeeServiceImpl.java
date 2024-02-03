package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.model.APIResponse;
import net.javaguides.employeeservice.model.DepartmentDto;
import net.javaguides.employeeservice.model.EmployeeDto;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient webClient;

    @Autowired
    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto dto) {

        Employee employee = new Employee(
                dto.getId(), dto.getFirstName(),dto.getLastName(),dto.getEmail(), dto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto employeeDto = new EmployeeDto(savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode());
        return employeeDto;
    }

    @Override
    public APIResponse getEmployeeById(Long id) {
        Optional<Employee> byId = employeeRepository.findById(id);

        // ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/" + byId.get().getDepartmentCode(), DepartmentDto.class);

        //DepartmentDto departmentDto = responseEntity.getBody();

        //DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/v1/department/" + byId.get().getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(byId.get().getDepartmentCode());
        EmployeeDto employeeDto = new EmployeeDto(byId.get().getId(), byId.get().getFirstName(), byId.get().getLastName(), byId.get().getEmail(),byId.get().getDepartmentCode());

        APIResponse apiResponse = new APIResponse();
        apiResponse.setEmployeeDto(employeeDto);
        apiResponse.setDepartmentDto(departmentDto);
        return apiResponse;

    }


}
