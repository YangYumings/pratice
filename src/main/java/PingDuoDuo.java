import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PingDuoDuo {

  static ArrayList<Character> res = new ArrayList();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int k = sc.nextInt();
    for (int i = 0; i < N; i++) {
      String str = sc.next();
      StringBuilder sb = new StringBuilder(str);
      Integer count = sc.nextInt();
      while (count-- != 0) {
        str = getMin(str, sb);
      }
    }
    // 排序
    res.sort((a, b) -> {
      return a - b;
    });
    StringBuilder r = new StringBuilder();
    for (int i = 0; i < k; i++) {
      r.append(res.get(i));
    }
    System.out.println(r.toString());
  }

  public static String getMin(String str, StringBuilder sb) {
    for (int i = 0; i < 26; i++) {
      char c = (char) (i + 'a');
      String tempStr = String.valueOf(c);
      if (str.contains(tempStr)) {
        int index = str.indexOf(tempStr);
        sb.delete(index, index + 1);
        res.add(c);
        return sb.toString();
      }
    }
    return null;
  }
}
