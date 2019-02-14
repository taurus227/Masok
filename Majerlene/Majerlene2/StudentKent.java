//The program uses Student class
import java.util.Scanner;

public class StudentKent {
	
	public static void main(String args[]) {
		int studentID, Num;
		double Marks;
		String Name;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Total Number of Students in OODP Class: ");
		Num = in.nextInt();
		
		Student[] OODP = new Student[Num];
		
		for (int i = 0; i < Num ; i++) {
			
			OODP [i] = new Student();
			System.out.println("\nDetails for Student No - " + (i+1));
			
			System.out.print("Enter student ID: ");
			Id = in.nextInt();
			OODP[i].setStudentID(Id);
			
			in.nextLine();
			System.out.print("Enter Student Name: ");
			Name = in.nextLine();
			OODP[i].setStudentName(Name);
			
			System.out.print("Enter Student Marks: ");
			Marks = in.nextDouble();
			OODP[i].setStudentMarks(Marks);
		}
		
		System.out.println("\n\n\tThe Student record \n\n");
		System.out.print("\t STUDENT-ID \tTASK1		\tTASK2		\tTASK3		\tTASK4		\tTOTAL		\tGRADE");
		
		for (int j = 0; j < Num ; j++) {
			
			System.out.println();
			System.out.print("\t" +OODP[j].getStudentID());
			System.out.print("\t" +OODP[j].getStudentName());
			System.out.print("\t" +OODP[j].getTask1());
			System.out.print("\t" +OODP[j].getTask2());
			System.out.print("\t" +OODP[j].getTask3());
			System.out.print("\t" +OODP[j].getTask4());
			System.out.print("		\t" +OODP[j].getStudentMarks());
			System.out.print("\t" +OODP[j].getStudentGrade());
		}
		
		System.exit(0);
	}
}