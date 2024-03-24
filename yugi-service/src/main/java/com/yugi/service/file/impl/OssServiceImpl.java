package com.yugi.service.file.impl;

import com.yugi.common.consts.DateFormat;
import com.yugi.common.consts.OssConsts;
import com.yugi.common.consts.Symbol;
import com.yugi.common.exception.YugiException;
import com.yugi.common.utils.DateUtils;
import com.yugi.common.utils.OssUtils;
import com.yugi.model.file.entity.File;
import com.yugi.service.file.IOssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Oss文件存储服务接口实现类
 *
 * @author clnzbqll
 * @since 2024-03-10 05:13:04
 */
@Service
@Slf4j
public class OssServiceImpl implements IOssService {
    /**
     * 上传文件
     */
    @Override
    public File upload(MultipartFile multipartFile) {
        String name = multipartFile.getOriginalFilename();
        String postfix = Symbol.DOT + StringUtils.getFilenameExtension(name) ;
        String path = this.getFilepath(postfix);
        String url = OssConsts.BUCKET_URL + path;
        Long size = multipartFile.getSize();
        try {
            OssUtils.upload(multipartFile, path, true);
            log.info("文件上传成功：{}", url);
        } catch (Exception e) {
            log.error("文件上传失败：{}", e.getMessage(), e);
            throw new YugiException("文件上传失败");
        }
        return new File(name, postfix, path, url, size);
    }

    /**
     * 生成文件路径
     */
    private String getFilepath(String postfix) {
        String uuid = UUID.randomUUID().toString();
        String datePath = DateUtils.parseDate(DateFormat.YYYY_MM_DD, LocalDateTime.now());
        return OssConsts.APP_NAME
                + Symbol.SLASH
                + datePath
                + Symbol.SLASH
                + uuid
                + postfix;
    }
}
