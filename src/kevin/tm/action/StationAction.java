package kevin.tm.action;

import kevin.tm.dao.model.StationBean;
import kevin.tm.service.StationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("request")
@Controller("stationAction")
public class StationAction extends BaseAction<StationBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 3311756013782353554L;
    @Autowired
    private StationService stationService;

    public String testFindByName() {
	System.out.println(this.stationService.findByName("aa"));
	return SUCCESS;
    }
}
