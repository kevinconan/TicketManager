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
    //	System.out.println(params);
    	if(params.toString().equals("{}")){
    		includeInvalid = false;
    		searchClause.append("1=1");
    	}else{
	    		includeInvalid = params.get("includeInvalid").getAsBoolean();
	    		String shearchKey = params.get("shearchKey").getAsString();
	    		String[] keys = ReflectUtil.getMembers(new Scheduleinfo());
	    		searchClause.append(" ("+keys[0]+" like '"+shearchKey+"'");
	    		for(int i = 1;i < keys.length;i++){
	    			if(keys[i].endsWith("time")&&(shearchKey.getBytes().length!=shearchKey.length()))
	    				shearchKey="";//字段为时间时过滤汉字
	    			searchClause.append(" or "+keys[i]+" like '"+shearchKey+"'");
	    		}
	    		searchClause.append(")");
    		}
    	
    	if(includeInvalid){
    		return this.mapper.selectByPage(new RowBounds(start,
                    limit),searchClause.toString());
    	}else{
    		return this.mapper.selectByPageBeforeNow(new RowBounds(start,
                    limit),searchClause.toString());
    		
    	}
    }

	@Override
	public Scheduleinfo findById(int scheduleid) {
		return this.mapper.selectByScheduleId(scheduleid);
	}

}
