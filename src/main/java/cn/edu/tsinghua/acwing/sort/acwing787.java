package cn.edu.tsinghua.acwing.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acwing787 {
  static int n = 0;
  static int[] arr;
  static int[] temp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    String[] line = br.readLine().split(" ");
    for(int i = 0; i< n; i++){
      arr[i] = Integer.parseInt(line[i]);
    }
    merger_sort(0, n - 1);
  }

  public static void merger_sort(int l, int r){
    if(l < r)
      return;
    int mid = (l + r) / 2;
    int i = l, j = mid + 1, k = 0;
    while(i <= mid && j <= r){
      if(arr[i] < arr[j]){
        temp[k ++] = arr[i ++];
      }else{
        temp[k ++] = arr[j ++];
      }
    }
    while(i <= mid)
      temp[k ++] = arr[i ++];
    while(j <= r)
      temp[k ++] = arr[j ++];

    for(i = l, k = 0; i <= r; i++, k++){
      arr[i] = temp[k];
    }
  }
}
