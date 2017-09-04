package jav.classproperties;

import java.io.Serializable;
import java.util.HashMap;
/*Please explore more
 * Canonical Name	--> 	$ is not added that's why used for logging
 * 							Returns null for anonymous class
 * 							Unique
 * Name 			-->		$ is added
 * 							Returns value for anonymous class
 * 							Not guaranteed to be unique		
 * Simple Name 		--> 	Returns simple Classname that you'd use to dynamically load the class with, for example, a call to Class.forName with the default ClassLoader.
 * 
 */
class SimpleNameVSCanonNameVSName {
	public static void main(String[] args) {
		//primitive
		System.out.println(int.class.getName());
		System.out.println(int.class.getCanonicalName());
		System.out.println(int.class.getSimpleName());

		System.out.println();

		//class
		System.out.println(String.class.getName());
		System.out.println(String.class.getCanonicalName());
		System.out.println(String.class.getSimpleName());

		System.out.println();

		//inner class
		System.out.println(HashMap.SimpleEntry.class.getName());
		System.out.println(HashMap.SimpleEntry.class.getCanonicalName());
		System.out.println(HashMap.SimpleEntry.class.getSimpleName());        

		System.out.println();

		//anonymous inner class
		System.out.println(new Serializable(){private static final long serialVersionUID = 1L;}.getClass().getName());
		System.out.println(new Serializable(){private static final long serialVersionUID = 1L;}.getClass().getCanonicalName());
		System.out.println(new Serializable(){private static final long serialVersionUID = 1L;}.getClass().getSimpleName());
	}
}
