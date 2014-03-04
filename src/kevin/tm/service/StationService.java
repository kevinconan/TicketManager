/**
 * 
 */
package kevin.tm.service;

import java.util.List;

import kevin.tm.dao.model.StationBean;

/**
 * 车站Service接口
 * 
 * @author Diluka
 * 
 */
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

    /**
     * 计算两车站距离 ，调用存储过程up_CalcTowStationDistance
     * 
     * @param stationA
     * @param stationB
     * @return
     */
    public Double calcTowStationDistanceById(Integer stationA, Integer stationB);

    /**
     * 计算两车站距离
     * 
     * @param stationA
     * @param stationB
     * @return
     */
    public Double calcTowStationDistance(StationBean stationA,
	    StationBean stationB);

}
