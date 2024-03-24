package com.yugi.model.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yugi.model.file.entity.File;
import com.yugi.model.file.entity.query.FilePageQuery;
import com.yugi.model.file.entity.vo.FilePageVo;
import java.util.List;

/**
 * 文件数据库访问层
 *
 * @author clnzbqll
 * @since 2024-03-10 14:55:31
 */
public interface FileMapper extends BaseMapper<File> {
    /**
     * 分页查询
     */
    List<FilePageVo> page(FilePageQuery query);
}

