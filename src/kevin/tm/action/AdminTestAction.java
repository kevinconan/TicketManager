/**
 * 
 */
package kevin.tm.action;

import java.util.ArrayList;
import java.util.List;

import kevin.tm.dao.model.AdminBean;
import kevin.tm.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;

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

    public AdminBean getAdminBean() {
	return this.adminBean;
    }

    public void setAdminBean(AdminBean adminBean) {
	this.adminBean = adminBean;
    }

    public List<AdminBean> getUpdateAdminBeans() {
	return this.updateAdminBeans;
    }

    public void setUpdateAdminBeans(List<AdminBean> updateAdminBeans) {
	this.updateAdminBeans = updateAdminBeans;
    }

    public List<AdminBean> getCreateAdminBeans() {
	return this.createAdminBeans;
    }

    public void setCreateAdminBeans(List<AdminBean> createAdminBeans) {
	this.createAdminBeans = createAdminBeans;
    }

    public List<AdminBean> getDeleteAdminBeans() {
	return this.deleteAdminBeans;
    }

    public void setDeleteAdminBeans(List<AdminBean> deleteAdminBeans) {
	this.deleteAdminBeans = deleteAdminBeans;
    }

    public List<AdminBean> getAdminBeanList() {
	return this.adminBeanList;
    }

    public void setAdminBeanList(List<AdminBean> adminBeanList) {
	this.adminBeanList = adminBeanList;
    }

    private AdminBean adminBean;
    private List<AdminBean> updateAdminBeans;
    private List<AdminBean> createAdminBeans;
    private List<AdminBean> deleteAdminBeans;
    private List<AdminBean> adminBeanList;

    private final Gson gson = new Gson();

    private int totalCount;

    public String add() {
	List<String> list = new ArrayList<>();

	for (AdminBean bean : this.createAdminBeans) {
	    if (this.adminService.save(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.message = list.size() == 0 ? SUCCESS : this.gson.toJson(list);
	return MESSAGE;
    }

    public String update() {
	List<String> list = new ArrayList<>();

	for (AdminBean bean : this.updateAdminBeans) {
	    if (this.adminService.update(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.message = list.size() == 0 ? SUCCESS : this.gson.toJson(list);
	return MESSAGE;
    }

    public String delete() {
	List<String> list = new ArrayList<>();

	for (AdminBean bean : this.deleteAdminBeans) {
	    if (this.adminService.delete(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	this.message = list.size() == 0 ? SUCCESS : this.gson.toJson(list);
	return MESSAGE;
    }

    public String list() {
	this.adminBeanList = this.adminService.findAll();
	return LIST;
    }

    public int getTotalCount() {
	this.totalCount = this.adminService.totalCount();
	return this.totalCount;
    }

}
