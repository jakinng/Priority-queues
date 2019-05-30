import java.util.ArrayList;

public class PQueue 
{
	private ArrayList<Comparable> elements;
	
	public PQueue() 
	{
		elements = new ArrayList<Comparable>();
	}
	
	public void add(Comparable element)
	{
		elements.add(null);
		int index = elements.size() - 1;
		
		while (index > 1 && getParent(index).compareTo(element) > 0)
		{
			elements.set(index, getParent(index));
			index = index / 2; //index set to the index of its parent
		}
	}
	
	
	
	private Comparable getLeftChild(int index) 
	{
		return elements.get(2 * index);
	}
	
	private Comparable getRightChild(int index)
	{
		return elements.get(2 * index + 1);
	}
	
	private Comparable getParent(int index) 
	{
		return elements.get(index / 2);
	}
}
