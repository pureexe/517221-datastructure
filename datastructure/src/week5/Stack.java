package week5;


public class Stack {
    private int max_size=100;
    private Object element[];
    private int current_size=0;
    public Stack() { element=new Object[max_size]; }
    public Stack(int s) { element=new Object[s]; max_size=s; }
    public boolean isFull() {
        return current_size==max_size;
    }
    public boolean isEmpty() {
        return current_size==0;
    }
    public int getMaxSize() {
        return max_size;
    }
    public int getSize() {
        return current_size;
    }
    public void push(Object obj) throws Exception {
        if(!isFull()) {
            element[current_size]=obj;
            current_size++;
        }
        else throw new Exception("Stack Overflow");
    }
    public Object peek() throws Exception {
        if(!isEmpty()) 
            return element[current_size-1];
        else throw new Exception("Stack Underflow");
    }
    public void pop() throws Exception {
        if(!isEmpty()) {
            current_size--;
        } else throw new Exception("Stack Underflow");
    }
    public void show() {
        for(int i=0;i<current_size;i++)
            System.out.print(element[i]+" ");
        System.out.println();
    }
}