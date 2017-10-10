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
public class Person {
    private String name;
    private char sex;
    private int age;
    private double height;
    private double weight;
    private boolean single;
    Person(){
        this(null,' ',0,0.0,0.0,true);
    }
    Person(String name){
        this(name,' ',0,0.0,0.0,true);
    }
    Person(String name,char sex){
        this(name,sex,0,0.0,0.0,true);
    }
    Person(String name,int age){
        this(name,' ',age,0.0,0.0,true);
    }
    Person(String name,char sex,int age){
        this(name,sex,age,0.0,0.0,true);
    }
    Person(String name,char sex,int age,double height,double weight,boolean single){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.single = single;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSex(char sex){
        this.sex = sex;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setSingle(boolean single){
        this.single = single;
    }
    public void setInfo(String name,char sex,int age,double height,double weight,boolean single){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.single = single;
    }
    public String getName(){
        return this.name;
    }
    public char getSex(){
        return this.sex;
    }
    public int getAge(){
        return this.age;
    }
    public double getHeight(){
        return this.height;
    }
    public double getWeight(){
        return this.weight;
    }
    public boolean isSingle(){
        return this.single;
    }
    public double getBMI(){
        double meterHeight = this.height/100.0;
        return this.weight / (meterHeight*meterHeight);
    }
    public int getBodyState(){
        if(this.height <=0 || this.weight <= 0){
            return -1;
        }
        double bmi = this.getBMI();
        if(bmi < 18.5){
            return 0;
        }
        if(bmi < 25){
            return 1;
        }
        if(bmi < 30){
            return 2;
        }
        return 3;
    }
    @Override
    public String toString(){
        return (this.sex == 'M'?"Mr.":"Mrs.")
            + this.name
            + " is "+this.age
            + " years old and "
            + (this.single?"single":"married")
            + ". "
            + (this.sex == 'M'?"He":"She")
            + " has "
            + this.getBodyState()
            + " body "
            + " (BMI="
            + this.getBMI()
            + ")";
    }
}
