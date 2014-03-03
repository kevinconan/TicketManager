/**
 * 
 */
package kevin.tm.action;

import java.util.List;

import kevin.tm.model.BusBean;
import kevin.tm.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 车辆信息请求处理Action
 * 
 * @author Kevin
 * 
 */
@Scope("request")
@Controller("busAction")
public class BusAction extends BaseAction<BusBean> {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    /**
     * 
     */
    private static final long serialVersionUID = 7621332210140934833L;
    @Autowired
=======
=======
>>>>>>> 1f37ac83c63ca5b88d9214b61a28f92a4f9578c4
=======
>>>>>>> 1f37ac83c63ca5b88d9214b61a28f92a4f9578c4
	
	private List<BusBean> busList;
    public List<BusBean> getBusList() {
		return busList;
	}

	public void setBusList(List<BusBean> busList) {
		this.busList = busList;
	}

	@Autowired
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1f37ac83c63ca5b88d9214b61a28f92a4f9578c4
=======
>>>>>>> 1f37ac83c63ca5b88d9214b61a28f92a4f9578c4
=======
>>>>>>> 1f37ac83c63ca5b88d9214b61a28f92a4f9578c4
    private BusService busService;

    public BusService getBusService() {
	return this.busService;
    }

    public void setBusService(BusService busService) {
	this.busService = busService;
    }
    /**
     * 
     * 添加BUS信息
     * @author Kevin
     * 
     * */
    public String Add(BusBean busBean){
    	if(busService.save(busBean)!=0){
    		message="0";
    		
    	}else{
    		message="1";
    	}
    	
    	return MESSAGE;
    }
    
    public String delete(String vehicleNo){
    	if(busService.deleteByVehicleNo(vehicleNo)!=0){
    		message="0";
    		
    	}else{
    		message="1";
    	}
    	
    	return MESSAGE;
    }
    
    public String update(BusBean busBean){
    	if(busService.update(busBean)!=0){
    		message="0";
    		
    	}else{
    		message="1";
    	}
    	
    	return MESSAGE;
    }
    
    public String list(){
    	setBusList(busService.findAll());
    	return LIST;
    }
    

}
