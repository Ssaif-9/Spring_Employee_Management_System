package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TryMe {

	//constructor use reference method
	TryMe(){
		
	}
	TryMe(String s){
		System.out.println(s);
	}
	
	// static function to be called 
     
   
     static void  myFunction(String s) {
    	 System.out.print(s + "\t"); 
     }
      void  printWithEllipsis(String...setOfStrings) {
    	    for (String s : setOfStrings)
    	        System.out.println(s+"\t");
    	}
	public static void main(String[] args) {
		// Get the stream
		Stream<String> stream = Stream.of("Geeks", "For", "Geeks", "A", "Computer", "Portal");

		// Print the stream
		//stream.forEach(s -> System.out.println(s));
		// using reference methods
		//stream.forEach(System.out::println);
		
		 List<String> list = new ArrayList<String>(); 
	        list.add("Geeks"); 
	        list.add("For"); 
	        list.add("GEEKS"); 
	  
	        // call the static method 
	        // using double colon operator 
			TryMe m = new TryMe();
	       // list.forEach(m::someFunction); 
	        stream.forEach(TryMe::new);
	       
	        m.printWithEllipsis(); // prints nothing
	        m.printWithEllipsis("first"); // prints "first"
	        m.printWithEllipsis("first", "second"); // prints "first\nsecond"

	}
	
}
