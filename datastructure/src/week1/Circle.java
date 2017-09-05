/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

/**
 *
 * @author pakkapon phongthawee (07580028)
 */
public class Circle {
    private String color;
    private double radius;
    Circle(double radius,String color){
        this.radius = radius;
        this.color = color;
    }
    public double getRadius()
    {
        return this.radius;
    }
    public String getColor()
    {
        return this.color;
    }
    public double calArea()
    {
        return Math.PI*radius*radius;
    }
    @Override
    public String toString()
    {
        return "{\"radius\":"+radius+",\"color\":\""+color+"\"}";
        
    }
}
