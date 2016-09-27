////////////////////////////////////////////////////////////////////////////////
//  Course:   CSC 249 Fall 2016
//  Section:  (your section number) 
// 
//  Project:  Project1
//  File:     MyStack
//  
//  Name:     (your first and last name)
//  Email:    (your Wake Tech Email Address)
////////////////////////////////////////////////////////////////////////////////

public class MyStack<E extends Comparable<E>> implements Comparable<MyStack<E>>
{
	private MyArrayList<E> list = new MyArrayList<E>();

	// Use this to find top of stack and to compare Stacks
	public int getSize()
	{
		return list.size();
	}

	// Look at top of stack, without removing it
	public E peek()
	{
		return list.get (getSize() - 1);
	}

	// Place a new element on the stack
	public void push (E e)
	{
		list.add (e);
	}

	// Remove the top element from the stack
	public E pop()
	{
		E e = list.get (getSize() - 1);
		list.remove (getSize() - 1);
		return e;
	}

	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	public int compareTo (MyStack<E> e)
	{
		return (getSize() - e.getSize());
	}

	public MyArrayList<E> getList()
	{
		return list;
	}

	@Override
	public String toString()
	{
		return "Stack: " + list.toString();
	}
}
