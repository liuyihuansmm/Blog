package org.cn.lyh.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LYH on 2017-3-27.
 */
public class Upload {


    private HttpServletRequest request;



    public void upload(){
        boolean isMultipart = ServletFileUpload.isMultipartContent(this.request);
        if (!isMultipart) {
            //未包含文件上传域
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(20*1024); //设置内存中允许存储的字节数
        factory.setRepository(factory.getRepository()); //设置存放临时文件的目录

        ServletFileUpload upload = new ServletFileUpload(factory);

        int size = 20*1024*1024; //设置上传文件的大小
        List formLists = null;

        try {
            formLists = upload.parseRequest(this.request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        Iterator it = formLists.iterator();
        while (it.hasNext()){
            FileItem fileItem = (FileItem)it.next();
            //判断是否file表单
            if(!fileItem.isFormField()){
                String name = fileItem.getName();
                if(fileItem.getSize()>size){
                    //上传文件大于规定的2M大小
                    break;
                }
                String adjustSize = new Long(fileItem.getSize()).toString();

                if(name == null||name.equals("")||adjustSize.equals("0")){
                    //上传文件为空
                    continue;
                }

                String justFileName = name.substring(name.lastIndexOf("\\")+1,name.length());
                File saveFile = new File("存放地址");

                try {
                    fileItem.write(saveFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
