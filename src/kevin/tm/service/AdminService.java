/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.AdminBean;

import org.springframework.stereotype.Service;

/**
 * 管理员Service接口
 * 
 * @author Diluka
 * 
 */
@Service
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
     * 删除
     * 
     * @param adminBean
     * @return
     */
    public int delete(AdminBean adminBean);

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
     * 登录
     * 
     * @param adminBean
     * @return
     */
    public AdminBean login(AdminBean adminBean);

    /**
     * 记录数
     * 
     * @return
     */
    public int totalCount();

    public List<AdminBean> findByPage(int start, int limit);
}
