package kevin.tm.action;

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

    public String test() {
	this.bus = this.busMapper.getById("1");
	return MESSAGE;
    }
}
