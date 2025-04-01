package com.kattyavar.shika.main.java.live_session.apr1.collectionsdemo.part2;

public class Part2 {

  static void matrix3by3(){
    int[][] matrix = new int[3][3];

    // Assign values to the 2D array
    matrix[0][0] = 1;
    matrix[0][1] = 2;
    matrix[0][2] = 3;

    matrix[1][0] = 4;
    matrix[1][1] = 5;
    matrix[1][2] = 6;

    matrix[2][0] = 7;
    matrix[2][1] = 8;
    matrix[2][2] = 9;

    for(int row =0; row < matrix.length; row++){
      for(int col=0; col < matrix[row].length; col++){
        System.out.print(matrix[row][col] + " ");
      }
      System.out.println();

    }

  }
  public static void main(String[] args) {

    int [][] matrix = new int[3][];

    matrix[0] = new int[3];
    matrix[1] = new int[10];
    matrix[2] = new int[1];

    int cnt = 1;
    //if you would like to insert values
    for(int row =0; row < matrix.length; row++){
      for(int col=0; col < matrix[row].length; col++){
        matrix[row][col] = cnt;
        cnt++;
      }
    }

    for(int row =0; row < matrix.length; row++){
      for(int col=0; col < matrix[row].length; col++){
        System.out.print(matrix[row][col] + "(" + row + "," + col + ") ");
      }
      System.out.println();

    }


  }
}
