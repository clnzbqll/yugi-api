package com.yugi.model.file.entity.query;

import com.yugi.common.entity.base.Query;
import com.yugi.model.file.enums.FileType;
import lombok.Data;

/**
 * 文件分页查询条件
 *
 * @author clnzbqll
 * @since 2024-03-16 10:09:44
 */
@Data
public class FilePageQuery extends Query {
    // 文件名称
    private String name;
    // 文件类型
    private FileType type;
}
