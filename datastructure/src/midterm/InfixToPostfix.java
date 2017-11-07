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
public class InfixToPostfix {
    public static int getWeight(char c){
        if(c == '(' || c == ')' ){
            return 999;
        }
        if(c == '%'){
            return 3;
        }
        if(c == '*' || c == '/'){
            return 2;
        }
        if(c == '+' || c == '-'){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack stack = new Stack<Character>();
        char c;
        int weight = 0;
        for(int i = 0;i<str.length();i++){
            c = str.charAt(i);
            weight = getWeight(c);
            if(getWeight(c) == 0){
                System.out.print(c);
            }else if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while(!stack.empty()){
                    if((char)stack.peek() != '('){
                        System.out.print((char)stack.pop());
                    }else{
                        stack.pop();
                        break;
                    }
                }
            }else{
                if(stack.empty() || (char)stack.peek() == '('){
                    stack.push(c);
                }else{
                    while(!stack.empty()){
                        if((char)stack.peek() == '('){
                            stack.pop();
                            break;
                        }else{                            
                            System.out.print(stack.pop());
                        }
                    }
                    stack.push(c);
                }
            }
        }
        while(!stack.empty()){
            System.out.print(stack.pop());
        }
    }
}
