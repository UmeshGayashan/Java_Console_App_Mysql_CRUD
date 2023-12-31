package com.DatabaseProgramming.crudapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf{
    Connection con;
    @Override
    public void createEmployee(Employee emp) {
        con = DBConnection.createDBConnection();
        String query = "Insert into employee values(?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int cnt = pstm.executeUpdate();
            if(cnt != 0)
            {
                System.out.println("Employee inserted successfully");
            }
        }catch ( Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query = "Select * from employee";
        System.out.println("Employee Details : ");
        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","Age");
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con =DBConnection.createDBConnection();
        String query = "Select * from employee where id = "+id;
        System.out.println("Employee Details : ");
        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","Age");
        try{
            Statement stmt = con.createStatement();
            ResultSet result =  stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query = "Update employee set name=? where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt = pstm.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Employee Details updated Successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query = "Delete from employee where id=?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt = pstm.executeUpdate();
            if(cnt != 0){
                System.out.println("Employee Deleted Successfully !"+id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
