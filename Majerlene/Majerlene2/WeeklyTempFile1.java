import java.util.Scanner;
import java.io.*;

public class WeeklyTempFile1{

//Global Variables
  public static double[] TotalAverage = new double [5];
  public static double[] GradeAverage = new double [6];
  public static int student, task;

  public static void main(String[] args) throws Exception{
    double data = 0, min = 1, max = 40;
    Scanner in = new Scanner(System.in);
    //open input file
    Scanner Fin = new Scanner(new File("weeklytempinput.txt"));

    //declare the 2d array
    double[][] temp = new double [5][6];

    //populate the 2d array from file data
    for(student = 0; student < 5; student++)
      for(task = 0; task < 3; task++)
        temp[student][task] = Fin.nextDouble();

    //print the array with file data
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
		

    //print the array with current data
    printarray(temp);
	//print the array with current data
		System.out.println("\nThe New Array is: ");
		printarray(temp);

    //average function
    averagearray(temp);

    //writing to an output file
    writearray(temp);

    System.exit(0);
  }

  //function for calculating the average
  public static void averagearray(double[][] arr){
    double taskTotal, studentTotal;
    System.out.print("\n\n===Total Average===");
    System.out.print("\n\nTotal ---> Average");
    for(student = 0; student < arr.length; student++){
      studentTotal = 0;
      for(task = 0; task < arr[student].length; task++)
        studentTotal = studentTotal + arr[student][task];

      TotalAverage[student] = studentTotal/5;
      System.out.format("\n " + (student+1) + " ---> %.2f", + TotalAverage[student]);
    }

    System.out.print("\n\n===Grade Average===");
    System.out.print("\n\nTime --> Average");
    for(task = 0; task < 4; task++){
      taskTotal = 0;
      for(student = 0; student < 5; student++)
        taskTotal = taskTotal + arr[student][task];

        TotalAverage[task] = taskTotal/4;
        System.out.format("\n " + (task+1) + " ---> %.2f", + TotalAverage[task]);
    }
  }

  //Function for printing array on the screen
  public static void printarray(double[][] arr){
    System.out.println("\n\nThe Populated Array is: ");
    for(student = 0; student < arr.length; student++){
      for(task = 0; task < arr[student].length; task++){
        System.out.print("\t" + arr[student][task]);
      }

      System.out.println();
    }
  }

  public static void writearray(double[][] temp) throws Exception{
    //Open output file
    FileWriter fw = new FileWriter("assesssmentFEB2019.txt");
    PrintWriter pw = new PrintWriter(fw);

    //writing in the output file
    pw.println(" -> STUDENT-ID	TASK1	TASK2	 TASK3	TASK4	TOTAL	GRADE");
    for(student = 0; student < 5; student++){
      pw.print(student+1);
      for(task = 0; task < 4; task++){
        pw.print("\t");
        pw.format("%.2f",+temp[student][task]);
        pw.flush();
      }

      pw.println();
      pw.print("\nAVG: ");
      for(task = 0; task < 4; task++){
        pw.print("\t");
        pw.format("%.2f",+TotalAverage[task]);
      }

      System.out.println("\n\nThe Average has been in the output file 'assessment.txt'");

      //closing output file
      pw.close();
    }
  }
}
