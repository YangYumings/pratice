package cn.edu.tsinghua.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class leet3 {
  // 滑动窗口 + hashMap
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> dic = new HashMap<>();
    for(Map.Entry<Character, Integer> entry: dic.entrySet()){
    }
    int l = -1; // 左指针
    int ans = 0;
    for (int r = 0; r < s.length(); r++) {
      Character c = s.charAt(r);
      if (dic.containsKey(c)) {
        l = Math.max(l, dic.get(c));
      }
      dic.put(c, r);
      ans = Math.max(ans, r - l);
    }
    return ans;
  }

  // DP + hashMap
  public int lengthOfLongestSubstring2(String s) {
    // 列表 dp[i] 代表以字符串 arr[i] 为结尾的最长不重复子串的长度
    // dp[i] < j - i  : dp[i] = dp[i-1] + 1
    // i = -1 : dp[i] = dp[i-1] + 1
    // dp[i] >= j - i : dp[i] = j - i;
    /**
     * 假设状态矩阵中存储的数据都是字符串中当前字符前的最大长度不重复子串subStr，然后再考虑下一个字符；
     * 会记录下一个字符的上一次出现的位置；
     * 若位置在subStr中的位置，则长度为 j - i
     * 若位置不在subStr中，则长度为 dp[i-1] + 1
     */
    HashMap<Character, Integer> dic = new HashMap<>();
    int temp = 0;
    int ans = 0;
    for (int j = 0; j < s.length(); j++) {
      char c = s.charAt(j);
      int i = dic.getOrDefault(c, -1);
      dic.put(c, j);
      temp = temp < j - i ? temp + 1 : j - i;
      ans = Math.max(ans, temp);
    }
    return ans;
  }
}
