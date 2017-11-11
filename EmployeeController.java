package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import employee.entity.EmployeeEntity;
import employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees/", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeEntity>> getAllUsers() {
		List<EmployeeEntity> employee = employeeService.getAllUsers();
		if (employee.isEmpty())
			return new ResponseEntity<List<EmployeeEntity>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<EmployeeEntity>>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody EmployeeEntity employee) {
		employeeService.saveUser(employee);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.POST)
	public ResponseEntity<EmployeeEntity> updateEmployeeDetails(@PathVariable Integer id,
			@RequestBody EmployeeEntity entity) {

		EmployeeEntity employee = employeeService.updateEmployeeDetails(entity);
		return new ResponseEntity<EmployeeEntity>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployeeDetails(@PathVariable("id") Integer id) {		
		employeeService.deleteUserById(id);
		return new ResponseEntity<EmployeeEntity>(HttpStatus.NO_CONTENT);
	}

}
