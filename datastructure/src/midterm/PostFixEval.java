/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.util.Stack;

/**
 *
 * @author pakkapon
 */
public class PostFixEval {
    public static void main(String[] args){
        String postfix = "512+4*+3-";
        Stack stack = new Stack<Integer>();
        char c;
        int a,b;
        for(int i = 0; i<postfix.length();i++ ){
            c = postfix.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                b = (int)stack.pop();
                a = (int)stack.pop();
                if(c == '+'){
                    stack.push(a+b);
                }
                if(c == '-'){
                    stack.push(a-b);
                }
                if(c == '*'){
                    stack.push(a*b);
                }
                if(c == '/'){
                    stack.push(a/b);
                }
            }else{
                stack.push(Integer.parseInt(""+c));
            }
        }
        System.out.println(stack.pop());
    }
}
