package cn.edu.tsinghua.acwing.sort;

public class acwing788 {
  public static void main(String[] args) {

  }

  // 逆序对的数量
  public static int mergeSort(int[] nums, int l, int r) {
    if (l >= r) {
      return 0;
    }
    int mid = l + r >> 1;
    int res = 0;
    int[] temp = new int[r - l + 1];
    res += mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);

    int i = l, j = mid + 1, k = 0;
    while (i < mid + 1 && j < r + 1) {
      if (nums[i] <= nums[j]) {
        temp[k++] = nums[i++];
      } else {
        temp[k++] = nums[j++];
        res += mid + 1 - i;
      }
    }

    // 尾处理
    while (i < mid + 1) {
      temp[k++] = nums[i++];
    }
    while (j < mid + 1) {
      temp[k++] = nums[j++];
    }

    // 替换原来的数组
    for (i = l, j = 0; i < r + 1; i++, j++) {
      nums[i++] = temp[j++];
    }
    return res;
  }
}
