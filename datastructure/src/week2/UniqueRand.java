package week2;

import java.util.Scanner;

/**
 *
 * @author pakkapon phongthawe (07580028)
 */
public class UniqueRand {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number > ");
        int seed = sc.nextInt();
        int i,rand,count = 0;
        int[] table = new int[seed];
        for(i=0 ;i < seed;i++){
            table[i] = 0;
        }
        while(count < seed){
           rand = (int)(Math.random()*seed);
           if(table[rand] == 0){
               table[rand] = 1;
               System.out.print((rand+1)+" ");
               count++;
               if(count % 20 == 0){
                   System.out.print("\n");
               }
           }
        }
    }
}
