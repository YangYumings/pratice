package cn.edu.tsinghua.leetcode.twoPointer;

public class leet151 {
  public static void main(String[] args) {
    String s = "a good   example";
    reverseWords(s);
  }

  public static String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();

    String[] part = s.trim().split("\\s+");
    int start = 0, end = part.length - 1;
    while (start < end) {
      String temp = part[start];
      part[start] = part[end];
      part[end] = temp;
      start++;
      end--;
    }
    for (int i = 0; i < part.length; i++) {
      sb.append(part[i]).append(" ");
    }
    return sb.toString().trim();
  }

}
