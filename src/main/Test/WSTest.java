import cn.hutool.core.io.FileUtil;
import cxf.WS;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;
import po.Actor;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * FileName:    WSTest
 * Author:      sealllsea
 * Date:        2018/7/24 13:45
 * Description:
 */

public class WSTest {
    @Test
    public void test(){
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(WS.class);
        factoryBean.setAddress("http://192.168.30.128:17033/cxf/WSImpl?wsdl");
        WS ws=(WS)factoryBean.create();
        List<Actor> list=ws.getpageActors(10,10);

        System.out.println("++++++++++++++++++");
        System.out.println(list);
    }
    @Test
    public void fileUtilTest(HttpServletRequest request){
        String targetDir = request.getSession().getServletContext().getRealPath("uploadfiles");
//        File[] files= FileUtil.ls("E://develop_software/git/java/shenzhanwang_SSM/SSM/target/SSM/uploadfiles");
        File[] files= FileUtil.ls(targetDir);
        for (File file:files) {
            System.out.println(file.getName());
        }
    }
}
