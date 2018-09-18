/**
 * FileName:    WS
 * Author:      sealllsea
 * Date:        2018/7/23 15:20
 * Description:
 */
package cxf;

import po.Actor;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.io.InputStream;
import java.util.List;

@WebService
public interface WS {

    List<Actor> getpageActors(int pagenum,int pagesize);


    String say(String str);

    int getactornum();


    Actor getActorByid( short id);


    Actor updateactor( Actor a);

    Actor addactor( Actor a);

    void delete( short id);

}
