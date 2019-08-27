package com.tensquare.base.service;

import com.tensquare.base.vo.FileUpload;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/27
 */
public interface FileUploadService {

    public FileUpload validateFile(MultipartFile zipFile, String policyNo);

    String getExportFilePath();
}
