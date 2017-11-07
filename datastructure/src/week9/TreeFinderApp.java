/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9;

/**
 *
 * @author pakkapon
 */
public class TreeFinderApp {
    public static class Node{
        public Node left,right;
        public int data;
        Node(int data){
            this.data = data;
        }
    }
    public static class BinarySearchTree{
        Node root;
        public BinarySearchTree add(int data){
            if(root == null){
                root = new Node(data);
            }else{
                addNode(data,root);
            }
            return this;
        }
        public void addNode(int data,Node cursor)
        {
            if(cursor.data == data){
                if(cursor.right == null){
                    cursor.right = new Node (data);
                }else{
                    addNode(data,cursor.right);
                }
            }else if(cursor.data > data){
                if(cursor.left == null){
                    cursor.left = new Node(data);
                }else{
                    addNode(data,cursor.left);
                }
            }else if(cursor.data < data){
                if(cursor.right == null){
                    cursor.right = new Node(data);
                }else{
                    addNode(data,cursor.right);
                }
            }
        }
        public int height(){
            if(root == null){
                return 0;
            }
            return height(root);
        }
        public int height(Node cursor){
            int left = 0,right = 0;
            if(cursor.left == null && cursor.right == null){
                return 0;
            }
            if(cursor.left != null){
                left = height(cursor.left);
            }
            if(cursor.right != null){
                right = height(cursor.right);
            }
            if(left > right){
                return left+1;
            }else{
                return right+1;
            }
        }
        public void print(){
            print(root);
        }
        public void print(Node cursor){
            if(cursor == null){
                System.out.print(" - ");
                return ;
            }            
            System.out.print(" "+cursor.data+" ");
            if(cursor.left != null || cursor.right != null){
                System.out.print(" [ ");
                print(cursor.left);
                print(cursor.right);
                System.out.print("]");
           }
        }
        public boolean find(int data){
            boolean found = false;
            System.out.print(""+data+": (");
            if(root != null){
                found = find(data,root);
            }
            System.out.print(")");
            return found;
        }
        public boolean find(int data,Node cursor){
            boolean left = false,right = false;
            if(cursor.data == data){
                return true;
            }
            if(cursor.data > data && cursor.left != null){
                System.out.print("L");
                left = find(data,cursor.left);
            }
            if(cursor.data < data && cursor.right != null){
                System.out.print("R");
                right = find(data,cursor.right);
            }
            return left || right;
        }
    }
    public static int random(int min,int max){
        return (int)(Math.random()*(max-min+1))+min;
    }
    public static void main(String[] args){
        int round = random(10,20);
        int i,temp;
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("--- Random numbers ["+round+"] ---");
        for(i = 0; i < round ; i++){
            temp = random(0,50);
            bst.add(temp);
            System.out.print(""+temp+" ");
        }
        System.out.println("\n--- Tree (Height="+bst.height()+") ---");
        bst.print();
        System.out.println("\n--- Search ---");
        while(true){
            if(bst.find(random(0,50))){
                System.out.println(" Found!");
                break;
            }else{
                System.out.println(" Not Found!");
            }
        }
    }
    
    //Unit testing for sample case 1 : PASS
    /*
    public static void main(String[] args){
        int[] input = {26,47,0,31,30,10,19,48,7,30,1,4,1,14,11,22};
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("--- Random numbers ["+input.length+"] ---");
        for(int i: input){
            bst.add(i);
            System.out.print(""+i+" ");
        }
        System.out.println("\n--- Tree (Height="+bst.height()+") ---");
        bst.print();
        int[] toSearch = {15,1};
        System.out.println("\n--- Search ---");
        for(int i: toSearch){
            if(bst.find(i)){
                System.out.println(" Found!");
            }else{
                System.out.println(" Not Found!");
            }
        }
    }
    */
}
