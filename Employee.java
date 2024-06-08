public class Employee
{
Employee(int empid, String empName)
{
System.out.println("employee id "+empid);
System.out.println("employee Name "+empName);
}
Employee(String compName)
{
System.out.println("Name of company "+compName);
}
public static void main(String args[])
{
Employee emp1=new Employee(101,"jayesh");
Employee emp2=new Employee("Google");
}
}