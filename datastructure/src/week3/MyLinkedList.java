/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;

/**
 *
 * @author pakkapon
 */
public class MyLinkedList<Type> {
    public Node head;
    public class Node
    {
        public Type info;
        public Node link;
        Node(Type info,Node link){
            this.info = info;
            this.link = link;
        }
        Node(Type info){
            this.info = info;
        }
        Node(){
            
        }
        public Type getInfo(){
            return this.info;
        }
        public void setInfo(Type data){
            this.info = data;
        }
        public void setLink(Node link){
            this.link = link;
        }
        public Node getLink(){
            return this.link;
        }
    }
    public MyLinkedList unshift(Type data)
    {
        Node node = new Node(data);
        try{
            node.link = head;
        }catch(NullPointerException e){
            
        }
        head = node;
        return this;
    }
    public MyLinkedList push(Type data)
    {
        Node node = new Node(data);
        Node trav = head;
        try{
            while(trav.link != null)trav = trav.link;
            trav.link = node;
        }catch(NullPointerException e){
            head = node;
        }
        return this;
    }
    public void print()
    {
        Node trav = head;
        while(trav != null){
            System.out.println(trav.info);
            trav = trav.link;
        }
    }
}
