package com.tensquare.base.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：lyj
 * @email: : iclyj@iclyj.cn
 * @date ：2019/8/27
 *
 * 文件上传返回对象，用于解析成JSON格式返回前端
 */
@Data
@NoArgsConstructor
public class FileUpload {

    //状态
    private  boolean status;
    //错误信息
    private String errorMsg;

    //文件保存成功后的文件Id
    private String fileId;

    //文件存放路径
    private String filePath;

     public FileUpload(Boolean status, String errorMsg){
         super();
         this.status = status;
         this.errorMsg = errorMsg;
     }
}
