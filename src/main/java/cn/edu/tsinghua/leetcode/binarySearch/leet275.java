package cn.edu.tsinghua.leetcode.binarySearch;

public class leet275 {
  public static void main(String[] args) {
    int[] arr = {0, 1, 3, 5, 6};
    System.out.println(hIndex(arr));
  }
  public static int hIndex(int[] citations) {
    int length = citations.length;
    int l = 0, r = length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (citations[mid] >= length - mid) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return length - l ;
  }
}
