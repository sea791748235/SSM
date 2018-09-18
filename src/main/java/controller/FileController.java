/**
 * FileName:    FileController
 * Author:      sealllsea
 * Date:        2018/9/3 9:47
 * Description:
 */
package controller;

import cn.hutool.core.io.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.File;
import service.FileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags = "文件接口")
@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/file",method = RequestMethod.GET)
    public String getFile(){
        return "/html/file.html";
    }

    //@ApiOperation("文件列表")
    @RequestMapping(value = "/fileList", method = RequestMethod.GET)
    @ResponseBody
    public List<File> getFileList(HttpServletRequest request) {
        return fileService.getFileList(request);
    }

    @ApiOperation("单个文件")
    @RequestMapping(value = "/fileOne", method = RequestMethod.GET)
    public Map getFileInfo(HttpServletRequest request, HttpServletResponse response){
         Map paramMap=new HashMap();
        paramMap.put("id","1");
        paramMap.put("fileName","aaa");
        paramMap.put("fileSize","321");
        paramMap.put("filePath","a/b/c");
        paramMap.put("uploadTime","1:0:0");
        return paramMap;
    }


}
