package com.wang.concurrency;

public class Test {
	   private volatile int inc = 0;
//	   public int inc = 0;
     
   
   public synchronized void increase() {
   //without synchronized keyword, the final inc < 10000
//   public void increase() {
        inc++;
    }
     
    public static void main(String[] args) {
        final Test test = new Test();
        Counter counter = new Counter();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++){
                        test.increase();
                    	counter.increment();
                    }
                };
            }.start();
        }
         
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
        System.out.printf("Counter.getCount()=%d", counter.getCounter());
    }
    
}
