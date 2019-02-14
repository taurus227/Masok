import java.util.Scanner;
import java.text.DecimalFormat;

public class Main
{
	public static DecimalFormat df2 = new DecimalFormat(".##");
	
	public static void main(String args[])
	{ 
		Scanner in = new Scanner(System.in);
		int d, t;
		
		//declare and populate the 20 array
		double [][] temp = {
								{ 9.5, 18.0, 25.5, 0},
								{ 9.0, 19.0, 20.0, 0},
								{ 5.0, 12.5, 18.0, 0},
								{ 8.5, 16.0, 22.0, 0},
								{ 7.0, 11.0, 25.0, 0},
													
							};	
		// print the array
		printarray(temp);
		
		//populate the array with last value
		for( d = 0, t = 3; d < 5; d++)
		{
			
			System.out.print("\nPlease enter assessment mark for task 4 "+(d+1)+": ");
			temp[d][t] = in.nextDouble();
		}
		
//		while (temp [d][t] is >0 || temp [d][t] is <40 );
//		
//		}
		// print the array
		printarray(temp);
		
		
//		//print the array with current data
//		System.out.println("\nThe New Array is: ");
//		printarray(temp);
//		
		//average function
	    averagearray(temp);
		
		System.exit(0);
}
	
	public static void averagearray(double[][] arr)
	{
//			double tTotal, dTotal, DAverage mark of student, Total Mark of student;
//		int d, t;
//		
//		System.out.print("\n\n===Total Mark of student===");
//		System.out.print("\n\nD --> Average mark of student");
//		for(d = 0; d < 5; d++)
//		{
//			dTotal = 0;
//			for(t = 0 ; t < 3 ; t++)
//				dTotal = dTotal + arr[d][t];
//			
//			DayAverage = dTotal/4;
//			System.out.print("\n "+(d+1)+" --> "+ df2.format(DayAverage));
//		}
	}
	
	public static void printarray(double[][] arr)
	{
		for(int d=0; d<5; d++)
		{
			for(int t=0; t<4; t++)
			{
				System.out.print("\t"+arr[d][t]);
			}
			
			System.out.println();
		}
	}
}

	