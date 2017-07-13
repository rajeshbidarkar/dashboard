package com.collection.example;

public class MyLinkList<T> {
	Node head = null;
	static int count = 0;
	
	public void appendNode(T data){
		if(head==null){
			head = new Node(data);
		}else{
			Node n = head;
			while(n.next!=null){
				n = (Node) n.next;
			}
			head.next = new Node(data);			
		}
	}
	
	public void printList(){
		Node tmpNode = head;
        while (tmpNode!= null) {
            System.out.print(tmpNode.data + " -> ");
            tmpNode = (Node) tmpNode.next;
        }       
	}
	
	public static void main(String[] args) {
		MyLinkList<String> lt = new MyLinkList<String>();
		lt.appendNode("hello");
		lt.appendNode("world");
		
		lt.printList();
		
		int a[] = {31,33,35};
		int b[] = {32,34,36,37};
		int c [] = new int[a.length+b.length];
		int count =0,j=0;
		
		for(int i=0;i<c.length;i++){
			if(i<a.length) {				
				c [count] = a[i];				
			}
			else {
				c [count] = b[j];					
				j++;				
			}
			count++;
		}
		
		for(int i=0;i<c.length;i++){
			System.out.println(" "+c[i]);
		}
		
	}

}
class Node <T> {
	T data;
	T next;
	
	public Node(T data) {
		
		this.data = data;
	}
	
	
}
