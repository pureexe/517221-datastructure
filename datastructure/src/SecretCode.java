/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pakkapon Phongthawee (07580028)
 */
import java.io.BufferedReader;
import java.io.FileReader;
public class SecretCode {
    public static void main(String[] args){
        try{            
            int ans;
            int a,b;
            char c;
            for(int fileNumber = 1;fileNumber <= 3 ; fileNumber++){
                Stack stack = new Stack();
                Queue queue = new Queue();
                Queue bufferQueue = new Queue();
                BufferedReader br = new BufferedReader(new FileReader("secretcode"+fileNumber+".txt"));
                String line;
                while((line = br.readLine()) != null){
                    if(line.charAt(0) == 'E'){
                        break;
                    }
                    for(int i = 0; i< line.length(); i++){
                        c = line.charAt(i);
                        if(c == 'P'){
                            b = (int) stack.pop();
                            a = (int) stack.pop();
                            stack.push((a+b)%10);
                        }else if(c == 'M'){
                            b = (int) stack.pop();
                            a = (int) stack.pop();
                            stack.push((int)Math.abs(a-b));
                        }else if(c == 'R'){
                            while(!stack.isEmpty()){
                                bufferQueue.enQueue(stack.pop());
                            }
                            while(!bufferQueue.isEmpty()){
                                stack.push(bufferQueue.deQueue());
                            }
                        }else{
                            stack.push(Character.getNumericValue(c));
                        }
                    }
                    if(stack.getSize() > 1){
                        throw new Exception("Invalid Input");
                    }else{
                        queue.enQueue(stack.pop());
                    }
                }
                for(int i = 1 ; i < line.length();i++){
                    c = line.charAt(i);
                    if(c == 'P'){
                        a = (int) queue.deQueue();                         
                        b = (int) queue.deQueue();
                        queue.enQueue((a+b)%10);
                    }else if(c == 'M'){
                        a = (int) queue.deQueue();
                        b = (int) queue.deQueue();
                        queue.enQueue((int)Math.abs(a-b));
                    }else if(c == 'R'){
                        while(!queue.isEmpty()){
                                stack.push(queue.deQueue());
                        }
                        while(!stack.isEmpty()){
                            queue.enQueue(stack.pop());
                        }
                    }else{
                        queue.enQueue(Character.getNumericValue(c));
                    }
                }
                if(queue.getSize() > 1){
                    throw new Exception("Invalid Queue Process");
                }else{
                    ans = (int) queue.deQueue();
                    System.out.println("Secret Code is: "+ans);
                }
            }               
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
