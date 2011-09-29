package snake.model.collections;

import java.util.Arrays;

public abstract class BaseDynamicArray<T> {
	protected T[] elements;
	
	public BaseDynamicArray() {
		super();
	}

	public abstract SnakeIterator iterator();
	protected abstract T createElement();
	
	public void add() {
		elements = Arrays.copyOf(elements, elements.length+1);
		T newEl = createElement();
		elements[elements.length-1] = newEl;
	}

	public final int getSize() {
		return elements.length;
	}
}