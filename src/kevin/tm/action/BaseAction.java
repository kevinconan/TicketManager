package kevin.tm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kevin.tm.util.ValidationUtil;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Title: BaseAction.java<br />
 * Description: Action抽象基类<br />
 **/
public abstract class BaseAction<T> extends ActionSupport implements
	ServletRequestAware, ServletResponseAware {

    private static final long serialVersionUID = -1564001162335439613L;
    protected static final String SUCCESS = "SUCCESS";
    protected static final String FAILURE = "FAILURE";
    protected static final String MESSAGE = "MESSAGE";
    protected static final String LIST = "LIST";
    protected static final String MAP = "MAP";
    protected static final String TOTAL_COUNT = "totalCount";
    protected static final String ROWS = "rows";

    protected String message;
    protected List<T> list;
    protected Map<String, Object> map;

    protected String jsonData;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    public String getJsonData() {
	return this.jsonData;
    }

    public void setJsonData(String jsonData) {
	this.jsonData = jsonData;
    }

    public HttpServletRequest getRequest() {
	return this.request;
    }

    public void setRequest(HttpServletRequest request) {
	this.request = request;
    }

    public HttpServletResponse getResponse() {
	return this.response;
    }

    public void setResponse(HttpServletResponse response) {
	this.response = response;
    }

    public HttpSession getSession() {
	return this.session;
    }

    public void setSession(HttpSession session) {
	this.session = session;
    }

    public String getMessage() {
	return this.message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public List<T> getList() {
	return this.list;
    }

    public void setList(List<T> list) {
	this.list = list;
    }

    public Map<String, Object> getMap() {
	return this.map;
    }

    public void setMap(Map<String, Object> map) {
	this.map = map;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
	this.request = request;
	this.session = request.getSession();
	// this.session.setMaxInactiveInterval(-1);
	// this.application = (HttpContext) session.getServletContext();
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
	this.response = response;
    }

    protected String getStringParameter(String name) {
	try {
	    String result = this.request.getParameter(name);
	    return result;
	} catch (Exception e) {
	}
	return null;
    }

    protected Integer getIntParameter(String name) {
	try {
	    String value = this.request.getParameter(name);
	    if (!ValidationUtil.isNullOrEmpty(value)) {
		return Integer.valueOf(value);
	    }
	} catch (Exception e) {
	}
	return null;
    }

    protected Short getShortParameter(String name) {
	try {
	    String value = this.request.getParameter(name);
	    if (!ValidationUtil.isNullOrEmpty(value)) {
		return Short.valueOf(value);
	    }
	} catch (Exception e) {
	}
	return null;
    }

    protected Boolean getBooleanParameter(String name) {
	try {
	    String result = this.request.getParameter(name);
	    if (!ValidationUtil.isNullOrEmpty(result)
		    && result.equalsIgnoreCase("true")) {
		return true;
	    } else {
		return false;
	    }
	} catch (Exception e) {
	}
	return null;
    }

    protected int start;
    protected int limit;
    protected static final Gson GSON = new Gson();

    public int getStart() {
	return this.start;
    }

    public void setStart(int start) {
	this.start = start;
    }

    public int getLimit() {
	return this.limit;
    }

    public void setLimit(int limit) {
	this.limit = limit;
    }
}
