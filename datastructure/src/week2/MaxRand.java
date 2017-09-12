/*
 * จงเขียนโปรแกรมสุ่มจำนวนเต็มบวก 100 ค่า
 * จากนั้นให้โปรแกรมหาเลขหลักหน่วย (เลขลงท้ายของจำนวนซึ่งได้แก่ 0-9)
 * ของบรรดาจำนวนเหล่านั้นที่เกิดขึ้นซ้ำกันมากที่สุด
 * โดยให้โปรแกรมแสดงเลขหลักหน่วยนั้นพร้อมกันจำนวนที่เกิดขึ้น 
 * หมายเหตุ สำหรับกรณีที่มีคำตอบเลขหลักหน่วยที่เกิดขึ้นซ้ำกันมากที่สุด
 * เป็นจำนวนเท่ากันมากกว่าหนึ่งคำตอบ ให้แสดงเลขหลักหน่วยดังกล่าวที่น้อยที่สุด
 * เป็นคำตอบเพียงแค่คำตอบเดียวเท่านั้น
 */
package week2;

/**
 *
 * @author pakkapon phongthawee (07580028)
 */
public class MaxRand {
   public static void main(String[] args){
       int[] countTable = new int[10];
       int i,rand,maxPos = 0,maxVal = 0;
       for(i = 0;i<10;i++)
       {
           countTable[i] = 0;
       }
       for(i = 0;i<100;i++){
           rand = (int)(Math.random()*Integer.MAX_VALUE)%10;
           countTable[rand]++;
       }
       for(i=0;i<10;i++){
           if(maxVal < countTable[i]){
               maxVal = countTable[i];
               maxPos = i;
           }
       }
       System.out.println(maxPos+" "+maxVal);
   } 
}
