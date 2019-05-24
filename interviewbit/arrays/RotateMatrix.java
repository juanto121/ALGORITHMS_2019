import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//https://www.interviewbit.com/problems/rotate-matrix/
public class RotateMatrix {
  public void rotate(ArrayList<ArrayList<Integer>> a) {
    int n = a.size();

    int arr[][] = new int[n][n];
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        arr[i][j] = a.get(i).get(j);
      }
    }

    transpose(arr);
    reverseColumns(arr);

    for(int i = 0; i < n; i++)
      System.out.println(Arrays.toString(arr[i]));
  }

  public void transpose(int a[][]) {
    int n = a.length;
    for(int i = 0; i < n; i++){
      for(int j = i; j < n; j++) {
        int temp = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = temp;
      }
    }
  }

  public void reverseColumns(int a[][]) {
    int n = a.length;
    int left = 0;
    int right = n-1;
    while(left < right) {
      for(int row = 0; row < n; row++) {
        int temp = a[row][right];
        a[row][right] = a[row][left];
        a[row][left] = temp;
      }
      left++; right--;
    }
  }

  @Test
  public void testRotation() {
    ArrayList<Integer> row1 = new ArrayList<>();
    row1.add(1);
    row1.add(2);
    ArrayList<Integer> row2 = new ArrayList<>();
    row2.add(3);
    row2.add(4);
    ArrayList<ArrayList<Integer>> image = new ArrayList<>();
    image.add(row1);
    image.add(row2);
    rotate(image);
  }

  @Test
  public void testTranspose() {
    int a[][] = {{1,2},{3,4}};
    int expected[][] = {{1,3},{2,4}};
    transpose(a);
    Assert.assertArrayEquals(expected, a);
  }

  @Test
  public void testRotationN4() {
    int a[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    ArrayList<ArrayList<Integer>> arr =  atol(a);
    rotate(arr);
  }


  @Test
  public void testRotationN1() {
    int a[][] = {{1}};
    ArrayList<ArrayList<Integer>> arr = atol(a);
    rotate(arr);
  }

  public ArrayList<ArrayList<Integer>> atol(int a[][]) {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    for(int i = 0; i < a.length; i++) {
      ArrayList<Integer> subA = (ArrayList<Integer>) Arrays.stream(a[i]).boxed().collect(Collectors.toList());
      arr.add(subA);
    }
    return arr;
  }

}
