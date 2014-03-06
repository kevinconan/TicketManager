/**
 * 
 */
package kevin.tm.service.impl;

import java.util.List;

import kevin.tm.dao.AdminBeanMapper;
import kevin.tm.dao.AdminMapper;
import kevin.tm.dao.model.AdminBean;
import kevin.tm.dao.model.AdminBeanExample;
import kevin.tm.model.Admin;
import kevin.tm.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Diluka
 * 
 */
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminBeanMapper adminBeanMapper;
    @Autowired
    private AdminMapper adminMapper;

    public AdminBeanMapper getAdminBeanMapper() {
	return this.adminBeanMapper;
    }

    public void setAdminBeanMapper(AdminBeanMapper adminBeanMapper) {
	this.adminBeanMapper = adminBeanMapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.AdminService#save(kevin.tm.dao.model.AdminBean)
     */
    @Override
    public int save(AdminBean adminBean) {
	return this.adminBeanMapper.insert(adminBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.AdminService#deleteById(java.lang.String)
     */
    @Override
    public int deleteById(String loginId) {
	return this.adminBeanMapper.deleteByPrimaryKey(loginId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.AdminService#update(kevin.tm.dao.model.AdminBean)
     */
    @Override
    public int update(AdminBean adminBean) {
	return this.adminBeanMapper.updateByPrimaryKey(adminBean);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.AdminService#findById(java.lang.String)
     */
    @Override
    public Admin findById(String loginId) {
	return this.adminMapper.getById(loginId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.AdminService#findAll()
     */
    @Override
    public List<Admin> findAll() {
	return this.adminMapper.getAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see kevin.tm.service.AdminService#login(java.lang.String,
     * java.lang.String)
     */
    @Override
    public Admin login(String loginId, String loginPwd) {
	return this.adminMapper.login(loginId, loginPwd);
    }

    @Override
    public int count() {
	AdminBeanExample adminBeanExample = new AdminBeanExample();
	adminBeanExample.clear();
	adminBeanExample.createCriteria().getAllCriteria();
	return this.adminBeanMapper.countByExample(adminBeanExample);
    }

}
