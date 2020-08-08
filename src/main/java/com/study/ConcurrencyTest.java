package com.study;

/**
 * @author lenovo
 * @date 13:46
 * 并发一定快吗？验证一下
 */
public class ConcurrencyTest {

    public static final int COUNT = 1000000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("COUNT：" + COUNT);
        concurrency();
        serial();
    }


    public static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                int a = 0;
                for(int i=0;i<COUNT;i++){
                    a++;
                }
            }
        });
        thread.start();
        int b = 0;
        for(int i=0;i<COUNT;i++){
            b--;
        }
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency : " + time + "ms");
    }

    public static void serial() throws InterruptedException {
        long start = System.currentTimeMillis();
        int a = 0;
        for(int i=0;i<COUNT;i++){
            a++;
        }
        int b = 0;
        for(int i=0;i<COUNT;i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial : " + time + "ms");
    }

}
