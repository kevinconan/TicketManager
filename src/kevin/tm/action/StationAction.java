package kevin.tm.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import kevin.tm.dao.ext.StationBeanExtMapper;
import kevin.tm.model.StationBean;
import kevin.tm.service.StationService;
@Scope("request")
@Controller("stationAction")
public class StationAction extends BaseAction<StationBean> {

	@Autowired
	private StationService stationService;
	
	public String testFindByName(){
		System.out.println(stationService.findByName("aa"));
		return SUCCESS;
	}
}
