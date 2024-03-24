package com.yugi.model.file.entity.vo;

import com.yugi.model.file.enums.FileType;
import lombok.Data;

/**
 * 文件分页查询试图对象
 *
 * @author clnzbqll
 * @since 2024-03-16 10:10:39
 */
@Data
public class FilePageVo {
    private Long id;
    //文件名称
    private String name;
    // 文件后最
    private String postfix;
    // 文件路径
    private String path;
    //文件类型
    private FileType type;
    //文件路
    private String url;
    //文件大小
    private Long size;
}
