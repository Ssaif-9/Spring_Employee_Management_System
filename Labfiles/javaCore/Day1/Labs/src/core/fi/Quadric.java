package core.fi;

import java.util.function.Function;

public class Quadric {

	public static void main(String[] args){
		Data d = new Data(1,3,-4);
		Function<Data, Result> func = (data) -> { 
					Result result = new Result();
					result.Root1 =  (-1  *  data.b + Math.sqrt(data.b * data.b - 4 * data.a *data.c)) / 2 * data.a;
					result.Root2 =  (-1  * data.b - Math.sqrt(data.b * data.b - 4 * data.a *data.c)) / 2 * data.a;
					return result;
					 };
      		Result R = func.apply(d);
		System.out.println("The Value Of Root1 Is : " + R.Root1);
		System.out.println("The Value Of Root2 Is : " + R.Root2);
	}
}


class Result{
	
	double Root1;
	double Root2;
}
class Data{
	
	double a;
	double b;
	double c;
	Data(double a, double b , double c)
	{
		this.a=a;
		this.b=b;
		this.c=c;
	}
}
