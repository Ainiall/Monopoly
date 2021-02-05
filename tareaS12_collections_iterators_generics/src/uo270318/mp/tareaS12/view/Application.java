package uo270318.mp.tareaS12.view;

import java.util.Iterator;

import uo270318.mp.tareaS12.collections_iterators.generics.model.ArrayList;
import uo270318.mp.tareaS12.collections_iterators.generics.model.List;

public class Application {

    public static void main(String[] args) {
	Application.run();
    }

    private static void run() {
	List<String> myList = new ArrayList<String>();
	myList.add("1");
	myList.add("2");
	myList.add("3");
	Iterator<String> i = myList.iterator();
	while(i.hasNext()) {
	    if(i.next().equals("1")) {
		i.remove();
	    }
	}
	System.out.println(myList);
    }
}
