package com.interview;
import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    Integer managerId; // null if top-level manager

    public Employee(int id, String name, Integer managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', managerId=" + managerId + "}";
    }
}

public class EmployeeProgram {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "A", 3),
            new Employee(2, "B", 3),
            new Employee(3, "C", 5),
            new Employee(4, "D", 5),
            new Employee(5, "E", null), // CEO (no manager)
            new Employee(6, "F", 3),
            new Employee(7, "G", 5)
        );

        // ? Java 8 Stream solution:
        Map<Integer, Long> managerEmployeeCount =
            employees.stream()
                     .filter(e -> e.getManagerId() != null) // skip top-level manager
                     .collect(Collectors.groupingBy(
                         Employee::getManagerId,
                         Collectors.counting()
                     ));

        // Print result
        managerEmployeeCount.forEach((mgr, count) ->
            System.out.println("ManagerId: " + mgr + " -> Employees: " + count)
        );
        
        
        Map<Integer, List<String>> employeesByManager =
        	    employees.stream()
        	             .filter(e -> e.getManagerId() != null)
        	             .collect(Collectors.groupingBy(
        	                 Employee::getManagerId,
        	                 Collectors.mapping(e -> e.name, Collectors.toList())
        	             ));
        
        Map<Integer, List<String>> employeesByManager1 =
        	    employees.stream()
        	             .filter(e -> e.getManagerId() != null)
        	             .collect(Collectors.groupingBy(
        	                 Employee::getManagerId,
        	                 Collectors.mapping(e -> e.name, Collectors.toList())
        	             ));
        
        
        System.out.println(employeesByManager1);

    }
}
