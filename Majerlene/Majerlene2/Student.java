//Student Class

public class Student {
	
	private int StudentID;
	private String StudentName;
	private double StudentMarks;
	private String StudentGrade;
	private int Task1;
	private int Task2;
	private int Task3;
	private int Task4;
	
	
	
	public void setStudentID(int studentID) {
		StudentID = studentID;
		return;
	}
	
	public void getTask1(int Task1) {
		Task1 = Task1;
		return;
	}
	
	public void setStudentName(String Name) {
		StudentName = Name;
		return;
	}
	
	public void setStudentMarks(double Marks) {
		StudentMarks = Marks;
		setStudentGrade();
		return;
	}
	
	public int getStudentID() {
		return StudentID;
	}
	
	public int getTask1() {
		return Task1;
	}
	
	public int getTask2() {
		return Task2;
	}
	
	public int getTask3() {
		return Task3;
	}
	
	public int getTask4() {
		return Task4;
	}
	
	public String getStudentName() {
		return StudentName;
	}
	
	public double getStudentMarks(){
		return StudentMarks;
	}
	
	public String getStudentGrade() {
		return StudentGrade;
	}
	
	private void setStudentGrade() {
		if ((StudentMarks >=80) && (StudentMarks <= 100))
					StudentGrade = "HD - Higher Distinction";
		else if ((StudentMarks >= 70) && (StudentMarks <= 79))
					StudentGrade = "D - Distinction";
		else if ((StudentMarks >= 60) && (StudentMarks <= 69))	
					StudentGrade = "C - Credit";
		else if ((StudentMarks >= 50) && (StudentMarks <= 59))	
					StudentGrade = "P - Pass";
		else if ((StudentMarks >= 0) && (StudentMarks <= 49))	
					StudentGrade = "F - Fail";		
	}		
	
}