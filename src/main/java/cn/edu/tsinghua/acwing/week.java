package cn.edu.tsinghua.acwing;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class week {
  public static void main(String[] args) {
    LocalDate today = LocalDate.now();
    LocalDate thisMonday = today.with(DayOfWeek.MONDAY);

    System.out.println("本周的周一日期是：" + thisMonday);
  }
}
