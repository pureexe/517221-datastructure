/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

import java.util.Scanner;

/**
 *
 * @author pakkapon
 */
public class TestCircle {
    public static void main(String[] args)
    {
        Circle a,b;
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        String color = sc.next();
        a = new Circle(radius,color);
        b = new Circle(radius*2,color);
        System.out.println("Circle1: raidus="+a.getRadius()+", color="+a.getColor());
        System.out.println("Circle2: radius="+b.getRadius()+", color="+b.getColor());
    }
}
