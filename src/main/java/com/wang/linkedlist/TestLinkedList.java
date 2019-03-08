package com.wang.linkedlist;

import java.util.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
	       // Creating object of class linked list 
        LinkedList<String> list = new LinkedList<String>(); 
  
        // Adding elements to the linked list 
        list.add("A"); 
        list.add("B"); 
        list.add("C"); 
        list.addFirst("D"); 
        // insert E at position of Index 2.
        list.add(2, "E"); 
        list.addLast("F"); 
        list.add("G"); 
        System.out.println("Linked list : " + list); 
  
        // Removing elements from the linked list 
        list.remove("B"); 
        list.remove(3); 
        list.removeFirst(); 
        list.removeLast(); 
        System.out.println("Linked list after deletion: " + list); 
  
        // Finding elements in the linked list 
        boolean status = list.contains("E"); 
  
        if(status) 
            System.out.println("List contains the element 'E' "); 
        else
            System.out.println("List doesn't contain the element 'E'"); 
  
        // Number of elements in the linked list 
        int size = list.size(); 
        System.out.println("Size of linked list = " + size); 
  
        // Get and set elements from linked list 
        Object element = list.get(2); 
        System.out.println("Element returned by get() : " + element); 
        list.set(2, "Y"); 
        System.out.println("Linked list after change : " + list); 	}

}
