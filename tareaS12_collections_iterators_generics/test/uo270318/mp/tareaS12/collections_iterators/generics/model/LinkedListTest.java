package uo270318.mp.tareaS12.collections_iterators.generics.model;

public class LinkedListTest<T> extends ListTest<T> {

    @Override
    protected List<T> createList() {
	return new LinkedList<T>();
    }
}
