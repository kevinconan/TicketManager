/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kevin.tm.dao.model.RouteBean;

/**
 * 路线Service接口
 * 
 * @author Diluka
 * 
 */
@Service("routeService")
public interface RouteService {
    /**
     * 保存
     * 
     * @param routeBean
     * @return
     */
    public int save(RouteBean routeBean);

    /**
     * ID删除
     * 
     * @param routeId
     * @return
     */
    public int deleteById(Integer routeId);

    /**
     * 修改
     * 
     * @param routeBean
     * @return
     */
    public int update(RouteBean routeBean);

    /**
     * ID查找
     * 
     * @param routeId
     * @return
     */
    public RouteBean findById(Integer routeId);

    /**
     * 查找全部
     * 
     * @return
     */
    public List<RouteBean> findAll();

    /**
     * 名称查找
     * 
     * @param routeName
     * @return
     */
    public List<RouteBean> findByName(String routeName);
}
