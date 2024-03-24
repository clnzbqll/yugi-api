package com.yugi.model.file.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yugi.common.entity.base.Field;
import com.yugi.model.file.enums.FileType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件实体类
 *
 * @author clnzbqll
 * @since 2024-03-10 02:57:11
 */
@Data
@NoArgsConstructor
@SuppressWarnings("serial")
public class File extends Field {
    //主键id
    @TableId(type = IdType.AUTO)
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

    /**
     * 构造函数
     *
     * @param name 文件名
     * @param url  文件路径
     */
    public File(String name, String postfix, String path, String url, Long size) {
        this.name = name;
        this.postfix = postfix;
        this.path = path;
        this.url = url;
        this.size = size;
    }
}

