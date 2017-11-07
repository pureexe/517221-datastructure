/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

/**
 *
 * @author pakkapon
 */
public class TestMyList {
    public static void main(String[] args){
        MyList myList = new MyList();
        myList
            .insertSort(3)
            .insertSort(4)
            .insertSort(2);
        System.out.println(myList);
        myList.unshift(1);
        System.out.println(myList);
        myList.push(5);
        System.out.println(myList);
        System.out.println(myList.indexOf(3));
        myList.remove(3);
        System.out.println(myList);
        myList.shift();
        System.out.println(myList);
        myList.pop();
        System.out.println(myList);
    }
}
