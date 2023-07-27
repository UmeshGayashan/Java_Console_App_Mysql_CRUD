package com.DatabaseProgramming.crudapp;

public interface EmployeeDaoIntrf {
    void createEmployee(Employee emp);
    //Show all employee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnID(int empid);
    //update employee
    public void updateEmployee(int id,String name);
    //delete employee
    public void DeleteEmployee(int id);
}
