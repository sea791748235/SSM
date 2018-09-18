/**
 * FileName:    FileServiceImpl
 * Author:      sealllsea
 * Date:        2018/9/13 9:33
 * Description:
 */
package service.impl;

import cn.hutool.core.io.FileUtil;
import org.springframework.stereotype.Service;
import po.File;
import service.FileService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public List<File> getFileList(HttpServletRequest request) {
        String targetDir = request.getSession().getServletContext().getRealPath("uploadfiles");
        java.io.File[] files = FileUtil.ls(targetDir);
        List<File> fileList=new ArrayList<>();
        int id=0;
        for (java.io.File file: files) {
            //System.out.println(file.getName());
            id++;
            int size=(int)(file.length()/1024)+1;
            Date date=new Date(file.lastModified());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            fileList.add(new File(String.valueOf(id),file.getName(), String.valueOf(size),file.getPath(),String.valueOf(sdf.format(date))));
        }
        return fileList;
    }
}
