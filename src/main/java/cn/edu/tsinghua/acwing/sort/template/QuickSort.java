package cn.edu.tsinghua.acwing.sort.template;

public class QuickSort implements Sort{

  public void quickSort(int[] arr, int begin, int end) {
    if (begin >= end) {
      return;
    }
    int p = partition(arr, begin, end);
    quickSort(arr, begin, p - 1);
    quickSort(arr, p + 1, end);
  }

  public int partition(int[] arr, int begin, int end) {
    int p = arr[begin];
    int l = begin, r = end;
    while (l != r) {
      while (l < r && p < arr[r]) {
        r--;
      }
      while (l < r && p >= arr[l]) {
        l++;
      }
      if (l < r) {
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
