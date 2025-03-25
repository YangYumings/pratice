package cn.edu.tsinghua.acwing.intervalMerging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class acwing803 {
  static Pair[] p = new Pair[100010];
  static int sum  =0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    for (int i = 0; i < n; i++) {
      String[] line2 = br.readLine().split(" ");
      p[i] = new Pair(Integer.parseInt(line2[0]), Integer.parseInt(line2[1]));
    }
    Arrays.sort(p);

    for(int i = 0; i < n -1; i++){
       if(p[i].r >= p[i + 1].l){
         p[i + 1].l = p[i].l;
         p[i + 1].r = Math.max(p[i].r, p[i + 1].r);
       }else{
         sum ++;
       }
    }
    System.out.println(sum);
  }

  static class Pair implements Comparator<Pair> {
    int l, r;

    public Pair(int l, int r) {
      this.l = l;
      this.r = r;
    }

    @Override
    public int compare(Pair o1, Pair o2) {
      if (o1.l == o2.l) return o1.r - o2.r;
      return o1.l - o2.l;
    }
  }
}
