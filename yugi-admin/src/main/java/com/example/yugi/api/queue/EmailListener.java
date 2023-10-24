package com.example.yugi.api.queue;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 邮件发送队列监听器
 *
 * @author jia
 * @since 2023-10-24 11:15:03
 */
@RocketMQMessageListener(
        consumerGroup = "YUGI_EMAIL_GROUP",
        topic = "YUGI_EMAIL_TOPIC"
)
@Component
@Slf4j
public class EmailListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String msg) {
        log.info("receive sending email request");
        System.out.println(msg);
    }
}
