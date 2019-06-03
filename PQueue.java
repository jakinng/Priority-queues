
import java.util.ArrayList;
import java.util.Arrays;

public class PQueue 
{
	private ArrayList<Comparable> elements;
	
	public PQueue() 
	{
		elements = new ArrayList<Comparable>();
	}
	
	public static void main(String[] args) 
	{
		Integer[] ints = new Integer[] {
				5, 12, 12, 36, 56, 40, 21, 88, 75, 75, 62, 79, 100, 92, 87
		};
		PQueue pq = new PQueue();
		for (Integer i : ints)
		{
			pq.add(i);
		}
//		
//		System.out.println(pq.remove());
//		System.out.println(pq);
//		System.out.println(pq.remove());
//		System.out.println(pq);		
//		System.out.println(pq.remove());
//		System.out.println(pq);
//		System.out.println(pq.remove());
//		System.out.println(pq);
	}
	
	public void add(Comparable element)
	{
		elements.add(element);
		int index = elements.size() - 1;
		
		int parent = (index - 1) / 2;
		while (index > 0 && 
				element.compareTo(elements.get(parent)) < 0)
		{
			elements.set(index, elements.get(parent));
			index = parent;
			parent = (index - 1) / 2;
		}
		
		elements.set(index, element);
	}

	public Comparable remove()
	{
		Comparable smallest = elements.get(0);
		Comparable last = elements.remove(elements.size() - 1);
		elements.set(0, last);
		
		int index = 0;
		int child = smallestChild(index);
		
		while (child < elements.size() && 
				last.compareTo(elements.get(child)) > 0)
		{
			elements.set(index, elements.get(child));
			index = child;
			child = smallestChild(index);
		}
		
		elements.set(index, last);
		return smallest;
	}
	
	private int smallestChild(int index)
	{
		int child = index * 2 + 1;
		if (child + 1 < elements.size() && 
				elements.get(child).compareTo(elements.get(child + 1)) > 0)
			child = child + 1;
		return child;
	}
	
	public Comparable peek()
	{
		return elements.get(0);
	}

	public String toString()
	{
		return elements.toString();
	}
}