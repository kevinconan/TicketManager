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

    private AdminBean adminBean;
    private List<AdminBean> updateAdminBeans;
    private List<AdminBean> createAdminBeans;
    private List<AdminBean> deleteAdminBeans;

    public String add() {
	List<String> list = new ArrayList<>();

	for (AdminBean bean : this.createAdminBeans) {
	    if (this.adminService.save(bean) == 0) {
		list.add(bean.getLoginid());
	    }
	}

	return MESSAGE;
    }

    public String update() {
	int count = 0;
	for (AdminBean bean : this.updateAdminBeans) {
	    count += this.adminService.update(bean);
	}
	return MESSAGE;
    }

    public String delete() {
	int count = 0;
	for (AdminBean bean : this.deleteAdminBeans) {
	    count += this.adminService.delete(bean);
	}
	return MESSAGE;
    }

}
