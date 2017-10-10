package week4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pakkapon phongthawee (07580028)
 */
public class ListUnique {
    public static int getRand(int min,int max)
    {
        return (int)((Math.random()*(max - min +1)))+min;
    }
    public static void main(String[] args)
    {
        int i,round,temp;
        round = getRand(10,20);
        List<Integer> listOdd = new ArrayList<Integer>();
        List<Integer> listEven = new ArrayList<Integer>();
        System.out.println("--- Random Numbers ["+round+"] ---");
        for(i = 0;i<round;i++){
            temp = getRand(0,20);
            System.out.print(temp+" ");
            if(temp% 2 ==0){
                if(listEven.size() !=0 && temp < listEven.get(0)){
                    listEven.add(0, temp);
                }else{
                    listEven.add(temp);
                }
            }else{
                if(listOdd.indexOf(temp) != -1){
                    continue;
                }
                if(listOdd.size() !=0 && temp < listOdd.get(0)){
                    listOdd.add(0, temp);
                }else{
                    listOdd.add(temp);
                }
            }
        }
        System.out.println("\n--- List (All Even) ["+listEven.size()+"] ---");
        for(Integer x: listEven){
            System.out.print(x+" ");
        }
        System.out.println("\n--- List (Unique Odd) ["+listOdd.size()+"] ---");
        for(Integer x: listOdd){
            System.out.print(x+" ");
        }
    }
}
