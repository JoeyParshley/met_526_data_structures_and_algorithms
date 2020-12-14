package cs526.hw1.problem2;

/**
 * SalariedEmployee class inherits from Employee Class
 */
public class SalariedEmployee extends Employee {
  // additional instance variables used for the Salaried Class
  private double salary;

  /**
   * Default Salaried employee constructor
   */
  public SalariedEmployee() { }

  /**
   * Constructor to build an object given an Id, name and salary
   * @param empId
   * @param name
   * @param salary
   */
  public SalariedEmployee(int empId, String name, double salary) {
    /**
     * Call the super method to used the Employee (id and name) constructor to initialize
     * empId and name
     */
    super(empId, name);
    // Initialize the salary for this object
    this.salary = salary;
  }

  /**
   * Return the salary of the salaried employee
   * @return
   */
  public double getSalary() {
    return salary;
  }

  /**
   * sets the salary for the salaried employee
   * @param salary
   */
  public void setSalary(double salary) {
    this.salary = salary;
  }

  /**
   * Returns the monthly payment to the Salaried Employee which is determined
   * by the salary for this employee divided my 12
   * @return
   */
  public double monthlyPayment(){
    // cast the return to prevent inaccuracy due to integer division
    return (double) this.salary / 12;
  }

  /**
   * Displays the empId, name, salary and monthly payment for an employee
   */
  public void employeeInfo() {
    System.out.printf("    Employee id = %d%n", super.getEmpId());
    System.out.printf("    Name = %s%n", super.getName());
    System.out.printf("    Salary = %.2f%n", this.getSalary());
    System.out.printf("    Monthly pay = %.2f%n%n", this.monthlyPayment());
  }
}
