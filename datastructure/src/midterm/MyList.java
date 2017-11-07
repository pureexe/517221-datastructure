package midterm;

/**
 *
 * @author pakkapon
 */
public class MyList{
    private Node front,rear;
    private class Node{
        int data;
        Node previous,next;
        Node(){
            
        }
        Node(int data){
            this.data = data;
        }
    }
    /**
     * Insert data at front of list
     * @param data 
     */
    public MyList unshift(int data){
        Node node = new Node(data);
        try{
            front.previous = node;
            node.next = front;
            front = node;
        }catch(NullPointerException e){
            front = node;
            rear = node;
        }
        return this;
    }
    /**
     * Insert data at rear of list
     * @param data
     */
    public MyList push(int data){
        Node node = new Node(data);
        try{
            rear.next = node;
            node.previous = rear;
            rear = node;
        }catch(NullPointerException e){
            front = node;
            rear = node;
        }
        return this;
    }
    /**
     * remove front node;
     * @return Type data
     */
    public int shift(){
        Node temp = front;
        front = front.next;
        front.previous = null;
        if(front == null){
            rear = null;
        }
        return temp.data;
    }
    /**
     * remove rear node
     * @return Type data
     */
    public int pop(){
        Node temp = rear;
        rear = rear.previous;
        rear.next = null;
        if(rear == null){
            front = null;
        }
        return temp.data;
    }
    /**
     * search object with indexOf
     * @return int position
     */
    public int indexOf(int data){
        Node trav = front;
        int pos = 0;
        while(trav != null){
            if(trav.data == data){
                return pos;
            }
            pos++;
            trav = trav.next;
        }
        return -1;
    }
    /**
     * insert sorted
     */
    public MyList insertSort(int data){
        if(front == null || front.data > data){
            this.unshift(data);
            return this;
        }
        if(rear.data < data){
            this.push(data);
            return this;
        }
        Node node = new Node(data);
        Node trav = front;
        Node temp;
        while(trav != null){
            if(trav.data > data){
                temp = trav.previous;
                temp.next = node;
                node.previous = temp;
                trav.previous = node;
                node.next = trav;
                break;
            }
            trav = trav.next;
        }
        return this;
    }
    /**
     * remove
     */
    public MyList remove(int data){
        Node trav = front;
        Node a,b;
        while(trav != null){
            if(trav.data == data){
                a = trav.previous;
                b = trav.next;
                a.next = b;
                b.previous = a;
                break;
            }
            trav = trav.next;
        }
        return this;
    }
    @Override
    public String toString(){
        String output = "[ ";
        Node trav = front;
        while(trav != null){
            output+=trav.data+" ";
            trav = trav.next;
        }
        return output + "]";
    }
}
