////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249
//  Section:  (your section number) 
// 
//  Project:  Project1
//  File:     MyLinkedList
//
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

public class MyLinkedList<E extends Comparable<E>> extends MyAbstractList<E>
		implements Comparable<MyLinkedList<E>>              
{
	private Node<E> head, tail;		// head and tail pointers

	// Create a default list

	public MyLinkedList()
	{
	}

	// Need this for implementing Comparable
	public int compareTo (MyLinkedList<E> e)
	{
		return (size() - e.size());
	}

	// Create a list from an array of objects

	public MyLinkedList (E[] objects)
	{
		super(objects);		// Passes the array up to abstract parent
	}

	// Return the head element in the list

	public E getFirst()
	{
		if (size == 0)
		{
			return null;
		}
		else
		{
			return head.element;
		}
	}

	// Return the last element in the list

	public E getLast()
	{
		if (size == 0)
		{
			return null;
		}

		else
		{
			return tail.element;
		}
	}

	// Add an element to the beginning of the list

	public void addFirst (E e)
	{
		// Create a new node for element e

		Node<E> newNode = new Node<E>(e);

		newNode.next = head;	 // link the new node with the head
		head = newNode;			 // head points to the new node
		size++;					 // Increase list size
		if (tail == null)		  // new node is only node
		{
			tail = head;
		}
	}

	// Add an element to the end of the list

	public void addLast (E e)
	{
		// Create a new node for element e

		Node<E> newNode = new Node<E>(e);
		if (tail == null)
		{
			head = tail = newNode; // new node is only node
		}
		else
		{
			tail.next = newNode; // Link the new with the last node
			tail = tail.next;	 // tail now points to the last node
		}
		size++;	   // Increase size
	}

	// Remove the head node and
	// return the object from the removed node

	public E removeFirst()
	{
		if (size == 0)
		{
			return null;
		}
		else
		{
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null)
			{
				tail = null;
			}
			return temp.element;
		}
	}

	// Remove the last node and return the object from it

	public E removeLast()
	{
		if (size == 0)
		{
			return null;
		}

		else if (size == 1)
		{
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else
		{
			Node<E> current = head;
			for (int i = 0; i < size - 2; i++)
			{
				current = current.next;
			}
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	// Remove the element at the specified position
	// Return the element that was removed from the list.

	@Override
	public E remove (int index)
	{
		if (index < 0 || index >= size)
		{
			return null;
		}

		else if (index == 0)
		{
			return removeFirst();
		}

		else if (index == size - 1)
		{
			return removeLast();
		}

		else
		{
			Node<E> previous = head;
			for (int i = 1; i < index; i++)
			{
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}
	}

	// Return a String representation of the linked list elements

	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;
		for (int i = 0; i < size; i++)
		{
			result.append (current.element);
			current = current.next;
			if (current != null)
			{
				result.append (", "); // Separate elements with a comma
			}
			else
			{
				result.append ("]");	   // Insert the ] in the string
			}
		}
		return result.toString();
	}

	// Clear the list

	@Override
	public void clear()
	{
		size = 0;
		head = tail = null;
	}

	@Override

	// Add a new element at specified index in this list

	public void add(int index, E e)
	{
		if (index == 0)
		{
			addFirst (e);
		}
		else if (index == size)
		{
			addLast (e);
		}
		else
		{
			checkIndex (index);

			// Create a new node for element e
			Node<E> newNode = new Node<E>(e);
			Node<E> previous = head;
			for (int i = 1; i < index; i++)
			{
				previous = previous.next;
			}

			newNode.next = previous.next;
			previous.next = newNode;
			size++;	   // Increase size
		}
	}

	// Return true if this list contains the element e

	@Override
	public boolean contains(E e)
	{
		Node<E> current = head;
		while (current != null)
		{
			if (e.equals(current.element))
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Return the element at the specified index

	@Override
	public E get (int index)
	{
		Node<E> current = head;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		return current.element;
	}

	// Return the index of the first matching element
	// Return -1 if no match

	@Override
	public int indexOf (E e)
	{
		Node<E> current = head;
		for (int i = 0; i < size; i++)
		{
			if (e.equals (current.element))
			{
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	// Return the index of the last matching element
	// Return -1 if no match.

	@Override
	public int lastIndexOf (E e)
	{
		int lastIndex = -1;
		Node<E> current = head;
		for (int i = 0; i < size; i++)
		{
			if (e.equals (current.element))
			{
				lastIndex = i;
			}
			current = current.next;
		}
		return lastIndex;
	}

	// Replace the element at the specified position
	// with the specified element

	@Override
	public E set (int index, E e)
	{
		Node<E> current = head;
		for (int i = 0; i < index; i++)
		{
			current = current.next;
		}
		E old = current.element;
		current.element = e;
		return old;
	}

	// Override iterator() defined in Iterable

	@Override
	public java.util.Iterator<E> iterator()
	{
		return new LinkedListIterator();
	}

	// Throws IndexOutOfBoundsException, if needed

	private void checkIndex (int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException
			("Index: " + index + ", Size: " + size);
		}
	}

	// The Node class

	private static class Node<E> 
	{
		E element;
		Node<E> next;

		public Node (E element)
		{
			this.element = element;
		}
	}

	// Private iterator class for myArrayList class

	private class LinkedListIterator implements java.util.Iterator<E>
	{
		private Node<E> current = head;	   // Current index

		@Override
		public boolean hasNext()
		{
			return(current != null);
		}

		@Override
		public E next()
		{
			E e = current.element;
			current = current.next;
			return e;
		}

		@Override
		public void remove()
		{
			MyLinkedList.this.remove (current.element);
		}
	}
}

