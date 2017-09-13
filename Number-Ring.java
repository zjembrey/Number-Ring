import java.util.ArrayList;
import java.util.Collections;

public class Number_Ring {

	Node first;
	Node last;

	public Number_Ring()
	{
		first = null;
		last = null;
	}
	

	public void Insert(int newnum)
	{
		Node newnode = new Node(newnum);
		
		if(isEmpty())
		{
			last = newnode;
			first = newnode;
		}
		
		newnode.next = first;
		first.previous = newnode;
		
		
		
		first = newnode;
		first.previous = last;
		
		last.next = first;
		
		
		
	}
	
	public void Append(int newnum)
	{
		Node newnode = new Node(newnum);
		int c = 0;
		if(isEmpty())
		{
			last = newnode;
			first= newnode;
			first.next = last;
			first.previous = last;
			last.next = first;
			last.previous = first;
			c = 1;
		}
		else if(c ==1)
		{
		c = 2;
		newnode.previous = first;
		newnode.next = first.next;
		first.next = newnode;
		
		 last = first;
		first = newnode;
		last.previous = first;
		
		}
		else
		{
			newnode.previous = first;
			newnode.next = first.next;
			first.next = newnode;
			last.previous = newnode;
			 last = first;
			first = newnode;
			
		}	
	}
	
	public void Delete()
	{
		if(first == last)
		{
			first = null;
			last = null;
		}
		else
		{
		last.next = first.next;
		first = first.next;
		first.previous = last;
		}
		
	}
	
	public void Jump(int counter)
	{
		if(counter >= 0)
		{
			
			for(int x = 0;x <= counter-1 ; x++)
			{
				first = first.next;
				last = last.next;
				
			}
			
		}
		else
		{
			for(int x = counter; x < 0 ; x++)
			{
				
				first = first.previous;
				last = last.previous;
				
			}
		
		}
		
	}
	
	public void Print()
	{
		
		Node current = first;
		for(Node n = first; n.next != first; n = n.next)
		{
			System.out.print(n.data + " ");
		}
		
		System.out.println(last.data);
	}
	
	public void Sort()
	{
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int amount = 1;
		Node current = first;
		for(Node n = first; n.next != first; n = n.next)
		{
			amount++;
		}
		
		int temp = first.data;
		
		for(int x = 0; x <= amount-1; x++)
		{
			if(first != null)
			{
			numbers.add(first.data);
			}
			
			this.Delete();
			
		}
		
		Collections.sort(numbers);
		Node find = null;
		for(int x = 0; x <= amount-1; x++)
		{
			this.Insert(numbers.get(x));
			
			if(numbers.get(x) == temp)
			{
				find = first;
			}
		}
		
		System.out.println("test line " + find.data);
		first = find;
		last = first.previous;
	}
	
	
	public boolean isEmpty()
	{
		return (first == null);
	}
	
}
