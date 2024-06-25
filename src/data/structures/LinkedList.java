package data.structures;

public class LinkedList {
    private Node head;

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node node = head;
            while (node.getNextNode() != null) {
                node = node.getNextNode();
            }
            node.setNextNode(newNode);
        }
    }

    public void insertAtStart(int data) {
        Node newHeadNode = new Node(data);
        newHeadNode.setNextNode(this.head);
        this.head = newHeadNode;
    }

    public void insertAt(int positionIndex, int data) {
        if (positionIndex == 0) {
            insertAtStart(data);
            return;
        }

        Node newNode = new Node(data);

        Node n = this.head;
        for (int i=0 ; i < positionIndex-1; i++) {
            n = n.getNextNode();
        }
        newNode.setNextNode(n.getNextNode());
        n.setNextNode(newNode);
    }

    public void deleteAt(int positionIndex) {
        if (positionIndex == 0) {
            this.head = this.head.getNextNode();
            return;
        }

        Node n = this.head;
        for (int i=0 ; i < positionIndex-1; i++) {
            n = n.getNextNode();
        }
        n.setNextNode(n.getNextNode().getNextNode());
    }

    public void displayElementsData() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }

        if (head.getNextNode() == null) {
            System.out.println(head.getData());
            return;
        }

        Node node = head;
        while (node.getNextNode() != null) {
            System.out.println(node.getData());
            node = node.getNextNode();
        }
        System.out.println(node.getData());
    }


    private static final class Node {
        private int data;
        private Node nextNode;

        Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
}
