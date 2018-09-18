/**
 * FileName:    File
 * Author:      sealllsea
 * Date:        2018/8/15 16:59
 * Description:
 */
package po;

public class File {
    private String id;
    private String fileName;
    private String fileSize;
    private String filePath;
    private String uploadTime;

    public File(String id,String fileName,String fileSize,String filePath,String uploadTime){
        this.id=id;
        this.fileName=fileName;
        this.fileSize=fileSize;
        this.filePath=filePath;
        this.uploadTime=uploadTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }
}
