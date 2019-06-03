
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a priority queue using a heap implementation
 * @author Jakin Ng
 * @version June 2, 2019
 */
public class PQueue 
{
	//represents the heap
	private ArrayList<Comparable> elements;
	
	/**
	 * Constructor for a priority queue
	 */
	public PQueue() 
	{
		elements = new ArrayList<Comparable>();
	}
	
	/**
	 * Testing the class
	 * @param args
	 */
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
	
	/**
	 * Adds element to the queue elements
	 * maintains a heap
	 * @param element The element to be added
	 */
	public void add(Comparable element)
	{
		elements.add(element); //adds the element 
		int index = elements.size() - 1; //index of element
		
		int parent = (index - 1) / 2; //index of parent
		//while the element is smaller than its parent, bubbles up
		while (index > 0 && 
				element.compareTo(elements.get(parent)) < 0)
		{
			//resets the index to its parent 
			elements.set(index, elements.get(parent));
			//new index and parent
			index = parent;
			parent = (index - 1) / 2;
		}
		
		//sets the final index to the element
		elements.set(index, element);
	}

	/**
	 * Removes and returns the highest priority element
	 * @return The highest priority element
	 */
	public Comparable remove()
	{
		//smallest set to first node, last set to the last element
		Comparable smallest = elements.get(0); 
		Comparable last = elements.remove(elements.size() - 1);
		//last element moved to beginning
		elements.set(0, last);
		
		//the last element is at index 0
		int index = 0;
		int child = smallestChild(index);
		
		//bubble down to maintain heap property
		while (child < elements.size() && 
				last.compareTo(elements.get(child)) > 0)
		{
			elements.set(index, elements.get(child));
			index = child;
			child = smallestChild(index);
		}
		
		//set the correct index to the last element
		elements.set(index, last);
		return smallest;
	}
	
	/**
	 * Returns the highest priority element
	 * @return The highest priority element
	 */
	public Comparable peek()
	{
		return elements.get(0); //first node
	}
	
	/**
	 * Returns the index of the smaller child 
	 * of the node at index
	 * @param index The index in consideration
	 * @return The index of the smaller child 
	 */
	private int smallestChild(int index)
	{
		int child = index * 2 + 1; //sets child to left child
		if (child + 1 < elements.size() && //if it is within bounds
				//and if the left child is larger than the right child
				elements.get(child).compareTo(elements.get(child + 1)) > 0)
			child = child + 1; //smaller child is set to the right child
		return child; 
	}

	/**
	 * Converts the priority queue to its String form
	 * Allows easier testing
	 */
	public String toString()
	{
		return elements.toString();
	}
}