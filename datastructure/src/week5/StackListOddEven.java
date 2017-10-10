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
public class StackListOddEven {
    private static class Node{
        public int data;
        public Node next;
        Node(int data){
            this.data = data;
        }
    }
    private static class MyStack{
        Node head;
        int size;
        MyStack(){
            size = 0;
        }
        public void push(int data){            
            Node node = new Node(data);
            node.next = head;
            head = node;
            size++;
        }
        public int pop(){
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        public int peek(){
            return head.data;
        }
        public boolean empty(){
            return head == null;
        }
        public int size(){
            return size;
        }
        @Override
        public String toString(){
            String output = "";
            Node current = head;
            while(current != null){
                output += current.data+" ";
                current = current.next;
            }
            return output;
        }
    }
    public static int random(int min,int max){
        return (int) (min+(Math.random()*(max-min+0.5)));
    }
    public static void main(String[] args){
        MyStack oddStack = new MyStack();
        MyStack evenStack = new MyStack();
        int round = random(10,20);
        int i,temp;
        System.out.println("--- Random Numbers ["+round+"] ---");
        for(i=0;i<round;i++){
            temp = random(0,100);
            System.out.print(""+temp+" ");
            if(temp % 2 == 0){
                evenStack.push(temp);
            }else{
                oddStack.push(temp);
            }
        }
        System.out.println();
        System.out.println("--- Even Stack ["+evenStack.size()+"] ---");
        System.out.println(evenStack);
        System.out.println("--- Odd Stack ["+oddStack.size()+"] ---");
        System.out.println(oddStack);
        while(!oddStack.empty() && !evenStack.empty()){
            if(oddStack.peek() > evenStack.peek()){
                oddStack.pop();
            }else if(evenStack.peek() > oddStack.peek()){
                evenStack.pop();
            }
        }
        if(evenStack.empty()){
            System.out.println("===> Even is the winner!");
        }else if(oddStack.empty()){
            System.out.println("===> Odd is the winner!");
        }
    }
}
