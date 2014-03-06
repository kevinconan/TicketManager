/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.StationBean;

import org.springframework.stereotype.Service;

/**
 * 车站Service接口
 * 
 * @author Diluka
 * 
 */
@Service
public interface StationService {
    /**
     * 保存
     * 
     * @param stationBean
     * @return
     */
    public int save(StationBean stationBean);

    /**
     * Id删除
     * 
     * @param stationId
     * @return
     */
    public int deleteById(Integer stationId);

    /**
     * 修改
     * 
     * @param stationBean
     * @return
     */
    public int update(StationBean stationBean);

    /**
     * Id查找
     * 
     * @param stationId
     * @return
     */
    public StationBean findById(Integer stationId);

    /**
     * 查找全部
     * 
     * @return
     */
    public List<StationBean> findAll();

    /**
     * 名称查找
     * 
     * @param stationName
     * @return
     */
    public List<StationBean> findByName(String stationName);

    public int totalCount();

    public List<StationBean> findByPage(int start, int limit);
}
