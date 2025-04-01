package cn.edu.tsinghua.acwing.sort.template;

public class InsertSort implements Sort {
  public void insertSort(int[] arr, int begin, int end) {
    // 每次向前面已经排好序的数组里插入数据
    for (int i = begin + 1; i <= end; i++) {
      int j = i - 1;
      int base = arr[i];
      while (j >= begin && arr[j] > base) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = base;
    }
  }
}
