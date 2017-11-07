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
public class ParentasisCheck {
    public static void main(String[] args){
        Stack stack = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c,peek;
        for(int i = 0; i< str.length();i++){
            c = str.charAt(i);
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }
            if(c == ']' || c ==')' || c == '}'){
                peek = (char) stack.peek();
                if((c == ']' && peek != '[')||(c == '(' && peek != ')')||(c == '}' && peek != '{')){
                    System.out.println("Error");
                    return;
                }
                stack.pop();
            }
        }
        if(stack.empty()){
            System.out.println("Ok");
        }else{
            System.out.println("Error");
        }
    }
}
