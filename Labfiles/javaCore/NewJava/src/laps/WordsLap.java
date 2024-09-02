package laps;

import java.util.StringTokenizer;

public class WordsLap {

	public static void main(String[] args) {
		if(args.length==0)
			System.out.println("You Don't Enter Any input");
		else
		{
			String target_string=args[1];
			if(count(target_string,args[0])!=0)
				System.out.println("Found " + count(target_string,args[0]));
			else
				System.out.println("Not Found");
				
		}
  	}
	static int count(String str, String destination)
	{
		int count = 0;
		StringTokenizer split_string = new StringTokenizer(str,".");
    		while (split_string.hasMoreTokens()) {
			if(split_string.nextToken().equals(destination))
				count++;
     		}
		return count;
	}
}