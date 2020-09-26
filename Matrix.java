
public class Matrix {
  
  private static int row;
  private static int col;
  public static int[][] arr;
  public Matrix() {
    
  }
  
  public Matrix(int m, int n) {
    this.row = m;
    this.col = n;
    this.arr = new int[row][col];
  } 
  
  public int getRow() {
    return this.row;
  }
  public int getCol() {
    return this.col;
  } 
  
  public void assignEl(int[] rowEle, int rowNum) {
    for(int i = 0; i < rowEle.length; i++) {
      arr[rowNum][i] = rowEle[i];
    }
  }


}
