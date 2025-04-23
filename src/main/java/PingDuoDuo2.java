import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PingDuoDuo2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- != 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
      boolean[] vis = new boolean[n + 1];
      for (int i = 0; i < m; i++) {
        int left = sc.nextInt();
        vis[left] = true;
        int right = sc.nextInt();
        if (map.containsKey(left)) {
          map.get(left).add(right);
        } else {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(right);
          map.put(left, list);
        }
      }
      // 这里是每个案例的计算
      int[] res = countM(map, n, vis);

      int count = 0;
      for (int i = 0; i < res.length; i++) {
        count += res[i];
      }
      System.out.println(count);
    }
  }

  public static int[] countM(HashMap<Integer, ArrayList<Integer>> map,
                             int number, boolean[] vis) {
    int[] res = new int[number + 1];
    for(int i = 1; i < vis.length; i++){
      if(!vis[i]){
        res[i] = 100;
      }
    }
    for (int i = 1; i <= number; i++) {
      getM(i, map, res);
    }
    return res;
  }

  public static Integer getM(Integer k, HashMap<Integer, ArrayList<Integer>> map,
                             int[] res) {
    if (!map.containsKey(k)) {
      res[k] = 100;
      return 100;
    } else {
      int max = 0;
      for (Integer i : map.get(k)) {
        // 递归的次数太多了
        if(res[i] != 0){
          max = Math.max(max, res[i]);
        }else{
          max = Math.max(max, getM(i, map, res));
        }
      }
      res[k] = max + 10;
      return res[k];
    }
  }
}

//
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class Main {
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int T = sc.nextInt();
//    while (T-- != 0) {
//      int n = sc.nextInt();
//      int m = sc.nextInt();
//      HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//      for (int i = 0; i < m; i++) {
//        int left = sc.nextInt();
//        int right = sc.nextInt();
//        if (map.containsKey(left)) {
//          map.get(left).add(right);
//        } else {
//          ArrayList<Integer> list = new ArrayList<>();
//          list.add(right);
//          map.put(left, list);
//        }
//      }
//      int[] res = countM(map, n);
//      int count = 0;
//      for (int i = 0; i < res.length; i++) {
//        count += res[i];
//      }
//      System.out.println(count);
//    }
//  }
//
//  public static int[] countM(HashMap<Integer, ArrayList<Integer>> map,
//                             int number) {
//    int[] res = new int[number + 1];
//    // for (int i = 1; i < vis.length; i++) {
//    //     if (!vis[i]) {
//    //         res[i] = 100;
//    //     }
//    // }
//    for (int i = 1; i <= number; i++) {
//      getM(i, map, res);
//    }
//    return res;
//  }
//
//  public static Integer getM(Integer k, HashMap<Integer, ArrayList<Integer>> map,
//                             int[] res) {
//    if (!map.containsKey(k)) {
//      res[k] = 100;
//      return 100;
//    } else {
//      int max = 0;
//      for (Integer i : map.get(k)) {
//        if (res[i] != 0) {
//          max = Math.max(max, res[i]);
//        } else {
//          // 递归的次数太多了
//          max = Math.max(max, getM(i, map, res));
//        }
//      }
//      res[k] = max + 10;
//      return res[k];
//    }
//  }
//}