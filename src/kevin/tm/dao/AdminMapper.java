/**
 * 
 */
package kevin.tm.dao;

import java.util.List;

import kevin.tm.model.Admin;

import org.apache.ibatis.annotations.Param;

/**
 * @author Diluka
 * 
 */
public interface AdminMapper {
    public Admin getById(@Param("LoginId") String loginId);

    public List<Admin> getAll();

    public Admin login(@Param("LoginId") String loginId,
	    @Param("LoginPwd") String loginPwd);
}
