/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

/**
 *
 * @author pakkapon
 */
public class QueueOddEven {
    public static class Queue{
        Node front,rear;
        int length;
        public class Node{
            public Node next;
            int data;
            Node(int d){
                data = d;
            }
        }
        public void enqueue(int data){
            Node node = new Node(data);
            if(front == null){
               front = rear = node;
            }else{
                rear.next = node;
                rear = node;
            }
            length++;
        }
        public int dequeue(){
            int data = front.data;
            front = front.next;
            if(front == null){
                rear = null;
            }
            length--;
            return data;
        }
        public int peek(){
            return front.data;
        }
        @Override
        public String toString(){
            String out = "[";
            Node trav = front;
            while(trav != null){
                out+= " "+trav.data;
                trav = trav.next;
            }
            out += " ]";
            return out;
        }
    }
    public static int random(int min,int max){
        return (int)(Math.random()*(max-min+1))+min;
    }
    public static void main(String[] args){
        int temp,count,i,oddWin = 0,evenWin = 0,round = 0;
        Queue oddQueue = new Queue();
        Queue evenQueue = new Queue();
        count = random(10,20);
        System.out.println("--- Random numbers ["+count+"] ---");
        for(i = 0;i<count;i++){
            temp = random(0,100);
            System.out.print(""+temp+" ");
            if(temp % 2 == 0){
                evenQueue.enqueue(temp);
            }else{
                oddQueue.enqueue(temp);
            }
        }
        System.out.println("\n--- Even Queue ["+evenQueue.length+"] --- ");
        System.out.println(evenQueue);
        System.out.println("--- Odd Queue ["+oddQueue.length+"] --- ");
        System.out.println(oddQueue);
        while(oddQueue.length != 0 && evenQueue.length != 0){
            if(oddQueue.peek() > evenQueue.peek()){
                oddQueue.dequeue();
                evenQueue.enqueue(evenQueue.dequeue());
                oddWin++;
            }else{
                evenQueue.dequeue();
                oddQueue.enqueue(oddQueue.dequeue());
                evenWin++;
            }
            round++;
        }
        if(oddQueue.length == 0){
            System.out.printf("===> Winner is Odd!\nRound=%d, Win=(E:%d,O:%d), Even Left=%d\n",round,evenWin,oddWin,evenQueue.length);
        }else{
            System.out.printf("===> Winner is Even!\nRound=%d, Win=(E:%d,O:%d), Odd Left=%d\n",round,evenWin,oddWin,oddQueue.length);
        }
    }
}
