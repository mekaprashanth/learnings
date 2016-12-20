package com.prash.java.sample.datastructure;
public class CustomLinkedList {
	
	private Node head;
	private int size;
	
	public void add(int data)	{
		size++;
		if(head == null)	{
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null)	{
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	public Node get(int index)	{
		checkAndThrowException(index);
		int idx = 0;
		Node current = head;
		while(current.next != null)	{
			if(idx++==index)	{
				break;
			}
			current = current.next;
		}
		return current;
	}
	
	public Node remove(int index)	{
		checkAndThrowException(index);
		Node current = head;
		Node previous = current;
		if(index == 0)	{
			head = head.next;
			size--;
			return current;
		}
		int idx = 1;
		while(current.next != null)	{
			if(idx++ == index)	{
				break;
			}
			previous = current;
			current = current.next;
		}
		previous.next = current.next;
		size--;
		return current;
	}

	private void checkAndThrowException(int index) {
		if(index < 0 || index > size-1)	{
			throw new IndexOutOfBoundsException("index given "+index+" not in range 0-"+(size-1));
		}
	}
	
	public String toString()	{
		StringBuilder sb = new StringBuilder();
		Node current = head;
		if(current == null)	{
			return "Empty List";
		}
		for(int i=0; i<size; i++)	{
			sb.append(current.data);
			sb.append("--");
			current = current.next;
		}
		sb.delete(sb.length()-2, sb.length());
		return sb.toString();
	}
	
	public int size()	{
		return size;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomLinkedList ll = new CustomLinkedList();
		int[] data = new int[]{0,1,2,3,4,5,6,7,8,9};
		for(int i: data)	{
			ll.add(i);
		}
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll);
		ll.remove(2);
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll);
		ll.remove(5);
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll);
		ll.remove(0);
		System.out.println(ll.size());
		System.out.println(ll);
	}
	
	private static class Node	{
		public Node next;
		public int data;
		
		public Node(int data) {
			this.data = data;
		}
	}

}