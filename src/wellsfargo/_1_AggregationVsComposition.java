package wellsfargo;

// Composition
class Employee {
	String name;
	// 'Part-Of' relation
	Job job;

	Employee(String name, float salary) {
		this.name = name;
		// Job is composed in fully into Employee. It doesn't exist without Employee
		this.job = new Job(salary);
	}
}

// Aggregation
class Bank {
	String name;
	// Has-A relation
	Employee employee;

	Bank(String name, Employee employee) {
		this.name = name;
		// Employee has aggregation relationship with Bank. Employee will be there even
		// if we destroy Bank.
		this.employee = employee;
	}
}

// Composition
class Job {
	float salary;

	Job(float salary) {
		this.salary = salary;
	}
}

public class _1_AggregationVsComposition {

	public static void main(String[] args) {
		Employee vel = new Employee("Vel", 12.5f);

		Bank b = new Bank("Axis", vel);// wellsfargo.Employee@1175e2db //
		// b = null;
		// Aggregation
		System.out.println(vel.name);

		System.out.println(b.employee.job.salary);

	}
}
