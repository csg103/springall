package com.csg.cn.sys.config;

import org.apache.log4j.Logger;
import org.csource.autoconfig.FastDFSProperties;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yichen
 * @description
 * @date 2018/6/4
 **/
@Component
public class FastDFSUploader {

    private static final Logger logger = Logger.getLogger(FastDFSUploader.class);

    public final String FILE_SERVER_DOMAIN = "http://cdnjiasu.balabalabiu.com/";

    @Autowired
    private TrackerClient trackerClient;

    @Autowired
    private FastDFSProperties fastDFSProperties;

    public String[] upload(byte[] input, String filename) {
        StorageServer storageServer = null;
        StorageClient1 client;
        String fileIds[] = null;

        try {
            TrackerServer trackerServer = trackerClient.getConnection();
            client = new StorageClient1(trackerServer, storageServer, fastDFSProperties);
            String fileNames[] = filename.split("\\.");
            String extName = "jpg";
            if (fileNames.length > 1){
                extName = fileNames[fileNames.length - 1];
            }

            fileIds = client.upload_file(input, extName, null);
        } catch (Exception e) {
            logger.error("上传失败", e);
        }
        return fileIds;
    }

    public void delete(String group, String path){
        StorageServer storageServer = null;
        StorageClient1 client;

        try {
            TrackerServer trackerServer = trackerClient.getConnection();
            client = new StorageClient1(trackerServer, storageServer, fastDFSProperties);
            client.delete_file(group, path);
        }catch (Exception e){
            logger.error("删除失败", e);
        }
    }

    public void deleteFile(String url){
        StorageServer storageServer = null;
        StorageClient1 client;

        try {
            TrackerServer trackerServer = trackerClient.getConnection();
            client = new StorageClient1(trackerServer, storageServer, fastDFSProperties);
            String  path= url.replace(FILE_SERVER_DOMAIN,"");
            client.delete_file("group1", path);
            logger.info("成功删除文件："+url);
        }catch (Exception e){
            logger.error("删除失败", e);
        }
    }
}
