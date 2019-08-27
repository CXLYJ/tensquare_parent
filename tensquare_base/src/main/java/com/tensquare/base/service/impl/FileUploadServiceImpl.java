package com.tensquare.base.service.impl;

import com.tensquare.base.service.FileUploadService;
import com.tensquare.base.vo.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/27
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    /**
     * 文件可上传类型如：zip,只校验当前上传的文件后缀对压缩文件内的信息不做校验。
     */
    private List<String>  fileType;

    /**
     * 文件上传最大值，每种类型的文件可以设置不同的最大值
     */
    private Map<String,Long> fileMaxSizes ;

    //标志是否已判断文件夹创建过
    private  boolean hasMkdir;

    /**
     * ZIP文件存放基础路径
     */
    private String zipFileBasePath;


    @Override
    public FileUpload validateFile(MultipartFile zipFile, String policyNo) {

        if ("".equals(policyNo) || policyNo == null){
            logger.warn("保单号不能为空");
            return new FileUpload(false, "保单号不能为空！");
        }
        FileUpload fileUpload = this.checkFile(zipFile);
        return fileUpload;
    }

    private FileUpload checkFile(MultipartFile zipFile) {
       if (zipFile == null){
           logger.warn("上传文件为空");
           return new FileUpload(false, "上传文件为空");
       }
       String fileName = zipFile.getOriginalFilename();
       Long fileSize = zipFile.getSize();
       logger.info("当前的文件名：{}, 文件大小：{}", new Object[]{fileName, fileSize});
        if(fileName.indexOf(".")==0){
            logger.warn("当前上传的文件类型不符，无扩展名,{}",fileName);
            return new FileUpload(false,"当前上传的文件类型不符，无扩展名！");
        }

        String ext = this.getFileExt(fileName);
        if (!fileType.contains(ext)){
            logger.warn("当前上传的文件类型不允许,{}",fileName);
            return new FileUpload(false,"当前上传的文件类型不允许！");
        }
        Long fileMaxSize = fileMaxSizes.get(ext);

        if(fileSize>fileMaxSize){
            logger.warn("当前上传的文件类型为：{}，大小为：{}，超过最大限制:{}",new Object[]{ext,fileSize,fileMaxSize});
            return new FileUpload(false,"当前上传的文件大小为："+fileSize+"，超过最大限制:"+fileMaxSize);
        }
        return null;
    }

    /**
     * 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名
     * @param fileName
     * @return
     */
    private String getFileExt(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        ext = ext.toLowerCase();
        return ext;
    }

    /**
     * 获取zip文件解压存放路径
     * @return
     */
    @Override
    public String getExportFilePath() {
        if(!hasMkdir){
            File file = new File(zipFileBasePath);
            if (!file.exists()) {
                if (!file.mkdir()){
                    throw new RuntimeException("当前文件夹无法创建" + zipFileBasePath);
                }
            }
            hasMkdir = true;
        }
        return zipFileBasePath;
    }

    public void setFileType(List<String> fileType) {
        this.fileType = fileType;
    }

    public void setFileMaxSizes(Map<String, Long> fileMaxSizes) {
        this.fileMaxSizes = fileMaxSizes;
    }

    public void setHasMkdir(boolean hasMkdir) {
        this.hasMkdir = hasMkdir;
    }

    public void setZipFileBasePath(String zipFileBasePath) {
        this.zipFileBasePath = zipFileBasePath;
    }
}
