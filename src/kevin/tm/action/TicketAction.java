/**
 * 
 */
package kevin.tm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kevin.tm.dao.model.TicketBean;
import kevin.tm.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("ticketAction")
public class TicketAction extends BaseAction<TicketBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 7774461859613142522L;

    @Autowired
    private TicketService service;

    private String createTicketBeans;
    private String updateTicketBeans;
    private String deleteTicketBeans;

    public String add() {
	List<Integer> list = new ArrayList<>();
	TicketBean[] beans = GSON.fromJson(
		this.createTicketBeans.replaceAll("\"\"", "null"),
		TicketBean[].class);

	for (TicketBean bean : beans) {
	    if (this.service.save(bean) == 0) {
		list.add(bean.getTicketid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String update() {
	List<Integer> list = new ArrayList<>();
	TicketBean[] beans = GSON.fromJson(
		this.updateTicketBeans.replaceAll("\"\"", "null"),
		TicketBean[].class);

	for (TicketBean bean : beans) {
	    if (this.service.update(bean) == 0) {
		list.add(bean.getTicketid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String delete() {
	List<Integer> list = new ArrayList<>();
	TicketBean[] beans = GSON.fromJson(
		this.deleteTicketBeans.replaceAll("\"\"", "null"),
		TicketBean[].class);

	for (TicketBean bean : beans) {
	    if (this.service.delete(bean) == 0) {
		list.add(bean.getTicketid());
	    }
	}

	this.map = new HashMap<String, Object>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String list() {
	this.list = this.service.findByPage(this.start, this.limit);

	this.map = new HashMap<>();
	this.map.put(TOTAL_COUNT, this.service.totalCount());
	this.map.put(DATA, this.list);
	return MAP;
    }

    public String listAll() {
	this.list = this.service.findAll();
	return LIST;
    }

    public String getByIds() {
	this.list = new ArrayList<>();
	Object[] objects = GSON.fromJson(this.message, Object[].class);
	for (Object object : objects) {
	    this.list.add(this.service.findById((int) Double.parseDouble(object
		    .toString())));
	}

	this.map = new HashMap<>();
	this.map.put(SUCCESS, true);
	this.map.put(DATA, this.list);
	return MAP;
    }

    public String getById() {
	Object object = GSON.fromJson(this.message, Object.class);
	TicketBean bean = this.service.findById((int) Double.parseDouble(object
		.toString()));

	this.map = new HashMap<>();
	this.map.put(SUCCESS, true);
	this.map.put(DATA, bean);
	return MAP;
    }

    public String remainSeat(){
    	System.out.println(message);
    	int remainSeat = this.service.countRemainSeatBySchid(Integer.parseInt(message));
    	this.map = new HashMap<>();
    	this.map.put(SUCCESS, true);
    	this.map.put(DATA, remainSeat);
    	return MAP;
    	
    }
    public String getCreateTicketBeans() {
	return this.createTicketBeans;
    }

    public void setCreateTicketBeans(String createTicketBeans) {
	this.createTicketBeans = createTicketBeans;
    }

    public String getUpdateTicketBeans() {
	return this.updateTicketBeans;
    }

    public void setUpdateTicketBeans(String updateTicketBeans) {
	this.updateTicketBeans = updateTicketBeans;
    }

    public String getDeleteTicketBeans() {
	return this.deleteTicketBeans;
    }

    public void setDeleteTicketBeans(String deleteTicketBeans) {
	this.deleteTicketBeans = deleteTicketBeans;
    }
    
}
