package core.fi;


import java.util.function.Function;

public class ConvertToFahrenheit {

  	public static void main(String[] args) {
  		
		if(args.length==0 || !isNumeric(args[0])){
			System.out.println(" You Should Enter Centigrade Degree " );
		}
		else{
  			Function<Integer,Double> CentigradeToFahrenheitInt = (c) -> (double)((c*9/5)+32) ;
    			System.out.println("Centigrade to Fahrenheit Is : "+
						CentigradeToFahrenheitInt.apply(Integer.parseInt(args[0])));
		}
  	}

	private static boolean isNumeric(String str) {
       		for (char c : str.toCharArray()) {
            		if (!Character.isDigit(c)) {
                		return false;
            		}
     		}
       		 return true;
   	}
}
