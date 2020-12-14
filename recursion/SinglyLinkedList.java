package cs526.recursion;
public class SinglyLinkedList {
    static class Node {
        private int data;
        protected Node next;

        public Node(int data){
            this.data = data;
        }

        public int data() {
            return data;
        }

        public Node next() {
            return next;
        }
    }

    private Node head;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    /**
     * Add an element to linked list
     */
    public void add(Node node) {
        Node current = head;
        while (current != null) {
            if (current.next == null){
                current.next = node;
                break;
            }
            current = current.next;
        }
    }

    /**
     * print a singly linked list
     */
    public void print() {
        Node node = head;
        while (node != null){
            System.out.print(node.data() + " -> ");
            node = node.next;
        }
        System.out.println("");
    }

    /** reverse the list without recursion
     *
     *      -   create a Node type pointer set to the head
     *      -   creeate previous and current pointers set to null
     *      -   use a while loop to loop over the list until the
     *      -   pointer is referencing (pointing to) null
     *      -   These pointers point to the next and previous
     *      -   nodes in the list
     *      -   at each node set current to pointer
     *      -   then set pointer to pointers `next` Node (pointer.next)
     *      -   now reverse the links
     *          -   set current.next to now point to the previous Node
     *          -   set the previous Node to be current
     *          -   set head to current
     *
     * */

    public void reverse() {
        Node pointer = head;
        Node previous = null, current = null;

        while (pointer != null) {
            current = pointer;
            pointer = pointer.next;

            // reverse the link
            current.next = previous;
            previous = current;
            head = current;
        }
    }

    /**
     * Recursivly reverse the order of a linked list
     * In recusion Stack is uised to store data.
     *  -   Traverse linked list until we find the tail
     *  -   that would be the new head
     */
    public Node reverseRecursive(Node node) {
        Node headOfReversedList;

        /**
         * base case is when we get the tail of the original linked list
         *  i.e. when the next pointer of the node is null
         *  when that happens return the node.
         */

        if (node.next == null){
            return node;
        }
        // recursively call the reverse method next node
        headOfReversedList = reverseRecursive(node.next);

        // reverse the link (i.e. the next node's next node is this node)
        node.next.next = node;
        node.next = null;
        return headOfReversedList;
    }

    // helper method to call the recursive method on the original head
    public void reverseRecursively(){
        head = reverseRecursive(head);
    }
}
