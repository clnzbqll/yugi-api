package com.example.yugi.common.entity.base;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 基础字段类
 *
 * @author jia
 * @since 2023-06-27 12:00:41
 */
@Getter
@Setter
public class Field {
    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Boolean isDeleted;
}
