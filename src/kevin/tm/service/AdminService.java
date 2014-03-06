/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.AdminBean;

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
    public AdminBean findById(String loginId);

    /**
     * 查找全部
     * 
     * @return
     */
    public List<AdminBean> findAll();

    /**
     * 登录
     * 
     * @param loginId
     * @param loginPwd
     * @return
     */
    public AdminBean login(String loginId, String loginPwd);

    /**
     * 记录数
     * 
     * @return
     */
    public int totalCount();
}
