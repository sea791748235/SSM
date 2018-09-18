package controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pagemodel.ActorGrid;
import pagemodel.MSG;
import po.Actor;
import service.ActorService;
import web.DataSourceHolder;
import web.DynamicDataSource;

@Api(tags = "演员接口")
@Controller
public class ActorController {
	private static Logger log = LogManager.getLogger(ActorController.class.getName());
	
	@Autowired
	private ActorService actorservice;
	
	@ApiOperation("获取所有演员列表")
	@RequestMapping(value="/actors",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public ActorGrid listActors(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		DataSourceHolder.setDataSources("ds_mysql");
		log.info("aaa");
		log.error("bbb");
		int total=actorservice.getactornum();
		List<Actor> list=actorservice.getpageActors(current,rowCount);
		ActorGrid grid=new ActorGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}
	
	@ApiOperation("获取所有演员列表XML")
	@RequestMapping(value="/listActorsXml",produces = {"application/xml;charset=UTF-8"},method = RequestMethod.GET)
	@ResponseBody
	public ActorGrid listActorsXml(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		DataSourceHolder.setDataSources("ds_mysql");
		int total=actorservice.getactornum();
		List<Actor> list=actorservice.getpageActors(current,rowCount);
		ActorGrid grid=new ActorGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}
	
	
	@RequestMapping(value="/showactor",method = RequestMethod.GET)
	public String showactor(){
		return "/html/showactor.html";
	}
	
	@ApiOperation("修改一个演员")
	@RequestMapping(value="/actors/{id}",method = RequestMethod.PUT,consumes="application/json")
	@ResponseBody
	public Actor updateactor(@PathVariable("id") short id, @RequestBody Actor a){
		DataSourceHolder.setDataSources("ds_mysql");
		Actor actor=actorservice.updateactor(a);
		return actor;
	}
	
	@ApiOperation("获取一个演员")
	@RequestMapping(value="/actors/{id}",method = RequestMethod.GET)
	@ResponseBody
	public MSG getactorbyid(@PathVariable("id") short id){
		DataSourceHolder.setDataSources("ds_mysql");
		Actor a=actorservice.getActorByid(id);
		return new MSG("200",a);
	}
	
	@ApiOperation("添加一个演员")
	@RequestMapping(value="/actors",method = RequestMethod.POST)
	@ResponseBody
	public Actor add(@RequestBody Actor a){
		DataSourceHolder.setDataSources("ds_mysql");
		Actor actor=actorservice.addactor(a);
		return actor;
	}
	
	@ApiOperation("删除一个演员")
	@RequestMapping(value="/actors/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") short id){
		DataSourceHolder.setDataSources("ds_mysql");
		actorservice.delete(id);
		return "/html/showactor.html";
	}
	
	@ApiOperation("把演员导出为Excel")
	@RequestMapping(value="/exportactor",method = RequestMethod.GET)
	public void export(HttpServletResponse response) throws Exception{
		DataSourceHolder.setDataSources("ds_mysql");
		InputStream is=actorservice.getInputStream();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(is, output);
	}
	
}
