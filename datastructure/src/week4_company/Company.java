/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_company;

/**
 *
 * @author pakkapon
 */
public class Company {
    private int MaxEmployee;
    private int TotalEmployee;
    private Employee[] EmployeeList;
    Company(){
        this(1000);
    }
    Company(int max){
        this.MaxEmployee = max;
        this.TotalEmployee = 0;
        this.EmployeeList = new Employee[max];
    }
    public void addEmployee(Employee emp){
        this.EmployeeList[TotalEmployee++] = emp;
    }
    public Employee getEmployee(int no){
        return this.EmployeeList[no - 1];
    }
    public int getTotalEmployee(){
        return this.TotalEmployee;
    }
}
