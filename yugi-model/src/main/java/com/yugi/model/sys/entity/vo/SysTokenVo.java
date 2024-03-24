package com.yugi.model.sys.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


/**
 * 系统token视图对象
 *
 * @author clnzbqll
 * @since 2024-03-09 06:31:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysTokenVo implements Serializable {
    /**
     * token
     */
    private String token;
}
