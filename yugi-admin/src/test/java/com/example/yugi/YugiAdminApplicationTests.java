package com.example.yugi;

import com.example.yugi.model.sys.entity.domain.SysDictType;
import com.example.yugi.service.sys.SysDictTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;

/**
 * Yugi测试类
 *
 * @author jia
 * @since 2023-06-23 09:46:28
 */
@SpringBootTest(classes = {YugiAdminApplication.class})//测试类需要指定启动类
class YugiAdminApplicationTests {
    /**
     * 服务对象
     */
    @Resource
    private SysDictTypeService sysDictTypeService;

    @Test
    void contextLoads() {
        List<SysDictType> list = sysDictTypeService.list();
        System.out.println(list);
    }
}