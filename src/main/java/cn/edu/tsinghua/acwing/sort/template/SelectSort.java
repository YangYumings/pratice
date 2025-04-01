package cn.edu.tsinghua.acwing.sort.template;

public class SelectSort implements Sort {

  public void selectSort(int[] arr, int begin, int end) {
    // 外层循环
    for (int i = begin; i <= end; i++) {
      // k 标记最小点下标
      int k = i;
      // 内存循环找最小值
      for (int j = i + 1; j <= end; j++) {
        if (arr[j] < arr[k]) {
          k = j;
        }
      }
      // 交换
      if (k != i) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
      }
    }
  }
}
