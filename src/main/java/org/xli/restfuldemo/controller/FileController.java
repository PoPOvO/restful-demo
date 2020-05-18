package org.xli.restfuldemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xli.restfuldemo.config.ResponseResult;
import org.xli.restfuldemo.exception.GlobalException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author xieli
 * @Description
 * @Date 创建于 2020/2/16 2:45
 */
@RestController
@RequestMapping("/api/file/")
public class FileController {
    @GetMapping(path = "download")
    public void fileDownload(HttpServletResponse httpServletResponse) throws Exception {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/手机.xlsx");
        if (!file.exists()) {
            throw new GlobalException("文件不存在", -1000);
        }
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             ServletOutputStream sos = httpServletResponse.getOutputStream();) {
            //二进制文件流形式
            httpServletResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
            //设置文件的下载方式
            httpServletResponse.addHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("utf-8"), "iso-8859-1"));
            byte[] buffer = new byte[1 << 10];
            int readLen = 0;
            while ((readLen = bis.read(buffer, 0, buffer.length)) > 0) {
                sos.write(buffer, 0, readLen);
            }
        } catch (Exception e) {
            throw new GlobalException("下载失败", -1000);
        }
    }
}
