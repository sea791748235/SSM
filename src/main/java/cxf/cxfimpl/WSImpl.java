/**
 * FileName:    WSImpl
 * Author:      sealllsea
 * Date:        2018/7/23 15:20
 * Description:
 */
package cxf.cxfimpl;

import com.github.pagehelper.PageHelper;
import cxf.WS;
import mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import po.Actor;
import poi.WriteExcel;
import service.ActorService;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "cxf.WS")
public class WSImpl implements WS {

    @Resource
    public ActorService actorService;

    @Override
    public Actor getActorByid(short id) {
        Actor a=actorService.getActorByid(id);
        return a;
    }

    @Override
    public Actor updateactor(Actor a) {
        actorService.updateactor(a);
        return a;
    }

    @Override
    public String say( String str){
        return "Hello:"+str;
    }


    @Override
    public List<Actor> getpageActors( int pagenum,  int pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Actor> l=actorService.getpageActors(pagenum, pagesize);
        return l;
    }

    @Override
    public int getactornum() {
        int i=actorService.getactornum();
        return i;
    }

    @Override
    public Actor addactor(Actor a) {
        actorService.addactor(a);
        return a;
    }

    @Override
    public void delete(short id) {
        actorService.delete(id);
    }

}
