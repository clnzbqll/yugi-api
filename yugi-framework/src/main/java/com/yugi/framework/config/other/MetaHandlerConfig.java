package com.yugi.framework.config.other;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.yugi.common.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Mybaits自动填充配置
 *
 * @author jia
 * @since 2023-07-25 13:57:07
 */
@Component
public class MetaHandlerConfig implements MetaObjectHandler {
    /**
     * 新增数据执行填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createBy", SecurityUtils.getUserId(), metaObject);
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
    }

    /**
     * 更新数据执行填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateBy", SecurityUtils.getUserId(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}