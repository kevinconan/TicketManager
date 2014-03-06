/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.RouteBean;

import org.springframework.stereotype.Service;

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
     * ID列表删除
     * 
     * @param routeId
     * @return
     */
    public int deleteById(int[] routeId);

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

    public int totalCount();

    public List<RouteBean> findByPage(int start, int limit);
}
