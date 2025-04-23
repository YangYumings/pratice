package cn.edu.tsinghua.acwing.BIT;

//          快速求前缀和     修改某个数
// 数组        o(n)           o(n)
// 前缀和      o(1)           o(1)
// 树状数组     o(logn)       o(logn)
public class BinaryIndexedTree {
  int M = 32010;
  int[] tree;

  public BinaryIndexedTree(int n) {
    M = n;
    tree = new int[M];
  }

  /**
   * 二进制下的最低为1及其后面的0构成的数
   *
   * @param n
   * @return
   */
  public int lowBit(int n) {
    return n & (-n);
  }

  /**
   * 单点修改
   *
   * @param x 指定位置
   * @param t 增加
   */
  public void update(int x, int t) {
    for (int i = x; i < M; i += lowBit(i))
      tree[i] += t;
  }

  /**
   * 区间查询
   * 求1 ~ x 的和 比如 1 ~ 7 的和为 tree[7] + tree[6] + tree[4] + tree[0]
   *
   * @param x
   * @return
   */
  public int query(int x) {
    int ans = 0;
    for (int i = x; i > 0; i -= lowBit(i))
      ans += tree[i];
    return ans;
  }

  /**
   * 区间查询 【L, R】
   *
   * @param l
   * @param r
   * @return
   */
  public int searchLR(int l, int r) {
    int ans = 0;
    for (int i = l; i > 0; i -= lowBit(i)) {
      ans -= tree[i];
    }
    for (int i = r; i > 0; i -= lowBit(i)) {
      ans += tree[i];
    }
    return ans;
  }

}
