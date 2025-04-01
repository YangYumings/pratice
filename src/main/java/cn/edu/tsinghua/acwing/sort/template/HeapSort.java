package cn.edu.tsinghua.acwing.sort.template;

public class HeapSort implements Sort {
  public void heapSort(int[] arr, int begin, int end) {
    // 堆是完美二叉树
    // 找最后一个有叶子节点的节点 arr.length / 2 - 1
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
      siftDown(arr, arr.length, i);
    }
  }

  public void siftDown(int[] arr, int n, int k) {
    while (true) {
      int max = k;
      int l = 2 * k + 1;
      int r = 2 * k + 2;
      // 和左右儿子比较大小，找最大值
      if (l < n && arr[l] > arr[max]) {
        max = l;
      }
      if (r < n && arr[r] > arr[max]) {
        max = r;
      }
      // 当前节点为最大值，则不需要再调整
      if (max == k) {
        break;
      }
      // 否则，交换值
      int temp = arr[k];
      arr[k] = arr[max];
      arr[max] = temp;
      // 继续维护子树
      k = max;
    }
  }
}
