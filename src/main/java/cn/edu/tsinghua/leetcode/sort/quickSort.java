package cn.edu.tsinghua.leetcode.sort;

public class quickSort {

  public static void main(String[] args) {

  }

  public static void quickSort_1(int arr[], int begin, int end) {
    if (begin >= end) {
      return;
    }
    int poit = partition_1(arr, begin, end);
    quickSort_1(arr, begin, poit - 1);
    quickSort_1(arr, poit + 1, end);
  }

  public static int partition_1(int[] arr, int begin, int end) {
    int p = arr[begin];
    int l = begin, r = end;

    while(l != r){
      while ((l < r) && (p >= arr[l])) {
        l++;
      }
      while ((l < r) && (p < arr[r])) {
        r--;
      }
      if(l < r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
      }
    }
    // 哨兵与对应位置交换
    int temp = arr[begin];
    arr[begin] = arr[r];
    arr[r] = temp;
    return r;
  }
}
