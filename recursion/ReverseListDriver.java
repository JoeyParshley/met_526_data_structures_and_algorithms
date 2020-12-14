package cs526.recursion;

import cs526.recursion.SinglyLinkedList.Node;

/**
 * Describe and implement a recursive algorithm for reversing a singly linked list L, so that the
 * ordering of the nodes becomes opposite of what it was before. What is the running time of your
 * algorithm on a list of n values? Provide both the growth function and BigOh complexity.
 * Create a driver class to test your implementation.
 *
 * PSUEDOCODE
 *
 *      - create a singly linked list
 *      - traverse through the linked list from head to tail
 *      - reverse the link in each step so that each node instead
 *      - of pointing to the next element is pointing to the previous
 *      - element. the whole list will be reversed when you reach
 *      - the last element which then becomes the head of the linked
 *      - list
 *      - the links are reversed in each step using the pointer's
 *      - previous and next methods.
 *
 */
public class ReverseListDriver {
    public static void main(String[] args) {
        // create a singly linked list
        SinglyLinkedList.Node head = new SinglyLinkedList.Node(1);
        SinglyLinkedList linkedList = new SinglyLinkedList(head);

        // Add some nodes into the singly linked list
        linkedList.add(new Node(2));
        linkedList.add(new Node(3));
        linkedList.add(new Node(4));
        linkedList.add(new Node(5));

        // print out the list
        linkedList.print();

        linkedList.reverse();

        linkedList.print();

        linkedList.reverseRecursively();

        linkedList.print();
    }
}
