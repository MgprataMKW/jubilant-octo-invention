package com.example;

/*
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */

public class TASK2 {
	
	// Data (data stored in the node), prev (reference to the previous node) and next (reference to the next node)
	static class Node {
        Node prev;
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

	// Adding References to the head and tail 
    static class DoublyLinkedList {
        Node head;
        Node tail;

        // Adding a new node to the end of the list. If the list is empty, the new node becomes both the head and the tail
        void addNode(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                newNode.prev = null;
                newNode.next = null;
            } 
            
            // If the list isn't empty, adds the new node after the last node, updating the prev and next references of the new node and the previous node
            else {
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
                tail = newNode;
            }
        }

        // Prints the data of each node starting from the head node. Until the current node is null, indicating the end of the list
        void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        // Removing the middle node
        void removeMiddleNode() {
            if (head == null || head.next == null) {
                return;
            }

            // Using slow as the middle node, the fast advances two positions. When fast is on the end of the list it's known the past is in the middle
            Node slow = head;
            Node fast = head;
            Node prev = null;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            // Updates the references of nodes adjacent to the middle node to remove it from the list. If the middle node is the last node, the tail is updated to point to the node before the middle node
            prev.next = slow.next;
            if (slow.next != null) {
                slow.next.prev = prev;
            } else {
                tail = prev;
            }
        }
    }

    // Main Function
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Adding nodes to list
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        // Printing the list before the removal
        System.out.println("Lista antes da remoção:");
        list.printList();

        // Removing the middle node
        list.removeMiddleNode();

        // Printing the list after the removal
        System.out.println("Lista após a remoção:");
        list.printList();
    }
}