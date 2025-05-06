package cn.edu.tsinghua.meeting;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CircularBlockingQueue<T> {
  private T[] buffer;
  private int head = 0;
  private int tail = 0;
  private int size = 0;

  private final int capacity;

  private final ReentrantLock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition();
  private final Condition notEmpty = lock.newCondition();

  public CircularBlockingQueue(int capacity) {
    this.capacity = capacity;
    buffer = (T[]) new Object[capacity];
  }

  public void put(T t) throws InterruptedException {
    lock.lock();
    try {
      while(size == capacity){
        notFull.await();
      }
      buffer[tail] = t;
      tail = (tail + 1) % capacity;
      size ++;

      notEmpty.signal();
    }finally {
      lock.unlock();
    }
  }

  public T take() throws InterruptedException {
    lock.lock();
    try{
      while(size == 0){
        // Condition 的命名语义是面向“唤醒条件”而不是等待条件”的。
        notEmpty.await();  // 当队列“不是空”的时候，我会唤醒等待的线程。
      }
      T t = buffer[head];
      buffer[head] = null;
      head = (head + 1) / capacity;
      size--;

      notFull.signal();
      return t;
    }finally{
      lock.unlock();
    }
  }

  public int size(){
    lock.lock();
    try{
      return size;
    }finally{
      lock.unlock();
    }
  }
}
