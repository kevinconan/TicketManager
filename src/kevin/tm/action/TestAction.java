package kevin.tm.action;

import java.util.List;

import kevin.tm.dao.BusMapper;
import kevin.tm.model.Bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope("request")
@Controller("testAction")
public class TestAction extends BaseAction<Object> {
    @Autowired
    private BusMapper busMapper;

    private Bus bus;

    public Bus getBus() {
	return this.bus;
    }

    public void setBus(Bus bus) {
	this.bus = bus;
    }

    private List<Bus> busList;

    public List<Bus> getBusList() {
	return this.busList;
    }

    public void setBusList(List<Bus> busList) {
	this.busList = busList;
    }

    public String test() {
	this.busList = this.busMapper.getAll();
	return LIST;
    }
}
