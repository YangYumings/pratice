package cn.edu.tsinghua.acwing.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acwing838 {
  static int n;
  static int m;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);
    arr = new int[n + 1];
    String[] line2 = br.readLine().split(" ");
    for(int i = 1; i <= n; i ++ ){
      arr[i] = Integer.parseInt(line2[i - 1]);
    }

    for(int i = n/2; i > 0;i--){
      down(i);
    }

    while(m-- != 0){
      System.out.println(arr[1]);
      arr[1] = arr[n];
      n--;
      down(1);
    }
  }

  public static void down(int k){
    int min = k;
    if(2 * k < n && arr[2 * k] < arr[min]){
      min = 2 * k;
    }
    if(2 * k + 1 < n && arr[2 * k + 1] < arr[min]){
      min = 2 * k + 1;
    }
    if(min != k){
      int temp = arr[k];
      arr[k] = arr[min];
      arr[min] = temp;
      down(min);
    }
  }

}
