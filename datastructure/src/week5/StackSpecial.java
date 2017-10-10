/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5;

/**
 *
 * @author pakkapon
 */
public class StackSpecial {
    public static int random(int min,int max){
        return (int) (min+(Math.random()*(max-min+0.5)));
    }
    public static void main(String[] args){
        Stack stack = new Stack(10);
        int prev = -1,current;
        try{
            while(true){
                current = random(0,99);
                System.out.print("Random:"+current+" ");
                if(current == prev){
                    System.out.print("*Quit* ");
                    break;
                }
                if(stack.isEmpty() || isAccept((int)stack.peek(),current)){
                    if(stack.isFull()){
                        System.out.print("Stack:*Full* ");
                        break;
                    }else{
                        System.out.print("Push:"+current+" ");
                        stack.push(current);
                    }
                }else{
                    if(stack.isEmpty()){
                        System.out.print("Stack[0]:*Empty*");
                        break;
                    }else{
                        System.out.print("Pop:"+stack.peek()+" ");
                        stack.pop();
                    }
                }
                System.out.print("Stack["+stack.getSize()+"]:");
                stack.show();
                prev = current;
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    private static boolean isAccept(int stk, int current) {
        if(stk % 10 + current % 10 == 10){
            return false;
        }
        if(stk % 10 == current % 10){
            return false;
        }
        if(stk / 10 == current % 10){
            return false;
        }
        if(stk / 10 == current / 10){
            return false;
        }
        if(stk % 10 == current / 10){
            return false;
        }
        return true;
    }
}
