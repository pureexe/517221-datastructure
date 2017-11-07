public  class  Queue {

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

    private Node queueFront = null;
    private Node queueBack = null;
    private int queueSize = 0;

    public Queue() { }

    public int getSize() {
        return this.queueSize;
    }

    public boolean isEmpty() { 
        return (queueSize == 0); 
    }

    public boolean isFull() { 
        return false; 
    }

    public void initialize()  { 
        queueFront = null;
        queueBack = null;
    }

    public void enQueue(Object newItem) throws Exception  { 
        Node newNode = new Node(newItem);    
        if(queueFront==null) {
            queueFront=newNode;
        } else
            queueBack.setLink(newNode);
        queueBack=newNode;
        queueSize++;
    }

    public Object deQueue() throws Exception {
        Object itemInfo;
        if (isEmpty()) 
            throw new Exception("QueueUnderflow"); 
        itemInfo=queueFront.getInfo();
        queueFront=queueFront.getLink();
        queueSize--;
        return itemInfo;
    }

    public Object front() throws Exception { 
        if (isEmpty()) 
            throw new Exception("QueueUnderflow"); 
        return queueFront.getInfo(); 
    }
    public Object back() throws Exception { 
        if (isEmpty()) 
            throw new Exception("QueueUnderflow"); 
        return queueBack.getInfo(); 
    }
    public void print() {
        Node trav=queueFront;
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
