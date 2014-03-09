/**
 * 
 */
package kevin.tm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kevin.tm.dao.model.AdminBean;
import kevin.tm.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("adminAction")
public class AdminAction extends BaseAction<AdminBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 620953867973433096L;

    @Autowired
    private AdminService adminService;

    public String getUpdateAdminBeans() {
	return this.updateAdminBeans;
    }

    public void setUpdateAdminBeans(String updateAdminBeans) {
	this.updateAdminBeans = updateAdminBeans;
    }

    public String getCreateAdminBeans() {
	return this.createAdminBeans;
    }

    public void setCreateAdminBeans(String createAdminBeans) {
	this.createAdminBeans = createAdminBeans;
    }

    public String getDeleteAdminBeans() {
	return this.deleteAdminBeans;
    }

    public void setDeleteAdminBeans(String deleteAdminBeans) {
	this.deleteAdminBeans = deleteAdminBeans;
    }

    private String updateAdminBeans;
    private String createAdminBeans;
    private String deleteAdminBeans;

    public String add() {
	List<String> list = new ArrayList<>();
	AdminBean[] beans = GSON.fromJson(this.createAdminBeans,
		AdminBean[].class);

	for (AdminBean bean : beans) {
	    if (this.adminService.save(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.map = new HashMap<>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String update() {
	List<String> list = new ArrayList<>();
	AdminBean[] beans = GSON.fromJson(this.updateAdminBeans,
		AdminBean[].class);

	for (AdminBean bean : beans) {
	    if (this.adminService.update(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.map = new HashMap<>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String delete() {
	List<String> list = new ArrayList<>();
	AdminBean[] beans = GSON.fromJson(this.deleteAdminBeans,
		AdminBean[].class);

	for (AdminBean bean : beans) {
	    if (this.adminService.delete(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.map = new HashMap<>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(ERRORS, list);
	return MAP;
    }

    public String list() {
	this.list = this.adminService.findByPage(this.start, this.limit);

	this.map = new HashMap<String, Object>();
	this.map.put(TOTAL_COUNT, this.adminService.totalCount());
	this.map.put(ROWS, this.list);
	return MAP;
    }

    public String listAll() {
	this.list = this.adminService.findAll();
	return LIST;
    }

    public String login() {
	AdminBean bean = GSON.fromJson(this.message, AdminBean.class);
	this.message = GSON.toJson(this.adminService.login(bean));
	return MESSAGE;
    }

}
