/**
 * 
 */
package kevin.tm.action;

import kevin.tm.dao.model.AdminBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Diluka
 * 
 */
@Scope("request")
@Controller("adminTestAction")
public class AdminTestAction extends BaseAction<AdminBean> {

    /**
     * 
     */
    private static final long serialVersionUID = 620953867973433096L;

}
