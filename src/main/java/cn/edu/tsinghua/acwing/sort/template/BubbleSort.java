package cn.edu.tsinghua.acwing.sort.template;

public class BubbleSort implements Sort {
  public void bubbleSort(int[] arr, int begin, int end) {
    // 每次将最大值移动到最后一个位置
    for (int i = end; i >= begin; i--) {
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
