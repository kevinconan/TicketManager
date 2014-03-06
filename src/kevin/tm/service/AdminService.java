/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.AdminBean;
import kevin.tm.model.Admin;

/**
 * 管理员Service接口
 * 
 * @author Diluka
 * 
 */
public interface AdminService {
    /**
     * 保存
     * 
     * @param adminBean
     * @return
     */
    public int save(AdminBean adminBean);

    /**
     * ID删除
     * 
     * @param loginId
     * @return
     */
    public int deleteById(String loginId);

    /**
     * 修改
     * 
     * @param adminBean
     * @return
     */
    public int update(AdminBean adminBean);

    /**
     * ID查找
     * 
     * @param loginId
     * @return
     */
    public Admin findById(String loginId);

    /**
     * 查找全部
     * 
     * @return
     */
    public List<Admin> findAll();

    /**
     * 登录
     * 
     * @param loginId
     * @param loginPwd
     * @return
     */
    public Admin login(String loginId, String loginPwd);

    /**
     * 记录数
     * 
     * @return
     */
    public int count();
}
