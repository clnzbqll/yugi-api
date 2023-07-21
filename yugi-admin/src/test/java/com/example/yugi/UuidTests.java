package com.example.yugi;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import java.util.UUID;

/**
 * UUID生成测试类
 *
 * @author jia
 * @since 2023-07-06 11:33:19
 */
@Slf4j
public class UuidTests {
    /**
     * JDK原生UUID测试
     */
    @Test
    void protogenTest() {
        UUID uuid = UUID.randomUUID();
        log.info("UUID：{}", uuid.toString());
    }

    /**
     * 时间戳UUID测试
     */
    @Test
    void timestampTest() {
        long time = System.currentTimeMillis();
        int random = (int) (Math.random() * Integer.MAX_VALUE);
        UUID uuid = new UUID(time, random);
        log.info("UUID：{}", uuid.toString());
    }
}
