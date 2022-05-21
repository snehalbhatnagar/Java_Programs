import java.util.Scanner;

public class strassen {
     
  private static Scanner scan = new Scanner(System.in);

  public int[][] multiply(int[][] a, int[][] b) {

    // find size of matrix
    int n = a.length;

    // create new matrix to store resultant
    int[][] c = new int[n][n];

    if (n == 1)
      c[0][0] = a[0][0] * b[0][0];
    else { 
      int[][] A11 = new int[n / 2][n / 2];
      int[][] A12 = new int[n / 2][n / 2];
      int[][] A21 = new int[n / 2][n / 2];
      int[][] A22 = new int[n / 2][n / 2];
      int[][] B11 = new int[n / 2][n / 2];
      int[][] B12 = new int[n / 2][n / 2];
      int[][] B21 = new int[n / 2][n / 2];
      int[][] B22 = new int[n / 2][n / 2];

      // divide strassen A into 4 halves
      split(a, A11, 0, 0);
      split(a, A12, 0, n / 2);
      split(a, A21, n / 2, 0);
      split(a, A22, n / 2, n / 2);
      // divide strassen B into 4 halves
      split(b, B11, 0, 0);
      split(b, B12, 0, n / 2);
      split(b, B21, n / 2, 0);
      split(b, B22, n / 2, n / 2);
      
      /** 
        * p1 = (A11 + A22)(B11 + B22)
        * p2 = (A21 + A22) B11
        * p3 = A11 (B12 - B22)
        * p4 = A22 (B21 - B11)
        * p5 = (A11 + A12) B22
        * p6 = (A21 - A11) (B11 + B12)
        * p7 = (A12 - A22) (B21 + B22)
        **/

      int[][] p1 = multiply(add(A11, A22), add(B11, B22));
      int[][] p2 = multiply(add(A21, A22), B11);
      int[][] p3 = multiply(A11, sub(B12, B22));
      int[][] p4 = multiply(A22, sub(B21, B11));
      int[][] p5 = multiply(add(A11, A12), B22);
      int[][] p6 = multiply(sub(A21, A11), add(B11, B12));
      int[][] p7 = multiply(sub(A12, A22), add(B21, B22));

      /**
        * C11 = p1 + p4 - p5 + p7
        * C12 = p3 + p5
        * C21 = p2 + p4
        * C22 = p1 - p2 + p3 + p6
        **/

      int[][] C11 = add(sub(add(p1, p4), p5), p7);
      int[][] C12 = add(p3, p5);
      int[][] C21 = add(p2, p4);
      int[][] C22 = add(sub(add(p1, p3), p2), p6);

      // join 4 halves into one result strassen 
      join(C11, c, 0, 0);
      join(C12, c, 0, n / 2);
      join(C21, c, n / 2, 0);
      join(C22, c, n / 2, n / 2);
    } // end-of-else-part

    // return resultant strassen
    return c;
  }

  // method to add two matrices
  public int[][] add(int[][] a, int[][] b) {
    int n = a.length;
    int[][] c = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        c[i][j] = a[i][j] + b[i][j];
    return c;
  }

  // method to subract two matrices
  public int[][] sub(int[][] a, int[][] b) {
    int n = a.length;
    int[][] c = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        c[i][j] = a[i][j] - b[i][j];
    return c;
  }

  // method to split parent strassen into child matrices
  public void split(int[][] parentstrassen, int[][] childstrassen, int fromIndex, int toIndex) {
    for (int i1=0, i2=fromIndex; i1 < childstrassen.length; i1++, i2++)
      for (int j1=0, j2=toIndex; j1 < childstrassen.length; j1++, j2++)
        childstrassen[i1][j1] = parentstrassen[i2][j2];
  }

  // method to join child matrices into parent strassen
  public void join(int[][] childstrassen, int[][] parentstrassen, int fromIndex, int toIndex) {
    for (int i1=0, i2=fromIndex; i1 < childstrassen.length; i1++, i2++)
      for (int j1=0, j2=toIndex; j1 < childstrassen.length; j1++, j2++)
        parentstrassen[i2][j2] = childstrassen[i1][j1];
  }

  // method to read strassen elements as input
  public int[][] readstrassen(int[][] temp) {
    for (int i = 0; i < temp.length; i++) {
      for (int j = 0; j < temp[0].length; j++) {
        // read strassen elements
        temp[i][j] = scan.nextInt();
      }
    }
    return temp;
  }

  // main method
  public static void main(String[] args) {

    System.out.println("Strassen's strassen "+"Multiplication Algorithm Test\n");

    // Create an object of strassen class
    strassen mtx = new strassen();

    // declare variables
    int size = 0;
    int a[][] = null; // first strassen
    int b[][] = null; // second strassen
    int c[][] = null; // resultant strassen

    System.out.print("Enter order of matrices: ");
    size = scan.nextInt();

    // initialize matrices
    a = new int[size][size];
    b = new int[size][size];
    c = new int[size][size];

    // read strassen A and B
    System.out.println("Enter matrix A: ");
    a = mtx.readstrassen(a);
    System.out.println("Enter matrix B: ");
    b = mtx.readstrassen(b);

    // multiplication of strassen
    c = mtx.multiply(a, b);

    // display resultant strassen
    System.out.println("Resultant matrix: ");
    for(int i=0; i<c.length; i++) {
      for(int j=0; j<c[0].length; j++) {
        System.out.print(c[i][j]+" ");
      }
      System.out.println(); 
    }
  }
    
}
