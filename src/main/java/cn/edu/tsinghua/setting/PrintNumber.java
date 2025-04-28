package cn.edu.tsinghua.setting;

public class PrintNumber {
  private static final Object lock = new Object();
  private static int index = 1;
  private static final int count = 10;

  public static void main(String[] args) {
    // odd
    Runnable runnable1 = () -> {
      synchronized (lock) {
        while (index <= count) {
          if(index % 2 == 0){
            System.out.println(index ++);
            lock.notify();
          }else{
            try {
              lock.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
        }
        lock.notifyAll();
      }
    };

    // even
    Runnable runnable2 = () -> {
      synchronized (lock) {
        while (index <= count) {
          if(index % 2 != 0){
            System.out.println(index ++);
            lock.notify();
          }else{
            try{
              lock.wait();
            }catch(InterruptedException e){
              throw new RuntimeException(e);
            }
          }
        }
        lock.notifyAll();
      }
    };

    Thread thread2 = new Thread(runnable2);
    Thread thread1 = new Thread(runnable1);

    thread2.start();
    thread1.start();

    try {
      // 主线程等待下面两个线程结束后再退出。
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}


