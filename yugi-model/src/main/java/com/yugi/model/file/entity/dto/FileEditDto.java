package com.yugi.model.file.entity.dto;

import lombok.Data;

/**
 * 文件编辑传输对象
 *
 * @author clnzbqll
 * @since 2024-03-16 11:06:31
 */
@Data
public class FileEditDto {
    //主键id
    private Long id;
    //文件名称
    private String name;
}
