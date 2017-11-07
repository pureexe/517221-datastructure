/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author pakkapon
 */
public class Convert {
    public static void main(String[] args){
        Stack stack = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        int base = sc.nextInt();
        while(data > 0){
            stack.push(data%base);
            data /= base;
        }
        while(!stack.empty()){
            System.out.print(stack.pop());
        }
    }
}
