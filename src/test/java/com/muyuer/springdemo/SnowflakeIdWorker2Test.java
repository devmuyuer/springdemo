package com.muyuer.springdemo;

import com.muyuer.springdemo.utils.SnowflakeIdWorker;

import java.util.HashSet;

/**
 * 这里的测试会出现重复
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2018-12-05 17:51
 */
public class SnowflakeIdWorker2Test {
    public static HashSet<Long> idSet = new HashSet<>();

    public static void main(String[] args) {
        for (long i = 0; i < 1000; i++) {
            new Thread(new Worker(new SnowflakeIdWorker(1, 0))).start();
        }
    }

    static class Worker implements Runnable {

        private SnowflakeIdWorker snowflakeIdWorker;

        public Worker(SnowflakeIdWorker snowflakeIdWorker) {
            this.snowflakeIdWorker = snowflakeIdWorker;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                Long id = snowflakeIdWorker.nextId();
//                synchronized (SnowflakeIdWorkerTest.class) {
                System.out.println(id);
                if (!idSet.add(id)) {
                    System.err.println("存在重复id:" + id);
                }
//                }
            }
        }
    }
}
