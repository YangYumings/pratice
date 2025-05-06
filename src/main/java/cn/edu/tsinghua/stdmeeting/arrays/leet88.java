package cn.edu.tsinghua.stdmeeting.arrays;

import java.util.Arrays;

public class leet88 {
  static int[] nums3;

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    new leet88().merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }

  /**
   * 有序数组
   * 合并时依次比对即可。
   * 注意Java的参数传递是值传递，传递的是引用的一个复制体，因此你修改引用的指定并不会对原始的对象造成影响。
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    nums3 = new int[m + n];
    int i = 0, j = 0, k = 0;
    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        nums3[k++] = nums1[i++];
      } else {
        nums3[k++] = nums2[j++];
      }
    }
    while (i < m) {
      nums3[k++] = nums1[i++];
    }
    while (j < n) {
      nums3[k++] = nums2[j++];
    }
    Arrays.setAll(nums1, l -> nums3[l]);
  }

}
