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

import com.google.gson.JsonArray;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("adminTestAction")
public class AdminTestAction extends BaseAction<AdminBean> {

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

    public List<AdminBean> getAdminBeanList() {
	return this.adminBeanList;
    }

    public void setAdminBeanList(List<AdminBean> adminBeanList) {
	this.adminBeanList = adminBeanList;
    }

    private String updateAdminBeans;
    private String createAdminBeans;
    private String deleteAdminBeans;
    private List<AdminBean> adminBeanList;

    public String add() {
	List<String> list = new ArrayList<>();
	JsonArray array = gson.toJsonTree(this.createAdminBeans)
		.getAsJsonArray();

	for (int i = 0; i < array.size(); i++) {
	    AdminBean bean = gson.fromJson(array.get(i), AdminBean.class);
	    if (this.adminService.save(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.map = new HashMap<>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String update() {
	List<String> list = new ArrayList<>();
	JsonArray array = gson.toJsonTree(this.updateAdminBeans)
		.getAsJsonArray();

	for (int i = 0; i < array.size(); i++) {
	    AdminBean bean = gson.fromJson(array.get(i), AdminBean.class);
	    if (this.adminService.update(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.map = new HashMap<>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String delete() {
	List<String> list = new ArrayList<>();
	JsonArray array = gson.toJsonTree(this.deleteAdminBeans)
		.getAsJsonArray();

	for (int i = 0; i < array.size(); i++) {
	    AdminBean bean = gson.fromJson(array.get(i), AdminBean.class);
	    if (this.adminService.delete(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.map = new HashMap<>();
	this.map.put(SUCCESS, list.isEmpty());
	this.map.put(FAILURE, list);
	return MAP;
    }

    public String list() {
	this.adminBeanList = this.adminService.findByPage(this.start,
		this.limit);

	this.map = new HashMap<String, Object>();
	this.map.put("totalCount", this.adminService.totalCount());
	this.map.put("rows", this.adminBeanList);
	return MAP;
    }

}
