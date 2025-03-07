import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Employee {
    String name;
    String department;
    int salary;

    Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + department + ", $" + salary + ")";
    }
}

public class CollectorsExamples {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 5000),
                new Employee("Bob", "IT", 7000),
                new Employee("Charlie", "IT", 6000),
                new Employee("David", "Finance", 8000),
                new Employee("Eve", "Finance", 7500)
        );

        // 1. Collecting to List
        List<String> employeeNames = employees.stream()
                .map(e -> e.name)
                .toList();
        System.out.println("Employee Names: " + employeeNames);

        // 2. Collecting to Set
        Set<String> departments = employees.stream()
                .map(e -> e.department)
                .collect(toSet());
        System.out.println("Departments: " + departments);

        // 3. Collecting to Map (name -> salary)
        Map<String, Integer> nameToSalary = employees.stream()
                .collect(toMap(e -> e.name, e -> e.salary));
        System.out.println("Name to Salary: " + nameToSalary);

        // 4. Joining Names
        String joinedNames = employees.stream()
                .map(e -> e.name)
                .collect(joining(", ", "[", "]"));
        System.out.println("Joined Names: " + joinedNames);

        // 5. Counting Elements
        long count = employees.stream().collect(counting());
        System.out.println("Number of Employees: " + count);

        // 6. Summarizing Salaries
        IntSummaryStatistics salaryStats = employees.stream()
                .collect(summarizingInt(e -> e.salary));
        System.out.println("Salary Stats: " + salaryStats);

        // 7. Partitioning by Salary > 7000
        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
                .collect(partitioningBy(e -> e.salary > 7000));
        System.out.println("Partitioned By Salary > 7000: " + partitionedBySalary);

        // 8. Grouping by Department
        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(groupingBy(e -> e.department));
        System.out.println("Grouped By Department: " + groupedByDepartment);

        // 9. Mapping (Extracting Names by Department)
        Map<String, List<String>> namesByDepartment = employees.stream()
                .collect(groupingBy(e -> e.department, mapping(e -> e.name, toList())));
        System.out.println("Names By Department: " + namesByDepartment);

        // 10. Reducing (Finding Max Salary)
        Optional<Employee> highestPaid = employees.stream()
                .collect(reducing((e1, e2) -> e1.salary > e2.salary ? e1 : e2));
        System.out.println("Highest Paid Employee: " + highestPaid.orElse(null));

        // 11. Collecting And Then (Get Set of Names as Immutable Set)
        Set<String> immutableNames = employees.stream()
                .map(e -> e.name)
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
        System.out.println("Immutable Set of Names: " + immutableNames);
    }
}
