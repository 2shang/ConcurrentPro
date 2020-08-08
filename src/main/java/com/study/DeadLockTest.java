package com.study;

/**
 * @author lenovo
 * @date 9:53
 */
public class DeadLockTest {

    static final String ResourceA = "ResourceA";
    static final String ResourceB = "ResourceB";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                synchronized (ResourceA){
                    System.out.println("获取ResourceA的锁");
                    //睡眠1s，确保线程T2先获得ResourceB的锁
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (ResourceB){
                        System.out.println("获取ResourceB的锁");
                    }
                }
            }
        },"T1").start();
        new Thread(new Runnable() {
            public void run() {
                synchronized (ResourceB){
                    System.out.println("获取ResourceB的锁");
                    //睡眠1s，确保线程T1先获得ResourceA的锁
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (ResourceA){
                        System.out.println("获取ResourceAS的锁");
                    }
                }
            }
        },"T2").start();

    }
}
