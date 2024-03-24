package com.yugi.service.file;

import com.yugi.model.file.entity.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * Oss文件存储服务接口
 *
 * @author clnzbqll
 * @since 2024-03-10 05:10:46
 */
public interface IOssService {
    /**
     * 上传文件
     */
    File upload(MultipartFile multipartFile);
}
