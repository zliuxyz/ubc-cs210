package ca.ubc.cs.cpsc210.integerset.util;

import java.util.LinkedList;
import java.util.List;

// An implementation of IntegerSet using List
public class LinkedListIntegerSet implements IntegerSet {

    // Store the actual values of the IntegerSet in a List
    private List<Integer> data;

    // Constructor
    // EFFECTS: set is empty
    public LinkedListIntegerSet() {
        data = new LinkedList<Integer>();
    }

    public void insert(Integer i) {
        if (!contains(i))
            data.add(i);
    }

    public void remove(Integer i) {
        data.remove(i);
    }

    public boolean contains(Integer i) {
        return data.contains(i);
    }

    public int size() {
        return data.size();
    }

	public IntegerSet intersection(IntegerSet other) {
		IntegerSet intersection = new LinkedListIntegerSet();
		
		for (Integer i : data) {
			if (other.contains(i))
				intersection.insert(i);
		}
		
		return intersection;
	}
}
