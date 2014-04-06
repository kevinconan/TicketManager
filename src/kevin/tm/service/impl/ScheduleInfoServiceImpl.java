package kevin.tm.service.impl;

import java.util.List;

import javassist.expr.NewArray;

import kevin.tm.dao.ScheduleinfoMapper;
import kevin.tm.dao.model.Scheduleinfo;
import kevin.tm.dao.model.ScheduleinfoExample;
import kevin.tm.service.ScheduleInfoService;
import kevin.tm.util.ReflectUtil;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

@Scope("prototype")
@Service("scheduleInfoServiceImpl")
public class ScheduleInfoServiceImpl implements ScheduleInfoService {
    @Autowired
    private ScheduleinfoMapper mapper;

    @Override
    public int totalCount() {
	ScheduleinfoExample example = new ScheduleinfoExample();
	example.clear();
	example.createCriteria().getAllCriteria();
	return this.mapper.countByExample(example);
    }

    @Override
    public List<Scheduleinfo> findByPage(int start, int limit,JsonObject params) {
    	boolean includeInvalid;
    	StringBuilder searchClause = new StringBuilder();
    	StringBuilder allClause = new StringBuilder();
    //	System.out.println(params);
    	if(params.toString().equals("{}")){
    		includeInvalid = false;
    		searchClause.append("1=1");
    		allClause.append("1=1");
    	}else{
	    		includeInvalid = params.get("includeInvalid").getAsBoolean();
	    		System.out.println(includeInvalid);
	    		String searchKey = params.get("searchKey").getAsString();
	    		String[] keys = ReflectUtil.getMembers(new Scheduleinfo());
	    		searchKey = searchKey.trim().replaceAll("[\\s]{2,}", " ");
	    		String[] searchKeys = searchKey.split(" ");
	    		for(int i = 0;i < searchKeys.length;i++){
	    			
	    			searchClause = new StringBuilder();
	    			searchClause.append(" ("+keys[0]+" like '%"+searchKeys[i]+"%'");
		    		for(int j = 1;j < keys.length;j++){
		    			if(keys[j].endsWith("time")&&(searchKeys[i].getBytes().length!=searchKeys[i].length())){
		    				searchClause.append(" or "+keys[j]+" like ''");//字段为时间时过滤汉字
		    			}else{
		    			searchClause.append(" or "+keys[j]+" like '%"+searchKeys[i]+"%'");
		    			}
		    		}
		    		searchClause.append(")");
		    		if(i == 0  ){
		    			allClause.append("("+searchClause.toString());
		    		}else{
		    			allClause.append(" and "+searchClause.toString()+" ");
		    			
		    		}
	    		}
	    		allClause.append(")");
	    		
	    		
	    		
    		}
    	
    	if(includeInvalid){
    		return this.mapper.selectByPage(new RowBounds(start,
                    limit),allClause.toString());
    	}else{
    		return this.mapper.selectByPageBeforeNow(new RowBounds(start,
                    limit),allClause.toString());
    		
    	}
    }

	@Override
	public Scheduleinfo findById(int scheduleid) {
		return this.mapper.selectByScheduleId(scheduleid);
	}

}
