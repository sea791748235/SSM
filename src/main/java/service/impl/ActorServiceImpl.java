package service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import mapper.ActorMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import po.Actor;
import poi.WriteExcel;
import service.ActorService;
import web.DataSourceHolder;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "service.ActorService")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=5)
@Service

public class ActorServiceImpl implements ActorService{
	@Autowired
	public ActorMapper actorMapper;

	public List<Actor> getAllActors(){
        DataSourceHolder.setDataSources("ds_mysql");
		List<Actor> list=actorMapper.getAllactors();
		return list;
	}

	public Actor getActorByid(short id) {
        DataSourceHolder.setDataSources("ds_mysql");
		Actor a=actorMapper.getactorbyid(id);
		return a;
	}

	public Actor updateactor(Actor a) {
        DataSourceHolder.setDataSources("ds_mysql");
		actorMapper.updateActorbyid(a);
		return a;
	}

	public List<Actor> getpageActors(int pagenum, int pagesize) {
        DataSourceHolder.setDataSources("ds_mysql");
		PageHelper.startPage(pagenum,pagesize);  
		List<Actor> l=actorMapper.getAllactors();
		return l;
	}

	public int getactornum() {
        DataSourceHolder.setDataSources("ds_mysql");
		List<Actor> l=actorMapper.getAllactors();
		return l.size();
	}

	public Actor addactor(Actor a) {
        DataSourceHolder.setDataSources("ds_mysql");
		actorMapper.insertActor(a);
		return a;
	}

	public void delete(short id) {
        DataSourceHolder.setDataSources("ds_mysql");
		actorMapper.delete(id);
	}

	public InputStream getInputStream() throws Exception {
        DataSourceHolder.setDataSources("ds_mysql");
		String[] title=new String[]{"id","first_name","last_name","last_update"};
		List<Actor> plist=actorMapper.getAllactors();
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		for(int i=0;i<plist.size();i++){
			Object[] obj=new Object[4];
			obj[0]=plist.get(i).getId();
			obj[1]=plist.get(i).getFirst_name();
			obj[2]=plist.get(i).getLast_name();
			obj[3]=plist.get(i).getLast_update();
			dataList.add(obj);
		}
		WriteExcel ex = new WriteExcel(title, dataList);  
		InputStream in;
		in = ex.export();
		return in;
	}
}
