package week4;
/**
 * @author Pakkapon Phongthawee (07580028)
 * to see implementation goto line 100
 */
public class ListNum {

    public class Node {

        private int info;
        private Node link;

        public Node(int info, Node link) {
            this.info = info;
            this.link = link;
        }

        public Node(int info) {
            this(info, null);
        }

        public Node() {
            this(0, null);
        }

        public int getInfo() {
            return this.info;
        }

        public Node getLink() {
            return this.link;
        }

        public void setInfo(int info) {
            this.info = info;
        }

        public void setLink(Node link) {
            this.link = link;
        }

        public String toString() {
            return "" + this.info;
        }
    }
    public Node head = null;

    public ListNum() {
    }

    public void addNode(int newInfo) {
        Node newNode = new Node(newInfo);
        newNode.setLink(head);
        head = newNode;
    }

    public String toString() {
        Node trav = head;
        String str = "";
        while (trav != null) {
            str = str.concat(trav.toString());
            //str=str.concat(""+trav.getInfo());
            trav = trav.getLink();
            if (trav != null) {
                str = str.concat(" ");
            }
        }
        return str;
    }

    public static void main(String[] args) {
        ListNum list = new ListNum();
        //Debug case;
        // Question 3
        list.insertSort(2);
        list.insertSort(3);
        list.insertSort(5);
        list.insertSort(1);
        list.insertSort(4);
        System.out.println(list); // result: 1|2|3|4|5
        //Question 2
        list.push(6);
        System.out.println(list); // result: 1|2|3|4|5|6
        //Question 1
        System.out.println(list.size()); // result: 6
        //Question 4
        list.shift();
        System.out.println(list); // result: 2|3|4|5|6
        //Question 5
        list.pop();
        System.out.println(list); // result: 2|3|4|5
        //Question 6
        System.out.println(list.indexOf(4)); //result: 2 (start at index 0)
        //Question 7
        list.remove(4);
        System.out.println(list); // result: 2|3|5 
    }

    /**
     *  Pakkapon Phongthawee (07580028)'s implementation
     */
    /**
     * find length of linkedlist (Question 1)
     *
     * @method size
     * @return int lengthOfLinkedlist
     */
    public int size() {
        int length = 0;
        Node current = head;
        while (current != null) {
            current = current.getLink();
            length++;
        }
        return length;
    }

    /**
     * add new data to end of Linked list (Question 2)
     *
     * @method push
     * @param int data
     */
    public void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.getLink() != null) {
                current = current.getLink();
            }
            current.setLink(node);
        }
    }
    /**
     * insertion sort (Question 3)
     * @method insertSort
     * @param int data
     */
    public void insertSort(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else if(head.getInfo() > data){
            node.setLink(head);
            head = node;
        }else{
            Node joint,trav;
            joint = trav = head;
            while(trav != null && trav.getInfo() < data){
                joint = trav;
                trav = trav.getLink();                
            }
            trav = joint.getLink();
            node.setLink(trav);
            joint.setLink(node);
        }
    }
    /**
     * remove first element (Question 4)
     * @method shift
     */
    public void shift(){
        if(head != null){
            head = head.getLink();
        }
    }
    /**
     * remove last element (Question 5)
     * @method pop
     */
    public void pop(){
        if(head != null){
            Node trav,joint;
            joint = trav = head;
            while(trav.getLink() != null){
                joint = trav;
                trav = trav.getLink();
            }
            joint.setLink(null);
        }
    }
    /**
     * find position of data (Question 6)
     * @method indexOf
     * @return int position
     */
    public int indexOf(int data){
        int position = -1;
        Node trav = head;
        while(trav != null){
            position++;
            if(trav.getInfo() == data){
                return position;
            }
            trav = trav.getLink();
        }
        return -1;
    }
    /**
     * remove specify data (Question 7)
     * @method remove
     * @return int position
     */
    public void remove(int data){
        Node trav,joint;
        joint = trav = head;
        while(trav != null){
            if(trav.getInfo() == data){
               joint.setLink(trav.getLink());
               return;
            }
            joint = trav;
            trav = trav.getLink();
        }
    }
}
