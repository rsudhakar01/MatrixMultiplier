import java.util.Scanner;

public class MatrixMultiplier {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean flag = true;
    String[] userChoice;
    
    int[] matrixDims1 = new int[2];
    int[] matrixDims2 = new int[2];
    String userIn = "";
    System.out.println("Welcome to Matrix Multiplier!");
    System.out.println("Begin by inputting the number of rows and columns for each matrix "
        + "and subsequently the numbers. Please input the dimensions of each matrix on a different "
        + "line");
    System.out.println();
    System.out.println("For example, for a 2 x 2 matrix input the rows and columns as 2x2");

    userIn = sc.nextLine();
    userChoice = userIn.split("x");

    matrixDims1 = assignVal(userChoice, matrixDims1);

    userIn = sc.nextLine();
    userChoice = userIn.split("x");

    matrixDims2 = assignVal(userChoice, matrixDims2);

    // print(matrixDims1);
    // print(matrixDims2);

    while (flag) {
      if (matrixDims1[1] != matrixDims2[0]) {
        System.out.println("The matrices cannot be multiplied because of their dimensions.");
        flag = false;
        return;
      }
      break;
    } 
    

    Matrix m1 = new Matrix(matrixDims1[0], matrixDims1[1]);
    Matrix m2 = new Matrix(matrixDims2[0], matrixDims2[1]);

    System.out.println(
        "Enter the elements of the corresponding matrix. Enter different rows on different lines and "
        + "elements of different columns separated by commas");
    System.out.println();
    System.out.println("For example if your matrix is |2  2|");
    System.out.println("                              |3  8|");
    System.out.println("Input it as 2,2 and 3,8 on the next line ");
    
    //userIn = sc.nextLine();
    int[] rowEl = new int[m1.getCol()];
   
    for (int i = 0; i < m1.getRow(); i++) {
      userIn = sc.nextLine();
      rowEl = assignVal(userIn.split(","), rowEl); // all elements of a row
      m1.assignEl(rowEl, i);
    }
    printMatrix(m1);
    
    System.out.println("Repeat for second matrix");
    int[] rowEl2 = new int[m2.getCol()];
    for (int i = 0; i < m2.getRow(); i++) {
      userIn = sc.nextLine();
      rowEl2 = assignVal(userIn.split(","), rowEl2); // all elements of a row
      m2.assignEl(rowEl2, i);
    }
    printMatrix(m2);
    
    Matrix prodMat = new Matrix(matrixDims1[0], matrixDims2[1]);

  }
  
  private static int[] assignVal(String[] userArrIn, int[] matrixDims) {
   
    for (int i = 0; i < userArrIn.length; i++) {
      matrixDims[i] = Integer.valueOf(userArrIn[i]);
    }
    return matrixDims;
  }
  
  private static void print(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
  private static void printMatrix(Matrix m) {
    for(int i = 0; i < m.arr.length; i++) {
      for(int j = 0; j < m.arr[i].length; j++) {
        if(j == 0) {
        System.out.print("|" + m.arr[i][j] + " ");} 
        else if(j == m.arr[i].length -1) {
          System.out.print(" " + m.arr[i][j] + "|");
          
        }
        else {
          System.out.print(m.arr[i][j] + " ");
        } 
      }
      
      System.out.println();
    }
  }

}
