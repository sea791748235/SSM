/**
 * FileName:    FileDownloadController
 * Author:      sealllsea
 * Date:        2018/7/27 13:16
 * Description:
 */
package controller;

import cn.hutool.core.io.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Api(tags="下载文件接口")
public class FileDownloadController {

    private static Logger log = LogManager.getLogger(FileDownloadController.class.getName());

    @ApiOperation("获取文件列表")
    @RequestMapping(value = "/files")
    @ResponseBody
    public void getFileList(HttpServletRequest request){
        String targetDir = request.getSession().getServletContext().getRealPath("uploadfiles");
        File[] files = FileUtil.ls(targetDir);
        for (File file: files) {
            System.out.println(file.getName());
        }

    }

//		System.out.println("*******************"));
}
