package com.DatabaseProgramming.crudapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        EmployeeDaoIntrf dao = new EmployeeDaoImpl();
        System.out.println("Welcome to Employee Management Application");
        Scanner sc = new Scanner(System.in);
    do {
        System.out.println("1. Add Employee\n"+
                "2. Show All Employees\n"+
                "3. Show Employee based on id\n"+
                "4. Update the Employee\n"+
                "5. Delete the Employee\n");
        System.out.println("Enter Command Number: ");
        int ch = sc.nextInt();
        switch (ch)
        {
            case 1:
                Employee emp  = new Employee();
                System.out.println("Enter ID: ");
                id = sc.nextInt();
                System.out.println("Enter name ");
                name = sc.next();
                System.out.println("Enter Salary ");
                double salary = sc.nextDouble();
                System.out.println("Enter age: ");
                int age = sc.nextInt();
                emp.setId(id);
                emp.setName(name);
                emp.setSalary(salary);
                emp.setAge(age);
                dao.createEmployee(emp);
                break;
            case 2:
                dao.showAllEmployee();
                break;
            case 3:
                System.out.println("Enter id to show the Details ");
                int empid = sc.nextInt();
                dao.showEmployeeBasedOnID(empid);
                break;
            case 4:
                System.out.print("Enter id to update the details");
                int empid1 = sc.nextInt();
                System.out.println("Enter the new name");
                name = sc.next();
                dao.updateEmployee(empid1,name);
                break;
            case 5:
                System.out.println("Enter the Id to delete \n");
                id = sc.nextInt();
                dao.DeleteEmployee(id);
                break;
            case 6:
                System.out.println("Thank you for using our Application!");
                System.exit(0);
            default:
                System.out.println("Enter valid Choice !");
        }

    }while (true);
    }
}
