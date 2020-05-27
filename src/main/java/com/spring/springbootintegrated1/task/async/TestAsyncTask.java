package com.spring.springbootintegrated1.task.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 测试异步任务业务类
 * 
 * @Description:TestAsyncTask
 * @author:yanglin
 * @time:2018年8月8日 下午10:52:59
 */
//@EnableAsync
//@Component
//@Async
public class TestAsyncTask {
    private static Logger logger = LoggerFactory.getLogger(TestAsyncTask.class);

    /**
     * <p>
     * 描述: 获取异步结果
     * </p>
     * <p>
     * 创建时间: 2019-11-20 11:08
     * </p>
     * <p>
     * 更新时间: 2019-11-20 11:08
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @return Future<String>
     * @throws InterruptedException 中断异常
     * 
     * @author yanglin
     */
    public Future<String> task4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);
        long end = System.currentTimeMillis();
        logger.info("任务4耗时=" + (end - begin));
        return new AsyncResult<String>("任务4");
    }

    /**
     * <p>
     * 描述: task5
     * </p>
     * <p>
     * 创建时间: 2019-11-20 11:09
     * </p>
     * <p>
     * 更新时间: 2019-11-20 11:09
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @return Future<String>
     * @throws InterruptedException 中断异常
     * 
     * @author yanglin
     */
    public Future<String> task5() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        logger.info("异步任务5耗时=" + (end - begin));
        return new AsyncResult<String>("任务5");
    }

    /**
     * <p>
     * 描述: task6
     * </p>
     * <p>
     * 创建时间: 2019-11-20 11:10
     * </p>
     * <p>
     * 更新时间: 2019-11-20 11:10
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @return Future<String>
     * @throws InterruptedException 中断异常
     * 
     * @author yanglin
     */
    public Future<String> task6() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);
        long end = System.currentTimeMillis();
        logger.info("异步任务6耗时=" + (end - begin));
        return new AsyncResult<String>("任务6");
    }
}
