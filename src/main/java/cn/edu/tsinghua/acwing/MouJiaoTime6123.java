package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MouJiaoTime6123 {
  static int n;
  static int m;
  static char[] arr;
  static int[] arrInt;
  static int[][] count;
  static boolean [][] label;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);
    arr = br.readLine().toCharArray();
    arrInt = new int[26];
    label = new boolean[26][26];
    count = new int[26][26];

    for (int i = 0; i < n; i++){
      arrInt[i] = arr[i] -  'a';
    }
    updateLabel(0, n - 1, 1);
    for (int i = 0; i < n; i ++){
      int t = arrInt[i];
      updateLabel(i - 2, i + 2, -1);
      for(int j = 0; j < 26; j++){
        if(j != t){
          arrInt[i] =  j;
          updateLabel(i - 2, i + 2, 1);
          updateLabel(i - 2, i + 2, -1);
        }
      }
      arrInt[i] = t;
      updateLabel(i - 2, i + 2, 1);
    }

    int res = 0;
    for (int i = 0; i < 26; i++)
      for(int j = 0; j < 26; j++)
        if (label[i][j])
          res ++;
    System.out.println(res);

    for(int i = 0; i < 26; i++)
      for(int j = 0; j < 26; j++)
        if (label[i][j]){
          sb.append((char)(i + 'a')).append((char)(j + 'a')).append((char)(j + 'a'));
          System.out.println(sb.toString());
          sb.delete(0, sb.length());
        }
  }

  public static void updateLabel(int l, int r, int v){
    int left = Math.max(l, 0);
    int right = Math.min(r, n - 1);
    for(int i = left; i + 2 < right; i++){
      int a = arrInt[i];
      int b = arrInt[i + 1];
      int c = arrInt[i + 2];
      if (a != b && b == c){
        count[a][b] += v;
        if(count[a][b] >= m)
          label[a][b] = true;
      }
    }
  }
}
