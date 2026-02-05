package com.java.employee.stream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    int age;
    double salary;

    public Employee(int id, String name, String department, int age, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + "(" + department + ", " + age + ", " + salary + ")";
    }
}

public class Java8EmployeePrograms {

    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
                new Employee(101, "Ravi", "IT", 25, 60000),
                new Employee(102, "Kiran", "HR", 30, 50000),
                new Employee(103, "Suresh", "IT", 35, 90000),
                new Employee(104, "Mahesh", "Finance", 28, 70000),
                new Employee(105, "Naresh", "HR", 45, 80000),
                new Employee(106, "Raj", "IT", 22, 40000),
                new Employee(107, "Manoj", "Finance", 50, 100000),
                new Employee(108, "Anil", "IT", 29, 75000)
        );

        // 1) Group employees by department
        Map<String, List<Employee>> groupByDept =
                empList.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\n1) Group employees by department:");
        groupByDept.forEach((k, v) -> System.out.println(k + " -> " + v));

        // 2) Highest salary employee
        Employee highestSalary =
                empList.stream()
                        .max(Comparator.comparing(Employee::getSalary))
                        .orElse(null);

        System.out.println("\n2) Highest salary employee:");
        System.out.println(highestSalary);

        // 3) Average salary per department
        Map<String, Double> avgSalaryByDept =
                empList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println("\n3) Average salary per department:");
        avgSalaryByDept.forEach((k, v) -> System.out.println(k + " -> " + v));

        // 4) Sort employees by salary + name
        List<Employee> sortedBySalaryAndName =
                empList.stream()
                        .sorted(Comparator.comparing(Employee::getSalary)
                                .thenComparing(Employee::getName))
                        .collect(Collectors.toList());

        System.out.println("\n4) Sort employees by salary + name:");
        sortedBySalaryAndName.forEach(System.out::println);

        // 5) Salary greater than X
        double x = 70000;
        List<Employee> salaryGreaterThanX =
                empList.stream()
                        .filter(e -> e.getSalary() > x)
                        .collect(Collectors.toList());

        System.out.println("\n5) Employees with salary > " + x + ":");
        salaryGreaterThanX.forEach(System.out::println);

        // 6) Youngest and Oldest employee
        Employee youngest =
                empList.stream()
                        .min(Comparator.comparing(Employee::getAge))
                        .orElse(null);

        Employee oldest =
                empList.stream()
                        .max(Comparator.comparing(Employee::getAge))
                        .orElse(null);

        System.out.println("\n6) Youngest employee: " + youngest);
        System.out.println("   Oldest employee: " + oldest);

        // 7) Count employees per department
        Map<String, Long> countPerDept =
                empList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        ));

        System.out.println("\n7) Count employees per department:");
        countPerDept.forEach((k, v) -> System.out.println(k + " -> " + v));

        // 8) Department with max employees
        Map.Entry<String, Long> maxDept =
                countPerDept.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .orElse(null);

        System.out.println("\n8) Department with max employees:");
        System.out.println(maxDept);

        // 9) Second highest salary employee
        Employee secondHighestSalary =
                empList.stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .skip(1)
                        .findFirst()
                        .orElse(null);

        System.out.println("\n9) Second highest salary employee:");
        System.out.println(secondHighestSalary);

        // 10) Convert List -> Map (id, name)
        Map<Integer, String> idNameMap =
                empList.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Employee::getName
                        ));

        System.out.println("\n10) List -> Map (id, name):");
        idNameMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}


/*



| Problem            | Key Java 8 Method              |
| ------------------ | ------------------------------ |
| Group by dept      | `Collectors.groupingBy()`      |
| Highest salary     | `max(Comparator.comparing())`  |
| Average salary     | `averagingDouble()`            |
| Sorting            | `sorted().thenComparing()`     |
| Salary > X         | `filter()`                     |
| Youngest / Oldest  | `min() / max()`                |
| Count per dept     | `Collectors.counting()`        |
| Dept max employees | `entrySet().stream().max()`    |
| 2nd highest salary | `sorted().skip(1).findFirst()` |
| List -> Map         | `Collectors.toMap()`           |
*/