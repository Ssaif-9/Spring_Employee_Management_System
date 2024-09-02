package laps;

import java.util.regex.*;

public class StringClass {

	public static void main(String[] args) {
		int counter=0 ; 
		if(args.length==0 || args[1]==null)
			System.out.println("You Don't Enter Any input");
		else
		{
			String target_string ="";
			for(int i=1 ; i<args.length; i++)
			{
    				target_string +=(args[i]+" ");
			}
    		Pattern search_key = Pattern.compile(args[0]);
			Matcher serched_string = search_key.matcher(target_string);
    			while(serched_string.find()) {
      				counter++;
    			}
			System.out.println(counter);
			if(counter==0) 
				System.out.println("Not Found");
		}
  	}
}
