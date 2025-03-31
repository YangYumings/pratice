package cn.edu.tsinghua.leetcode;

public class leet2109 {
  public static void main(String[] args) {

  }

  public String addSpaces(String s, int[] spaces) {
    StringBuilder sb = new StringBuilder();
    if (spaces[0] == 0) {
      sb.append(" ");
    } else {
      // subString 是左闭右开
      sb.append(s.substring(0, spaces[0])).append(" ");
    }

    for (int i = 1; i < spaces.length; i++) {
      sb.append(s.substring(spaces[i - 1], spaces[i])).append(" ");
    }
    sb.append(s.substring(spaces[spaces.length - 1]));
    return sb.toString();
  }
}
