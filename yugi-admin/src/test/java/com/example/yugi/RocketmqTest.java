package com.example.yugi;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

/**
 * RocketMQ测试类
 *
 * @author jia
 * @since 2023-10-23 17:11:41
 */
@SpringBootTest(classes = {YugiAdminApplication.class})
public class RocketmqTest {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 普通发送测试
     */
    @Test
    public void sendTest(){
        rocketMQTemplate.convertAndSend("YUGI_EMAIL_TOPIC", "一封邮件");
        System.out.println("发送结束");
    }
}
