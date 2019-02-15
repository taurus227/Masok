//The program uses Student class
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentGrading {

	//declare the Student array
	private static Student[] students = new Student[5];


	public static void main(String args[]) {

		read();

		//print the array with file data
		printarray(students);

		populateFinalExam();

		//print the array with current data
		printarray(students);

		//writing to an output file
		writearray(students);

	}

	public static void read() {
		try {
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
			inFile.close();
		} catch (Exception e) {
			System.err.println("Error while reading input.txt file: " + e.getMessage());
			System.exit(1);
		}
	}

	public static void populateFinalExam() {
		double data = 0;
		Scanner in = new Scanner(System.in);
		//populate the array with last value
		for(int student = 0; student < 5; student++) 
		{
			System.out.print("\nPlease enter assessment mark for task 4 student: " + (student + 1) + ": ");
			data = in.nextDouble();

			while (data < 0 || data > 40)	
			{															
				System.out.print("\nPlease do not enter a mark that is lower than 0 or greater than 40 : " );
				data = in.nextDouble();	
			}
			students[student].setMarkTask4(data);
		}
		in.close();
	}

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

	public static void writearray(Student[] arr) {
		try {
			//Open output file
			FileWriter fw = new FileWriter("output.txt");
			PrintWriter pw = new PrintWriter(fw);

			//writing in the output file
			pw.println(" -> STUDENT-ID	TASK1	TASK2	 TASK3	TASK4	TOTAL	GRADE");
			for(int student = 0; student < 5; student++){
				pw.print(arr[student].getId());
				pw.print("\t");
				pw.format("%.2f", arr[student].getMarkTask1());
				pw.print("\t");
				pw.format("%.2f", arr[student].getMarkTask2());
				pw.print("\t");
				pw.format("%.2f", arr[student].getMarkTask3());
				pw.print("\t");
				pw.format("%.2f", arr[student].getMarkTask4());
				pw.print("\t");
				pw.format("%.2f", arr[student].getTotalMark());
				pw.print("\t" + arr[student].getGrade());
				pw.println();
				pw.flush();
			}
			System.out.println("\n\nThe results have been written to the output.txt file ");

			//closing output file
			pw.close();
		} catch (Exception e) {
			System.err.println("Error while writing output.txt file: " + e.getMessage());
			System.exit(1);
		}
	}
}