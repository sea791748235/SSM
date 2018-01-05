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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import pagemodel.ActorGrid;
import po.Actor;
import service.ActorService;

@Controller
public class ActorController {
	private static Logger log = LogManager.getLogger(ActorController.class.getName());
	
	@Autowired
	private ActorService actorservice;
	
	@RequestMapping(value="/actorlist",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public ActorGrid getactorlist(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
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
	
	@RequestMapping(value="/actorlistxml",produces = {"application/xml;charset=UTF-8"})
	@ResponseBody
	public ActorGrid getactorlistxml(@RequestParam("current") int current,@RequestParam("rowCount") int rowCount){
		int total=actorservice.getactornum();
		List<Actor> list=actorservice.getpageActors(current,rowCount);
		ActorGrid grid=new ActorGrid();
		grid.setCurrent(current);
		grid.setRowCount(rowCount);
		grid.setRows(list);
		grid.setTotal(total);
		return grid;
	}
	
	
	@RequestMapping("/showactor")
	public String showactor(){
		return "/html/showactor.html";
	}
	
	@RequestMapping(value="/updateactor",method = RequestMethod.POST)
	@ResponseBody
	public Actor updateactor(@ModelAttribute Actor a){
		Actor actor=actorservice.updateactor(a);
		return actor;
	}
	
	@RequestMapping(value="/getActorInfo")
	@ResponseBody
	public Actor getactorbyid(@RequestParam("id") short id){
		Actor a=actorservice.getActorByid(id);
		return a;
	}
	
	@RequestMapping(value="/addactor",method = RequestMethod.POST)
	@ResponseBody
	public Actor add(@ModelAttribute Actor a){
		Actor actor=actorservice.addactor(a);
		return actor;
	}
	
	@RequestMapping(value="/deleteactor")
	public String delete(@RequestParam("id") short id){
		actorservice.delete(id);
		return "/html/showactor.html";
	}
	
	@RequestMapping("/exportactor")
	public void export(HttpServletResponse response) throws Exception{
		InputStream is=actorservice.getInputStream();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
		ServletOutputStream output = response.getOutputStream();
		IOUtils.copy(is, output);
	}
	
}
