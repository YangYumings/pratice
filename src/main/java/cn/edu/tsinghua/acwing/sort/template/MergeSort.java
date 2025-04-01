package cn.edu.tsinghua.acwing.sort.template;

public class MergeSort implements Sort {

  public void mergeSort(int[] arr, int begin, int end) {
    if (begin >= end)
      return;
    int[] temp = new int[arr.length];
    int indexOfTemp = 0;
    int mid = (begin + end) / 2;
    int l = begin, r = mid + 1;

    while (l <= mid && r <= end) {
      if (arr[l] < arr[r]) {
        temp[indexOfTemp++] = arr[l++];
      } else {
        temp[indexOfTemp++] = arr[r++];
      }
    }
    while (l <= mid) {
      temp[indexOfTemp++] = arr[l++];
    }
    while (r < end) {
      temp[indexOfTemp++] = arr[r++];
    }
    for (int i = 0; i < indexOfTemp; i++) {
      arr[begin + i] = temp[i];
    }
  }
}
