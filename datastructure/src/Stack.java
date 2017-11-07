public  class  Stack {

    private class Node {
        private Object info = null;
        private Node link = null;

        public Node(Object info, Node link) {
            this.info=info; 
            this.link=link;
        }
        public Node(Object info)	{
            this(info,null);
        }
        public Node()	{
            this(null,null);
        }

        public Object getInfo() {
            return this.info;
        }

        public void setInfo(Object info) {
            this.info=info;
        }

        public Node getLink() {
            return this.link;
        }

        public void setLink(Node node) {
            this.link = node;
        }
    }

    private Node stackTop = null;
    private int stackSize = 0;

    public Stack() { }

    public int getSize() {
        return this.stackSize;
    }

    public boolean isEmpty() { 
        return (stackTop == null); 
    }

    public boolean isFull() { 
        return false; 
    }

    public void initialize()  { 
        stackTop = null;
    }

    public void push(Object newItem) throws Exception  { 
        Node newNode = new Node(newItem);
        newNode.setLink(stackTop);	
        stackTop = newNode;
        stackSize++;
    }

    public Object pop() throws Exception {
        Object itemInfo;
        if (isEmpty()) 
            throw new Exception("StackUnderflow"); 
        itemInfo=stackTop.getInfo();
        stackTop=stackTop.getLink();
        stackSize--;
        return itemInfo;
    }

    public Object peek() throws Exception { 
        if (isEmpty()) 
            throw new Exception("StackUnderflow"); 
        return stackTop.getInfo(); 
    }
    public void print() {
        Node trav=stackTop;
        System.out.print("[ ");
        while(trav!=null) {
            System.out.print(trav.getInfo());
            trav=trav.getLink();
            if(trav!=null)
                System.out.print(" ");
        }
        System.out.println(" ]");
    }
}
