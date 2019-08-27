package com.tensquare.base.contorller;

import com.tensquare.base.service.FileUploadService;
import com.tensquare.base.vo.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipFile;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/27
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {

    private  static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUploadService fileUploadService;

    public FileUpload uploadFile(ModelMap model,
                                 @RequestParam("file") MultipartFile zipFile,
                                 @RequestParam(defaultValue = "") String policyNo) throws Exception {
      long t1 = System.currentTimeMillis();
      //当前时间
      String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      logger.info("开始上传文件,当前时间：{} ", new Object[]{currentTime});
      FileUpload fileUpload =  fileUploadService.validateFile(zipFile, policyNo);

      Long fileSize = zipFile.getSize();

        if(fileUpload!=null){
            logger.info("上传文件失败：{}", fileUpload.getErrorMsg());
            return fileUpload;
        }else{
            fileUpload = new FileUpload(true,"上传解压成功!");
        }
        InputStream input = zipFile.getInputStream();
        try{
            String saveFilePath = this.fileUploadService.getExportFilePath();

            int count = ZIPUtil.unzipFilesToPathWithChecksum(input, saveFilePath);
            long t2 = System.currentTimeMillis();
            logger.info("结束上传文件,当前时间：{}, 保单号：{}, SN号:{}, 文件大小：{}, 总耗时：{}", new Object[]{currentTime, policyNo, snCode, fileSize, t2-t1});
            logger.info("保单号:{},共上传成功{}张图片",new Object[]{policyNo,count});
        }catch(Exception e){
            f = new FileUpload(false,"文件解压异常："+e.getMessage());
            logger.error("保单号:{},文件解压异常",policyNo,e);
        }
        return f;
    }

}
