/**
 * FileName:    FileServiceImpl
 * Author:      sealllsea
 * Date:        2018/9/3 9:57
 * Description:
 */
package service;

import po.File;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface FileService {
    List<File> getFileList(HttpServletRequest request);
}
