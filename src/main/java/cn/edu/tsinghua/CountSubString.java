package cn.edu.tsinghua;

public class CountSubString {

  public static void main(String[] args) {
    countString("abbab","ab");
  }
  public static void countString(String str,String s) {
    // 求子串的个数
    int count = 0,len = str.length();
    while(str.indexOf(s) != -1) {
      str = str.substring(str.indexOf(s) + 1,str.length());
      count++;
    }
    System.out.println("此字符串有" + count + "个" + s);
  }
}
