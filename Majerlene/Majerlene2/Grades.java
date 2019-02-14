import java.util.Scanner;
import java.text.DecimalFormat;

public class Grades
{
	public static DecimalFormat df2 = new DecimalFormat(".##");
	
	public static void main(String args[]) //main method
	{
		Scanner in = new Scanner(System.in);
		
		int student, task; //variable
		
		//declare and populate the 2D array
		double [][] temp = {				
								{ 9.5, 18.0, 25.5, 0},
								{ 9.0, 19.0, 20.0, 0},		//temp[1] line , 19.0 temp[1][1]
								{ 5.0, 12.5, 18.0, 0},
								{ 8.5, 16.0, 22.0, 0},
								{ 7.0, 11.0, 25.0, 0},
													
							};	
		// print the array			
		printarray(temp); 	
		
		//populate the array with last value
		for( student = 0, task = 3; student < 5; student++) 
		{
			System.out.print("\nPlease enter assessment mark for task 4 student: " + (student + 1) + ": ");
			temp[student][task] = in.nextDouble();
				
			while (temp[student][task] <0 || temp[student][task] >40)	
			{															
				System.out.print("\nPlease do not enter a mark that is smaller than 0 or bigger to 40 : " );
				temp[student][task] = in.nextDouble();	
			}
		}
		
		// print the array
		printarray(temp);
		//print the array with current data
		System.out.println("\nThe New Array is: ");
		printarray(temp);
		Totalmark(temp);
		//average function
		averagearray(temp);
		
		System.exit(0);
}
	public static void averagearray(double[][] arr)
	{
			double taskTotal, studentTotal, studentAverageMark, taskTotalMarkOfStudent;  //camelcase
		int student, task = 0;
		
		System.out.print("\n\n===Total Mark of student===");
		System.out.print("\n\n --> Average mark for each task");
		for(task = 0; task < 4; task++)
		{ 
			studentTotal = 0;
			for(student = 0 ; student < 5 ; student++)		// ++ Increment operator
   
				studentTotal = studentTotal + arr[student][task];
			
			studentAverageMark = studentTotal / 5;
			System.out.print("\n "+(task+1)+" --> "+ df2.format(studentAverageMark));
		}
	}
	
	public static void Totalmark(double[][] arr)
	{
			double taskTotal, studentTotal, studentAverageMark, taskTotalMarkOfStudent;  //camelcase
		int student, task;
		
		System.out.print("\n\n===Total Mark of student===");
		System.out.print("\n\n --> total marks for each student");
		for(student= 0; student <5 ; student++)
		{ 
			studentTotal = 0;
			for(task = 0 ; task<4 ; task++)
			{
				studentTotal = studentTotal + arr[student][task];
			}
			
			System.out.print("\n "+(student+1)+" --> "+ df2.format(studentTotal));
			
		}
	}
	
	public static void printarray(double[][] arr)		//method
	{
		for(int student =0; student < 5; student++)		//assignment, 
		{
			for(int task =0; task < 4; task++)
			{
				System.out.print("\t"+arr[student][task]);	//tab
			}
			
			System.out.println();
		}
	}
}