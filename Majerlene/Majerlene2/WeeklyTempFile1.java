import java.util.Scanner;
import java.io.*;

public class WeeklyTempFile1{

//Global Variables
  public static double[] DayAverage = new double [7];
  public static double[] TimeAverage = new double [3];
  public static int d, t;

  public static void main(String[] args) throws Exception{
    double data = 0, min = -50.0, max = 60.0;
    Scanner in = new Scanner(System.in);
    //open input file
    Scanner Fin = new Scanner(new File("weeklytempinput.txt"));

    //declare the 2d array
    double[][] temp = new double [7][3];

    //populate the 2d array from file data
    for(d = 0; d < 7; d++)
      for(t = 0; t < 3; t++)
        temp[d][t] = Fin.nextDouble();

    //print the array with file data
    printarray(temp);

    //populate the array with last value
    for(d = 0, t = 2; d < 7; d++){
      System.out.print("\nPlease enter the night temperature for day " + (d+1) +": ");
      data = in.nextDouble();

      while ((data < min) || (data > max)){
        System.out.print("\nInvalid temperature. Valid temperature range ( -50.0 to 60.0) :");
        data = in.nextDouble();
      }

      temp[d][t] = data;
    }

    //print the array with current data
    printarray(temp);

    //average function
    averagearray(temp);

    //writing to an output file
    writearray(temp);

    System.exit(0);
  }

  //function for calculating the average
  public static void averagearray(double[][] arr){
    double tTotal, dTotal;
    System.out.print("\n\n===Daily Average===");
    System.out.print("\n\nDay ---> Average");
    for(d = 0; d < arr.length; d++){
      dTotal = 0;
      for(t = 0; t < arr[d].length; t++)
        dTotal = dTotal + arr[d][t];

      DayAverage[d] = dTotal/3;
      System.out.format("\n " + (d+1) + " ---> %.2f", + DayAverage[d]);
    }

    System.out.print("\n\n===Timely Average===");
    System.out.print("\n\nTime --> Average");
    for(t = 0; t < 3; t++){
      tTotal = 0;
      for(d = 0; d < 7; d++)
        tTotal = tTotal + arr[d][t];

        TimeAverage[t] = tTotal/7;
        System.out.format("\n " + (t+1) + " ---> %.2f", + TimeAverage[t]);
    }
  }

  //Function for printing array on the screen
  public static void printarray(double[][] arr){
    System.out.println("\n\nThe Populated Array is: ");
    for(d = 0; d < arr.length; d++){
      for(t = 0; t < arr[d].length; t++){
        System.out.print("\t" + arr[d][t]);
      }

      System.out.println();
    }
  }

  public static void writearray(double[][] temp) throws Exception{
    //Open output file
    FileWriter fw = new FileWriter("WeeklyAvgFEB2019.txt");
    PrintWriter pw = new PrintWriter(fw);

    //writing in the output file
    pw.println("DAY -> Morning  Noon  Evening  ==> Daily Average");
    for(d = 0; d < 7; d++){
      pw.print(d+1);
      for(t = 0; t < 3; t++){
        pw.print("\t");
        pw.format("%.2f",+temp[d][t]);
        pw.flush();
      }

      pw.println();
      pw.print("\nAVG: ");
      for(t = 0; t < 3; t++){
        pw.print("\t");
        pw.format("%.2f",+TimeAverage[t]);
      }

      System.out.println("\n\nThe Average has been in the output file 'weeklyaverage.txt'");

      //closing output file
      pw.close();
    }
  }
}
