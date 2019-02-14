//The program uses Student class
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentGrading {

	//declare the Student array
	private static Student[] students = new Student[5];


	public static void main(String args[]) {
		
		try {
			read();
		} catch (Exception e) {
			System.err.println("Error while reding input file");
			System.exit(1);
		}
		
		
		//print the array with file data
		printarray(students);

//		//populate the array with last value
//		for( student = 0, task = 3; student < 5; student++) 
//		{
//			System.out.print("\nPlease enter assessment mark for task 4 student: " + (student + 1) + ": ");
//			students[student][task] = in.nextDouble();
//
//			while (students[student][task] < 0 || students[student][task] > 40)	
//			{															
//				System.out.print("\nPlease do not enter a mark that is lower than 0 or greater than 40 : " );
//				students[student][task] = in.nextDouble();	
//			}
//		}


		//print the array with current data
		printarray(students);
		//print the array with current data
		System.out.println("\nThe New Array is: ");
		printarray(students);

		//average function
//		averagearray(students);

		//writing to an output file
//		writearray(students);

	}


	public static void read() throws Exception{
		double data = 0, min = 1, max = 40;
		Scanner in = new Scanner(System.in);
		//open input file
		Scanner inFile = new Scanner(new File("input.txt"));

		//populate the 2d array from file data
		for(int i = 0; i < 5; i++) {
			students[i] = new Student();
			students[i].setId(i+1);
			students[i].setMarkTask1(inFile.nextDouble());
			students[i].setMarkTask2(inFile.nextDouble());
			students[i].setMarkTask3(inFile.nextDouble());
		}
		
	}

//	//function for calculating the average
//	public static void averagearray(double[][] arr){
//		double taskTotal, studentTotal;
//		System.out.print("\n\n===Total Average===");
//		System.out.print("\n\nTotal ---> Average");
//		for(int student = 0; student < arr.length; student++){
//			studentTotal = 0;
//			for(int task = 0; task < arr[student].length; task++)
//				studentTotal = studentTotal + arr[student][task];
//
//			TotalAverage[student] = studentTotal/5;
//			System.out.format("\n " + (student+1) + " ---> %.2f", + TotalAverage[student]);
//		}
//
//		System.out.print("\n\n===Grade Average===");
//		System.out.print("\n\nTime --> Average");
//		for(int task = 0; task < 4; task++){
//			taskTotal = 0;
//			for(student = 0; student < 5; student++)
//				taskTotal = taskTotal + arr[student][task];
//
//			TotalAverage[task] = taskTotal/4;
//			System.out.format("\n " + (task+1) + " ---> %.2f", + TotalAverage[task]);
//		}
//	}

	//Function for printing array on the screen
	public static void printarray(Student[] arr){
		System.out.println("\n\nThe Populated Array is: ");
		for(int i = 0; i < arr.length; i++){
			System.out.println("Student no." + arr[i].getId() + ": "
					+ arr[i].getMarkTask1() + "\t"
					+ arr[i].getMarkTask2() + "\t"
					+ arr[i].getMarkTask3() + "\t"
					+ arr[i].getMarkTask4() + "\t"
					+ arr[i].getTotalMark() + "\t"
					+ arr[i].getGrade());
		}
	}

//	public static void writearray(double[][] temp) throws Exception{
//		//Open output file
//		FileWriter fw = new FileWriter("assesssmentFEB2019.txt");
//		PrintWriter pw = new PrintWriter(fw);
//
//		//writing in the output file
//		pw.println(" -> STUDENT-ID	TASK1	TASK2	 TASK3	TASK4	TOTAL	GRADE");
//		for(student = 0; student < 5; student++){
//			pw.print(student+1);
//			for(task = 0; task < 4; task++){
//				pw.print("\t");
//				pw.format("%.2f",+temp[student][task]);
//				pw.flush();
//			}
//
//			pw.println();
//			pw.print("\nAVG: ");
//			for(task = 0; task < 4; task++){
//				pw.print("\t");
//				pw.format("%.2f",+TotalAverage[task]);
//			}
//
//			System.out.println("\n\nThe Average has been in the output file 'assessment.txt'");
//
//			//closing output file
//			pw.close();
//		}
//	}
}