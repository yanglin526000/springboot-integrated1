package com.spring.springbootintegrated1.task.timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 测试定时任务
 * 
 * @Description:TestTimedTask
 * @author:yanglin
 * @time:2018年8月8日 下午10:48:08
 */
//@EnableScheduling
//@Component
public class TestTimedTask {
    private static Logger logger = LoggerFactory.getLogger(TestTimedTask.class);

    /**
     * <p>
     * 描述: 表示方法执行完成后5秒
     * </p>
     * <p>
     * 创建时间: 2019-11-20 10:26
     * </p>
     * <p>
     * 更新时间: 2019-11-20 10:26
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * @throws InterruptedException 中断异常
     * 
     * @author yanglin
     */
    @Scheduled(fixedDelay = 5000)
    public void fixedDelayJob() throws InterruptedException {
        logger.info("fixedDelay 每隔5秒" + new Date());
    }

    /**
     * <p>
     * 描述: 表示每隔3秒
     * </p>
     * <p>
     * 创建时间: 2019-11-20 10:27
     * </p>
     * <p>
     * 更新时间: 2019-11-20 10:27
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * 
     * @author yanglin
     */
    @Scheduled(fixedRate = 3000)
    public void fixedRateJob() {
        logger.info("fixedRate 每隔3秒" + new Date());
    }

    /**
     * <p>
     * 描述: 表示每天3时15分0秒执行---关于cron表达式写法，可以参考 http://cron.qqe2.com/
     * </p>
     * <p>
     * 创建时间: 2019-11-20 10:28
     * </p>
     * <p>
     * 更新时间: 2019-11-20 10:28
     * </p>
     * <p>
     * 更新者: yanglin
     * </p>
     * 
     * 
     * @author yanglin
     */
    @Scheduled(cron = "0 15 3 * * ?")
    public void cronJob() {
        logger.info(new Date() + " ...>>cron....");
    }
}
