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
public class Employee extends Person {
    private double salary;
    private int work_length;
    Employee(){
        super();
    }
    Employee(String name){
        super(name);
    }
    Employee(String name,char sex){
        super(name,sex);
    }
    Employee(String name,int age){
        super(name,age);
    }
    Employee(String name,char sex,int age,double height,double weight,boolean single){
        super(name,sex,age,height,weight,single);
    }    
    Employee(String name,char sex,int age,double height,double weight,boolean single,double salary,int work_length){
        super(name,sex,age,height,weight,single);
        this.salary = salary;
        this.work_length = work_length;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setWorkLength(int work_length){
        this.work_length = work_length;
    }
    public double getSaraly(){
        return this.salary;
    }
    public int getWorkLength(){
        return this.work_length;
    }
}
