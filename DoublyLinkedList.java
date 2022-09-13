// Java programming test question 1. 

public class DoublyLinkedList {
    // Define both ends of the list
    Node head, tail;
    int  length;
    
    // Doubly Linked list Node
    class Node {
        int data;
        Node previous;
        Node next;
    
        // Constructor to create a new node
        Node(int data) { 
            this.data = data;
        }
    }
    //Constructor to initialise the head, tail, and length of the list.
    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    boolean isEmpty() {
        return length == 0;
    }

    public void displayList() {
        //Return if list is empty.        
		if(head == null) {
			return;
		}
		Node node = head;
        //Iterate through the list up to the last value and print each node.
		while(node != null) {
			System.out.print(node.data + " ==> ");
			node = node.next;
		}
		System.out.println("null");
	}

    public void readFirstAndLast() {
        //Do nothing if the list is empty.
        if(head == null) {
			return;
		}
        //Display the first and last integer whenever the method is called. 
        System.out.println("The first value is " + head.data);
        System.out.println("The last value is " + tail.data);
    }

    //Define methods to add a node to the end or beginning of the list.
    public void addFirst(int element) {

        Node newNode = new Node(element);
        //If the list is empty set the tail to the new node. Otherwise, the node preceding the head
        // is set to the new node. The node following the new node is set to the head. 
        if(isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void addLast( int element) {
        Node newNode = new Node(element);
        //If the list is empty set the head to the new node. Otherwise set the next value to the tail 
        // to the new node and the previous value to the new node to be the new tail
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    void deleteNode(Node element) {
        //Return if the node doesn't exist or if the list is empty.
        if (head == null || element  == null) {
            return;
        }

        //If the node to be deleted is the head/tail, change it's pointer to the next/previous head respectively.
        if (head == element) {
            head = element.next;
        } else if (tail == element) {
            tail = tail.previous;
        }

        //If the previous node to the target exists, set the next of the previous to the target to
        // the previous node. 
        if (element.next != null) {
            element.next.previous = element.previous;
        }
        if (element.previous != null) {
            element.previous.next = element.next;
        }
        //Decrease the length by 1 if a node was deleted successfully 
        length--;
        return;
    }

    //tests
    public static void main(String[] args) {
        DoublyLinkedList LinkedList = new DoublyLinkedList();
        LinkedList.addFirst(1);
        LinkedList.addFirst(2);
        LinkedList.addLast(3);
        LinkedList.addLast(4);
        LinkedList.addLast(5);
        LinkedList.readFirstAndLast();
        LinkedList.displayList();
        LinkedList.deleteNode(LinkedList.tail.previous);
        LinkedList.displayList();
        LinkedList.deleteNode(LinkedList.head);
        LinkedList.readFirstAndLast();
    }
}

