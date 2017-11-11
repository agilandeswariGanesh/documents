package employee.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import employee.entity.EmployeeEntity;

public class EmployeeService {

	private static List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>(Arrays.asList(
			new EmployeeEntity(Integer.valueOf(new Double(Math.random()).intValue()), "agila", "ganesh",
					"agilaganesh92@gmail.com", 12345, getDate("01121992"), false),
			new EmployeeEntity(Integer.valueOf(new Double(Math.random()).intValue()), "priya", "vani",
					"priya@gmail.com", 12345, getDate("10072011"), false),
			new EmployeeEntity(Integer.valueOf(new Double(Math.random()).intValue()), "giddaiah", "kummari",
					"giddu@gmail.com", 12345, getDate("10112011"), false)));

	public List<EmployeeEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return employees;
	}

	private static Date getDate(String date) {
		Date dob = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			dob = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dob;
	}

	public void saveUser(EmployeeEntity employeeEntity) {
		employeeEntity.setId(new Double(Math.random()).intValue());
		employees.add(employeeEntity);
	}

	public EmployeeEntity updateEmployeeDetails(EmployeeEntity entity) {
		for (EmployeeEntity employeeDetails : employees) {
			if (entity.getId().equals(entity.getId())) {
				employeeDetails.setBirthDate(entity.getBirthDate());
				employeeDetails.setEmail(entity.getEmail());
				break;
			}
		}

		for (EmployeeEntity details : employees) {
			if (entity.getId().equals(entity.getId()))
				return details;
		}

		return null;
	}

	public void deleteUserById(Integer id) {
		for (EmployeeEntity entity : employees) {
			if (entity.getId().equals(id)) {
				employees.remove(entity);
				break;
			}
		}
	}

}
