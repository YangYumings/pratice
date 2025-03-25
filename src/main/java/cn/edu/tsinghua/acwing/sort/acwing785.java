package cn.edu.tsinghua.acwing.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acwing785 {
  static int n = 0;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    arr = new int[n];
    String[] line2 = br.readLine().split(" ");
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(line2[i]);
    }
    quickSort(arr, 0, n - 1);
  }

  public static void quickSort(int[] arr, int begin, int end){
      if(begin >= end)
        return;
      int p = partition(arr, begin, end);
      quickSort(arr, begin, p - 1);
      quickSort(arr, p + 1, end);
  }

  public static int partition(int[] arr, int begin, int end){
      int p = arr[begin];
      int l = begin, r = end;
      while(l != r){
        while(l< r && p < arr[r]){
          r --;
        }
        while(l < r && p >= arr[l]){
          l ++;
        }
        if (l < r){
          int temp = arr[l];
          arr[l] = arr[r];
          arr[r] = temp;
        }
      }
      arr[begin] = arr[l];
      arr[l] = p;
      return l;
  }
}
