/**
 * FileName:    TestController
 * Author:      sealllsea
 * Date:        2018/9/5 16:42
 * Description:
 */
package controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import po.Actor;
import po.Film;
import po.T_progress;
import service.ActorService;
import service.FilmService;
import service.T_progressService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class TestController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private T_progressService t_progressService;

    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    @ResponseBody
    public List<T_progress> selectAll(){
        return t_progressService.selectAll();
    }

    @RequestMapping(value = "/indexTest1",method = RequestMethod.GET)
    public String indexTest1(){
        return "/template/AdminLTE-2.3.11/pages/tables/data.html";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "/html/simpleTest.html";
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(){

        //request.setAttribute("data",sdf.format(date));
        return "/html/test2.html";
    }

    @RequestMapping(value = "/testInput",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> testInput(HttpServletRequest request){
        //Date date=new Date();
        //SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        String aaa=request.getParameter("input");
        Map<String,String> map=new HashMap();
        //map.put("data",sdf.format(date));
        map.put("data",aaa);
        return map;
    }

    @RequestMapping(value = "/testList",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,String>> testList(){
        Map<String,String> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        List<Map<String,String>> list=new ArrayList<>();
        map1.put("a","111");
        map2.put("b","222");
        list.add(map1);
        list.add(map2);
        return list;
    }

    @RequestMapping(value = "/testAllActors",method = RequestMethod.POST)
    @ResponseBody
    public List<Actor> testAllActors(){
        return actorService.getAllActors();
    }

    @RequestMapping(value = "/filmList",method = RequestMethod.POST)
    @ResponseBody
    public List<Film> getAllFilm(){
        //DataSourceHolder.setDataSources("ds_oracle");
        List<Film> list=filmService.getAllFilm();
        return list;
    }


    //@RequestMapping(value = "")



//    @RequestMapping(value = "/test3",method = RequestMethod.GET)
//    //@ResponseBody
//    public String test3(HttpServletRequest request,HttpServletResponse response){
//        //String data=request.getParameter("data");
//        //Date date=new Date();
//        //SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
//        //Map pMap=new HashMap();
//        //pMap.put("data",sdf.format(date));
//        //response.getWriter().write();
//    }
}
