package laps;

public class Laps {

	public static void main(String args[]){
		
		long start_app=System.currentTimeMillis();
	    	int [] numbers = new int[1000];
		int max=0, min=0;
 	 	for(int i= 0; i < 1000; i++)
        		numbers[i] =(int) (Math.random()*(100+1));
		sort(numbers);
		System.out.println("Minimum = " + numbers[0]);
		System.out.println("Maximum = " + numbers[999]);
		long end_app = System.currentTimeMillis();
		System.out.println("running time is " + (end_app-start_app) + " milli second");
	}
	static void sort(int arr[])
    	{
        	for (int i = 0; i < arr.length-1; i++)
        	{
            		int min_idx = i;
            		for (int j = i+1; j < arr.length; j++)
                		if (arr[j] < arr[min_idx])
                    			min_idx = j;

            		int temp = arr[min_idx];
            		arr[min_idx] = arr[i];
            		arr[i] = temp;
        	}
    	}
}
