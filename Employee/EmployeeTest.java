public class EmployeeTest
{
    public static void main(String[] args)
    {
        Employee e1 = new Employee("Steve", "Jobs", 700);
        Employee e2 = new Employee("Tim", "Cook", 5000);

        System.out.println("Yearly Salary of "+ e1.getFirstName() + " " + e1.getLastName() + "= $"+ e1.yearlySalary());
        System.out.println("Yearly Salary of "+ e2.getFirstName() + " " + e2.getLastName() + "= $"+ e2.yearlySalary());
        e1.raiseSalary();
        e2.raiseSalary();

        System.out.println("Yearly Salary of "+ e1.getFirstName() + " " + e1.getLastName() + " after raise " + "= $"+ e1.yearlySalary());
        System.out.println("Yearly Salary of "+ e2.getFirstName() + " " + e2.getLastName() + " after raise " + "= $"+ e2.yearlySalary());

    }
}
