public class SinglyLinkedList {

    private class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int element) {
        Node new_node = new Node(element, null);
        if (tail == null) {
            this.head = new_node;
        } else {
            this.tail.next = new_node;
        }
        this.tail = new_node;
    }

    public void print() {
        Node cur = this.head;

        while (cur != null) {
            System.out.print(cur.data);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }


    //  This function takes as argument an element, and removes the last instance of that element from the list.
    public void remove_last(int element) {

        // checking to see if the list is empty
        if (tail == null) {
            System.out.print("This linked list is empty");
            return;
        }

        Node cur = this.head; // initialize a cur node for reference in loop
        Node temp = this.head; // initialize a temp pointer to the last instance of the element
        Node nextPointer = this.head; // initialize nextPointer to the node before the instance of element

        while (cur.next != null) { // cur node doesn't match element and isn't null

            if (cur.next.data == element) { // if the next node's data matches the value of the element
                temp = cur.next; // temp points to the node that has the matching value
                nextPointer = cur; // nextPointer points to the current node
            }

            cur = cur.next; // keep iterating through nodes

        }

        // if the last node is the last occurrence of the element, move the tail to be the next to last node
        if (temp == tail) {
            this.tail = nextPointer;
        }

        // if the head is the only instance of the element, move the head to be the second node in the list
        if (temp == this.head && this.head.data == element) {
            this.head = temp.next;
        }

        // delete the cur node
        nextPointer.next = temp.next;

    }





    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(8);
        list.add(7);
        list.add(8);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(3);
        list.print(); // 8 7 8 1 9 5 3
        list.remove_last(8);
        list.print(); // 8 7 1 9 5 3
        list.remove_last(3);
        list.print(); // 8 7 1 9 5
        list.remove_last(8);
        list.print(); // 7 1 9 5
        list.remove_last(10);
        list.print(); // 7 1 9 5
    }
}
