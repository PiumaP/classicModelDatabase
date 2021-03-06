package de.awacademy.classicModelsDemo.Data;

import de.awacademy.classicModelsDemo.Models.Employee;
import de.awacademy.classicModelsDemo.Models.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = repository.findAll();

        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }

    public List<Employee> getAllEmployees2(String officeCode) {
        List<Employee> employeeList = repository.findAll();
        ArrayList<Employee> employeesFromOffice = new ArrayList<Employee>();
        for (int i =0; i<employeeList.size(); i++){
            if(employeeList.get(i).getOffice().getOfficeCode()==officeCode){
                employeesFromOffice.add(employeeList.get(i));
            }
        }
        if(employeeList.size() > 0) {
            return employeesFromOffice;
        } else {
            return new ArrayList<Employee>();
        }
    }







    // TODO More convenience methods for INSERT, UPDATE and DELETE
}
