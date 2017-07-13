package com.datastructure.example;



public class MyLinkList<T> {
	
	private static int counter;
	private Node head;
	
	public void append(T data){
		if (head == null) {
			this.head = new Node(data);
		}else{
			Node current = head;
			while(current.next!=null){
				current = current.next;
			}
			current.next = new Node(data);
		}
		counter++;
	}
	
	public void printList(){
		Node tmpNode = head;
        while (tmpNode!= null) {
            System.out.print(tmpNode.data + " -> ");
            tmpNode = tmpNode.next;
        }       
	}
	
	public void delete(T data) {
        Node prevNode = null;
        Node currNode = head;

        if (head.data == data) {
            head = head.next;
            return;
        }

        while (currNode != null && currNode.data != data) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("A node with that value does not exist.");
        }
        else {
            prevNode.next = currNode.next;
        }
        counter--;
    }
	
	public int size(){
		return counter;
	}
	
	public static void main(String[] args) {
		MyLinkList list = new MyLinkList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.delete(3);
		list.printList();
		
		System.out.println(list.size());
		
	}

}

class Node <T> {
	T data;
	Node next;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node(T data) {
		this.data = data;
		next = null;		
	}
	
}