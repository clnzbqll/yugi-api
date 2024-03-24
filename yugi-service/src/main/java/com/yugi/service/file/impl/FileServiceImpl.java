package com.yugi.service.file.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yugi.common.entity.base.Table;
import com.yugi.common.utils.MapperUtils;
import com.yugi.common.utils.OssUtils;
import com.yugi.model.file.entity.File;
import com.yugi.model.file.entity.dto.FileEditDto;
import com.yugi.model.file.entity.query.FilePageQuery;
import com.yugi.model.file.entity.vo.FilePageVo;
import com.yugi.model.file.enums.FileType;
import com.yugi.model.file.mapper.FileMapper;
import com.yugi.service.file.IFileService;
import com.yugi.service.file.IOssService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 文件服务实现类
 *
 * @author clnzbqll
 * @since 2024-03-10 14:55:31
 */
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {
    @Resource
    private FileMapper fileMapper;
    @Resource
    private IOssService ossService;

    /**
     * 上传文件
     */
    @Override
    public void upload(MultipartFile file, FileType type) {
        File entity = ossService.upload(file);
        entity.setType(type);
        this.save(entity);
    }

    /**
     * 下载文件
     */
    @Override
    public void download(HttpServletResponse response, Long id) {
        File file = this.getById(id);
        OssUtils.download(response, file.getName(), file.getPath());
    }

    /**
     * 分页查询
     */
    @Override
    public Table<FilePageVo> page(FilePageQuery query) {
        Page<Object> page = PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<FilePageVo> list = fileMapper.page(query);
        Table<FilePageVo> table = new Table<>(page.getTotal(), list);
        return table;
    }

    /**
     * 修改文件
     */
    @Override
    public boolean edit(FileEditDto editDto) {
        File file = MapperUtils.INSTANCE.map(File.class, editDto);
        return this.updateById(file);
    }
}

