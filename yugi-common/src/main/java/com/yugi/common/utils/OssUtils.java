package com.yugi.common.utils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.*;
import com.yugi.common.consts.OssConsts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * OSS工具类
 *
 * @author clnzbqll
 * @since 2024-03-10 08:40:22
 */
@Slf4j
public class OssUtils {
    /**
     * OSS客户端
     */
    private static OSSClient ossClient;

    static{
        try{
            ClientConfiguration conf = new ClientConfiguration();
            // 允许打开的最大HTTP连接数
            conf.setMaxConnections(100);
            // 建立连接的超时时间
            conf.setConnectionTimeout(5000);
            // Socket层传输数据的超时时间
            conf.setSocketTimeout(2000);
            ossClient = new OSSClient(OssConsts.ENDPOINT, OssConsts.KEY, OssConsts.SECRET, conf);
            log.info("OSS客户端构建成功");
        } catch (Exception e){
            log.error("OSS客户端构建失败");
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 上传文件
     *
     * @param file 文件
     * @param filePath 上传路径
     * @param open 是否公共访问（true：公共 false：私有）
     * @throws IOException
     */
    public static void upload(MultipartFile file, String filePath, boolean open) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setCacheControl("no-cache");
        metadata.setContentEncoding(StandardCharsets.UTF_8.toString());
        metadata.setContentType(file.getContentType());
        metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        PutObjectRequest putObjectRequest = new PutObjectRequest(OssConsts.BUCKET,
                filePath,
                file.getInputStream(),
                metadata);
        if (!open) {
            metadata.setObjectAcl(CannedAccessControlList.Private);
        }
        putObjectRequest.setMetadata(metadata);
        ossClient.putObject(putObjectRequest);
    }

    /**
     * 下载文件
     *
     * @param response http响应
     * @param fileName 文件名
     * @param path     oss文件路径
     */
    public static void download(HttpServletResponse response, String fileName, String path) {
        OSSObject ossObject = ossClient.getObject(OssConsts.BUCKET, path);
        try(InputStream inputStream = ossObject.getObjectContent()){
            byte[] data = IOUtils.toByteArray(inputStream);
            response.reset();
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.name()).replaceAll("\\+", "%20");
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
            response.addHeader("Content-Length", "" + data.length);
            response.setContentType("application/octet-stream; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            IOUtils.write(data, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 下载输入流
     *
     * @param path oss文件路径
     * @return 文件输入流
     */
    public static InputStream getInputStream(String path) {
        OSSObject ossObject = ossClient.getObject(OssConsts.BUCKET, path);
        InputStream inputStream = ossObject.getObjectContent();
        return inputStream;
    }

    /**
     * 下载字节流
     *
     * @param path oss文件路径
     * @return 字节数据
     */
    public static byte[] getByte(String path) {
        try(InputStream inputStream = getInputStream(path)) {
            byte[] data = IOUtils.toByteArray(inputStream);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 删除文件
     *
     * @param path oss文件路径
     */
    public static void delete(String path) {
        try {
            ossClient.deleteObject(OssConsts.BUCKET, path);
        } catch (Exception e) {
            log.info("文件删除失败");
            e.printStackTrace();
        }
    }
}
