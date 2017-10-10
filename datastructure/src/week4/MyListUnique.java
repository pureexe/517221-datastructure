/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

/**
 *
 * @author pakkapon
 */
public class MyListUnique {
    public static int getRand(int min,int max)
    {
        return (int)((Math.random()*(max - min +1)))+min;
    }
    public static void main(String[] args)
    {
        int i,round,temp;
        round = getRand(10,20);
        ListNum listOdd = new ListNum();
        ListNum listEven = new ListNum();
        System.out.println("--- Random Numbers ["+round+"] ---");
        for(i = 0;i<round;i++){
            temp = getRand(0,20);
            System.out.print(temp+" ");
            if(temp% 2 ==0){
                listEven.insertSort(temp);
            }else{
                if(listOdd.indexOf(temp) != -1){
                    continue;
                }
                listOdd.insertSort(temp);
            }
        }
        System.out.println("\n--- List (All Even) ["+listEven.size()+"] ---");
            System.out.print(listEven);
        System.out.println("\n--- List (Unique Odd) ["+listOdd.size()+"] ---");
            System.out.print(listOdd);
    }
}
