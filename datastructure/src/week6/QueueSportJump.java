/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pakkapon
 */
public class QueueSportJump {
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
    public static boolean isNewQueueComing(){
        return random(0,1) == 1;
    }
    public static void main(String[] args){
        int i,maxLength = 0;
        Queue queue = new Queue();
        for(i = 0;i<20;i++){
            if(isNewQueueComing()){
                queue.enqueue(random(1,3));
                if(maxLength < queue.length){
                    maxLength = queue.length;
                }
            }
            if(queue.length > 0){
                if(queue.peek() > 0){
                    queue.front.data--;
                }else{
                    queue.dequeue();
                }
            }
        }
        System.out.println("Longest Queue is: "+maxLength);
    }
}
