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
public class TestLinkList {
    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList<Integer>();
        list.push(1).push(2).push(3).unshift(1).unshift(2).unshift(3).print();
    }
}
