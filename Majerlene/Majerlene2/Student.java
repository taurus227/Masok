//Student Class

public class Student {
	
	private int id;
	private double markTask1;
	private double markTask2;
	private double markTask3;
	private double markTask4;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMarkTask1() {
		return markTask1;
	}
	
	public void setMarkTask1(double markTask1) {
		this.markTask1 = markTask1;
	}

	public double getMarkTask2() {
		return markTask2;
	}
	
	public void setMarkTask2(double markTask2) {
		this.markTask2 = markTask2;
	}

	public double getMarkTask3() {
		return markTask3;
	}
	
	public void setMarkTask3(double markTask3) {
		this.markTask3 = markTask3;
	}

	public double getMarkTask4() {
		return markTask4;
	}
	
	public void setMarkTask4(double markTask4) {
		this.markTask4 = markTask4;
	}

	public double getTotalMark() {
		return markTask1 + markTask2 + markTask3 + markTask4;
	}
	
	public String getGrade() {
		double totalMark = getTotalMark();
		if (totalMark >= 80) {
			return "HD - Higher Distinction";
		}
		if (totalMark >= 70) {
			return "D - Distinction";
		}
		if (totalMark >= 60) {
			return "C - Credit";
		}
		if (totalMark >= 50) {
			return "P - Pass";
		}
		return "F - Fail";		
	}		

}