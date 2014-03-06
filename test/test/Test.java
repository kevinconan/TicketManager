/**
 * 
 */
package test;

import kevin.tm.dao.model.AdminBean;

import com.google.gson.Gson;

/**
 * @author Diluka
 * 
 */
public class Test {
    private static final Gson gson = new Gson();

    /**
     * @param args
     */
    public static void main(String[] args) {
	String json = "[{\"adminname\":\"test\",\"loginid\":\"test\",\"loginpwd\":\"test\"}]";
	AdminBean[] beans = gson.fromJson(json, AdminBean[].class);

	for (AdminBean bean : beans) {
	    System.out.println(bean.getLoginid() + "\t" + bean.getLoginpwd()
		    + "\t" + bean.getAdminname());
	}
    }
}
