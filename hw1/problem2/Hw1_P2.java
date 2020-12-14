package cs526.hw1.problem2;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hw1_P2 class used to test the Employee and SalariedEmployee classes
 */
public class Hw1_P2 {

  /**
   * Displays the Employee info for employee objects with salaries above a passed in threshold to
   * the method.
   * @param empArray
   * @param threshold
   */
  public static void employeesAbove(SalariedEmployee[] empArray, double threshold){
    System.out.printf("%nEmployees earning more than $%.2f", threshold);
    System.out.println();
    System.out.println();
    for(int i = 0; i < empArray.length; i++){
      /**
       * If the salary for the current employee in the loop exceeds the threshold salary,
       * display the Employee information for the current employee
       */
      if(empArray[i].getSalary() > threshold){
        empArray[i].employeeInfo();
      }
    }
  }

  /**
   * Diver main class to read in the test employee data and build the Employee Array.
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    String[] employee;
    /**
     * Initialize the employeeIndex which represents which employee of the 'employeeArray'
     */
    int employeeIndex = 0;
    // set the filePath to the location of the text file
    String filePath = "src/cs526/hw1/problem2/employee_input.txt";
    // initialize and array of 10 SalariedEmployee type objects
    SalariedEmployee[] employeeArray = new SalariedEmployee[10];

    /**
     * Use the file path to create a new File object to pass into the new Scanner object to be
     * used to read the text file into memory
     */
    Scanner fileInput = new Scanner (new File(filePath));

    /**
     * Loop through the file grabbing each line of the file and splitting that line using
     * the comma and one or more spaces as the delimiter to get a character array for each line.
     */
    while (fileInput.hasNext()){
      employee = fileInput.nextLine().split(",\\s+");
      /**
       * create a salariedEmployee object and fill the employeeArray with each one
       * The employee character array index of the employee id integer is 0, the index of the
       * employee name string is 1, and the index of the employee salary double is 2
       */
      employeeArray[employeeIndex] = new SalariedEmployee(
        Integer.parseInt(employee[0]),
        employee[1],
        Double.parseDouble(employee[2])
      );
      // increment the employIndex to get to the next spot in the employee Array
      employeeIndex++;
    }
    // close the Scanner object
    fileInput.close();

    /**
     * call the 'employeesAbove' method to show all the employees with a salary above that threshold
     */
    employeesAbove(employeeArray, 70000);

    /**
     * Three more invocations with differing thresholds passed
     */
    employeesAbove(employeeArray,115000);
    employeesAbove(employeeArray, 200000);
    employeesAbove(employeeArray, 0);

  }
}
