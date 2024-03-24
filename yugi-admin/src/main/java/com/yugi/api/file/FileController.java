package com.yugi.api.file;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.yugi.common.entity.base.Result;
import com.yugi.common.entity.base.Table;
import com.yugi.model.file.entity.File;
import com.yugi.model.file.entity.dto.FileEditDto;
import com.yugi.model.file.entity.query.FilePageQuery;
import com.yugi.model.file.entity.vo.FilePageVo;
import com.yugi.model.file.enums.FileType;
import com.yugi.service.file.IFileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * 文件控制层
 *
 * @author clnzbqll
 * @since 2024-03-10 04:33:58
 */
@RestController
@RequestMapping("/file")
public class FileController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private IFileService fileService;

    /**
     * 上传文件
     *
     * @param file 文件
     * @param type 文件类型
     * @return 上传结果
     */
    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file,
                    @RequestParam("type") FileType type){
        fileService.upload(file, type);
        return success(null);
    }

    /**
     * 下载文件
     *
     * @param response http相应
     * @param id 文件id
     * @throws IOException
     */
    @GetMapping("/download/{id}")
    public void download(HttpServletResponse response, @PathVariable("id") Long id) throws IOException {
        fileService.download(response, id);
    }

    /**
     * 分页查询
     *
     * @param query 查询条件
     * @return 查询数据
     */
    @GetMapping("/page")
    public Result<Table<FilePageVo>> page(FilePageQuery query) {
        Table<FilePageVo> table = fileService.page(query);
        return Result.success(table);
    }

    /**
     * id查询
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Result<File> find(@PathVariable Serializable id) {
        return Result.success(fileService.getById(id));
    }

    /**
     * 修改文件
     *
     * @param editDto 实体对象
     * @return 修改结果
     */
    @PutMapping
    public Result edit(@RequestBody FileEditDto editDto) {
        return Result.isOk(fileService.edit(editDto));
    }

    /**
     * 删除文件
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/{idList}")
    public Result delete(@PathVariable("idList") List<Long> idList) {
        return Result.isOk(fileService.removeByIds(idList));
    }
}

