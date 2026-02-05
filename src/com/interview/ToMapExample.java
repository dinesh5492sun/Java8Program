package com.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 | #   | Method Signature                                            | Description                                                  |
| --- | ----------------------------------------------------------- | ------------------------------------------------------------ |
| 1️⃣ | `toMap(keyMapper, valueMapper)`                             | Creates a map with keys and values from the stream           |
| 2️⃣ | `toMap(keyMapper, valueMapper, mergeFunction)`              | Handles duplicate keys                                       |
| 3️⃣ | `toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)` | Lets you define the Map type                                 |
| 4️⃣ | (Indirectly) used with `entrySet()`                         | Convert `Map` to another `Map` type or transform keys/values |


| Version                             | Example                                                         | Output Type | Use Case                  |
| ----------------------------------- | --------------------------------------------------------------- | ----------- | ------------------------- |
| `toMap(k, v)`                       | `toMap(Employee::getId, Employee::getName)`                     | `Map<K, V>` | Unique keys               |
| `toMap(k, v, mergeFn)`              | `toMap(Employee::getSalary, Employee::getName, (a,b)->a+","+b)` | `Map<K, V>` | Handle duplicate keys     |
| `toMap(k, v, mergeFn, mapSupplier)` | `toMap(..., TreeMap::new)`                                      | Custom Map  | Preserve order or sorting |
| Using `entrySet()`                  | Transform one Map to another                                    | `Map<K, V>` | Convert or remap          |

 
 
 */
class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + "-" + name + " (" + salary + ")";
    }
}

public class ToMapExample {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "Alice", 5000),
			    new Employee(102, "Bob", 6000),
			    new Employee(103, "Charlie", 7000),
			    new Employee(104, "David", 5000),
			    new Employee(105, "Eve", 6000)
			);
		
		//1 Basic form — toMap(keyMapper, valueMapper)
		//👉 You must ensure keys are unique — otherwise it throws IllegalStateException.
		Map<Integer, String> empMap =
			    employees.stream()
			             .collect(Collectors.toMap(Employee::getId, Employee::getName));

			empMap.forEach((id, name) ->
			    System.out.println("ID: " + id + ", Name: " + name)
			);

			/*
			 ID: 101, Name: Alice
			ID: 102, Name: Bob
			ID: 103, Name: Charlie
			ID: 104, Name: David
			ID: 105, Name: Eve
			*/
			
	//2Handle duplicates — toMap(keyMapper, valueMapper, mergeFunction)
	//If the key may appear multiple times (e.g., same salary),
	//you can define a merge function to decide which value to keep.
	//Example: group by salary → employee names (but multiple employees can share the same salary).		
			Map<Double, String> salaryToName =
				    employees.stream()
				             .collect(Collectors.toMap(
				                 Employee::getSalary,
				                 Employee::getName,
				                 (name1, name2) -> name1 + ", " + name2  // merge function
				             ));

				salaryToName.forEach((salary, names) ->
				    System.out.println("Salary: " + salary + " -> " + names)
				);

				
		/*
		    Salary: 5000.0 -> Alice, David
			Salary: 6000.0 -> Bob, Eve
			Salary: 7000.0 -> Charlie
		 */
		//3 Custom Map Type — toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)
	    //If you want a specific map type like TreeMap or LinkedHashMap:		
				
				Map<Double, String> sortedSalaryMap =
					    employees.stream()
					             .collect(Collectors.toMap(
					                 Employee::getSalary,
					                 Employee::getName,
					                 (name1, name2) -> name1 + ", " + name2,
					                 TreeMap::new  // Custom map supplier
					             ));

					System.out.println(sortedSalaryMap.getClass().getSimpleName()); // TreeMap
					sortedSalaryMap.forEach((salary, names) ->
					    System.out.println(salary + " => " + names)
					);
					
			/*
			 TreeMap
			5000.0 => Alice, David
			6000.0 => Bob, Eve
			7000.0 => Charlie
		
			 */

		//4 Transforming existing maps (example trick interview question)
		//Convert an existing Map<Integer, String> to Map<String, Integer> (key-value swap):	
					
					Map<Integer, String> original = Map.of(1, "A", 2, "B", 3, "C");

					Map<String, Integer> reversed =
					    original.entrySet().stream()
					            .collect(Collectors.toMap(
					                Map.Entry::getValue,
					                Map.Entry::getKey
					            ));

					System.out.println(reversed); // {A=1, B=2, C=3}

	}

}
