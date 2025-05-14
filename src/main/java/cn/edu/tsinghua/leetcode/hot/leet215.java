package cn.edu.tsinghua.leetcode.hot;

public class leet215 {
    /**
     * 数组中的第K个最大元素
     * 思路：大根堆（建堆、调整策略）
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int res = findKthLargest(nums, 2);
        System.out.println(res);
    }

    public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);

        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            // pop 栈顶元素，需要和末尾元素交换，然乎调整
            swap(nums, 0, i);
            // 调整
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public static void maxHeapify(int[] a, int i, int heapSize) {
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        int max = i;
        // 每次左右子树与最大的值比较
        if (leftIndex < heapSize && a[leftIndex] > a[max]) {
            max = leftIndex;
        }
        if (rightIndex < heapSize && a[rightIndex] > a[max]) {
            max = rightIndex;
        }
        if (max != i) {
            swap(a, i, max);
            maxHeapify(a, max, heapSize);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
