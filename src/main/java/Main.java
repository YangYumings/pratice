import java.util.*;
import java.io.*;

public class Main {
  HashSet<String> d = new HashSet<>();
  static final int MOD = (int)1e9 + 7;
  static int n, m;
  static int[][] grid;
  static long[] fact, invFact;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    grid = new int[n][m];
    int count1 = 0;

    // 读取网格并统计1的个数
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
        count1 += grid[i][j];
      }
    }

    int total = n * m;
    if (count1 == 0 || count1 == total) {
      System.out.println(1);
      return;
    }

    // 预计算阶乘和逆元
    precomputeFactorials(total);

    // 计算组合数 C(total, count1)
    long c = comb(total, count1);

    // 答案：C(total, count1) / 2 mod MOD
    long ans;
    if (total % 2 == 1) {
      ans = (c + 1) * pow(2, MOD - 2) % MOD;
    } else {
      ans = c * pow(2, MOD - 2) % MOD;
    }
    System.out.println(ans);
  }

  // 预计算阶乘和逆阶乘
  static void precomputeFactorials(int max) {
    fact = new long[max + 1];
    invFact = new long[max + 1];
    fact[0] = 1;
    for (int i = 1; i <= max; i++) {
      fact[i] = fact[i - 1] * i % MOD;
    }
    invFact[max] = pow(fact[max], MOD - 2);
    for (int i = max - 1; i >= 0; i--) {
      invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }
  }

  // 快速幂计算 a^b mod MOD
  static long pow(long a, int b) {
    long res = 1;
    while (b > 0) {
      if ((b & 1) == 1) {
        res = res * a % MOD;
      }
      a = a * a % MOD;
      b >>= 1;
    }
    return res;
  }

  // 组合数 C(a, b) mod MOD
  static long comb(int a, int b) {
    if (a < 0 || b < 0 || a < b) return 0;
    return fact[a] * invFact[b] % MOD * invFact[a - b] % MOD;
  }
}

