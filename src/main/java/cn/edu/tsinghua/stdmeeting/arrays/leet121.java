package cn.edu.tsinghua.stdmeeting.arrays;

public class leet121 {
  /**
   * 遍历一次
   * 将当前价格认为是抛出的日子，然后从前面找最小的价格作为入手日志（遍历时维护）
   * 抛出和入手的差值就是最大利润
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int len = prices.length;
    int min = Integer.MAX_VALUE;
    int max = 0;
    for (int i = 0; i < len; i++) {
      min = Math.min(min, prices[i]);
      max = Math.max(max, prices[i] - min);
    }
    return max;
  }
}
