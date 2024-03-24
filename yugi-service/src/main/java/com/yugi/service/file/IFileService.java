package com.yugi.service.file;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yugi.common.entity.base.Table;
import com.yugi.model.file.entity.File;
import com.yugi.model.file.entity.dto.FileEditDto;
import com.yugi.model.file.entity.query.FilePageQuery;
import com.yugi.model.file.entity.vo.FilePageVo;
import com.yugi.model.file.enums.FileType;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件服务接口
 *
 * @author clnzbqll
 * @since 2024-03-10 14:55:31
 */
public interface IFileService extends IService<File> {
    /**
     * 上传文件
     */
    void upload(MultipartFile file, FileType type);

    /**
     * 下载文件
     */
    void download(HttpServletResponse response, Long id);

    /**
     * 分页查询
     */
    Table<FilePageVo> page(FilePageQuery query);

    /**
     * 修改文件
     */
    boolean edit(FileEditDto editDto);
}

