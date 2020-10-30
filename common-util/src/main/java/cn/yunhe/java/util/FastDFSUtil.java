package cn.yunhe.java.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.File;

public class FastDFSUtil {
    private static final Logger logger = LogManager.getLogger(FastDFSUtil.class);

    public static String  conf_filename ="fastdfs-client.properties";
  //http://192.168.50.21/group1/M00/00/00/wKgyFV9I2k2AFDYxAACjER2czOk321.jpg
    public static String uploadFile(String groupName, byte[] fileBuff, String fileExtName, NameValuePair[] metaList){
        try {
            ClientGlobal.initByProperties(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getTrackerServer();

            StorageClient1 client = new StorageClient1(trackerServer);

            StorageServer storageServer = tracker.getStoreStorage(trackerServer, groupName);

            String storageHost="";
            if (storageServer == null) {
               // System.err.println("get store storage servers fail, error code: " + tracker.getErrorCode());
                logger.debug("get store storage servers fail, error code: " + tracker.getErrorCode());
            } else {
                storageHost=  storageServer.getInetSocketAddress().getAddress().getHostAddress();
            }
            String  fileId = client.upload_file1(groupName,fileBuff,fileExtName,metaList);
            String rtnStr = storageHost+"#"+fileId;
            return rtnStr;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  null;
    }
}
