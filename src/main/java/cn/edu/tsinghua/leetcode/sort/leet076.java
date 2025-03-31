package cn.edu.tsinghua.leetcode.sort;

public class leet076 {
  public static void main(String[] args) {
    int[] nums = {5, 2, 4, 1, 3, 6, 0};
//    System.out.println(findKthLargest(nums, 4));
    quickSort_2(nums, 0, nums.length - 1, 4);
    System.out.println();
  }

  public static int findKthLargest(int[] nums, int k) {
    // 快排
    // 堆
    return quickSort(nums, 0, nums.length - 1, nums.length) - k;
  }

  public static int quickSort(int[] arr, int begin, int end, int index) {
    int p = partition(arr, begin, end);
    if (p == index) {
      return arr[p];
    } else {
      return p > index ? quickSort(arr, begin, p - 1, index) : quickSort(arr, p + 1, end, index);
    }
  }

  public static void quickSort_2(int[] arr, int begin, int end, int index) {
    if(begin >= end)
      return;
    int p = partition(arr, begin, end);
    quickSort_2(arr, begin, p - 1, index);
    quickSort_2(arr, p + 1, end, index);
  }

  public static int partition(int[] arr, int begin, int end) {
    int p = arr[begin];
    int l = begin, r = end;
    while (l < r) {
      while (l < r && p <= arr[r]) {
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
