import java.util.Arrays;
import java.util.Random;

public class Main {
    public int minElement(int [] Array )
    {
        int min =Array[0];
        for(int num :Array)
        {
            if (num < min)
                min = num;
        }
        return min;
    }

    public int maxElement(int [] Array )
    {
        int max =Array[0];
        for(int num :Array)
        {
            if (num > max)
                max = num;
        }
        return max;
    }

    public int searchTime (int [] Array,int num) {
        int FindIndex = -1;
        int first = 0;
        int last = Array.length-1;
        long startTime = System.nanoTime();

        Arrays.sort(Array);

        for(int singleNum : Array)
        {
            System.out.print(singleNum);
            System.out.print(" ");
        }
        while (first < last) {
            int mid = (first + last) / 2;
            if (Array[mid] == num) {
                FindIndex=mid;
                break;
            }
            else if (Array[mid] < num) {
                first = mid + 1;
            }
            else {
                last = mid;
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.printf("\nStart Time : %d \n" , startTime);
        System.out.printf("End Time   : %d \n" , endTime);
        System.out.printf("Total Time with nano second  : %d \n" , totalTime);
        System.out.printf("Total Time with  second      : %f \n" , (totalTime*Math.pow(10,-9)));
        return FindIndex;
    }

    public static void main(String[] args) {

        int SearchNum = Integer.parseInt(args[0]);          //why do not accept (int) args[0]

        Main module = new Main();
        Random rand = new Random();
        int [] List =new int[1000];
        for (int i = 0; i < List.length; i++) {
            List[i]= rand.nextInt(-500,500);
        }

        int FindFlag =module.searchTime(List,SearchNum);

        if (FindFlag==-1)
            System.out.println("Dont Found ! ");
        else
            System.out.printf("Find Number %d at index %d \n",SearchNum,FindFlag);

        System.out.printf("MAXIMam Num in array = %d \n",module.maxElement(List));
        System.out.printf("MInIMam Num in array = %d \n",module.minElement(List));
    }
}