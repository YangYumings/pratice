package cn.edu.tsinghua.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet451 {
  public static void main(String[] args) {

  }

  public static String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>(s.length());
    // map 存储字符出现的次数
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    List<Character> list = new ArrayList<>(map.keySet());
    Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
    StringBuilder sb = new StringBuilder();

    for (Character c : list) {
      for (int i = 0; i < map.get(c); i++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
