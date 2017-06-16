package com.ssm.businessManage.JobInf.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface JobInfMapper {
	//查询所有新闻
			public List<Map<String, Object>> selectAll11(PageBounds pageBounds) throws Exception;
			public List<Map<String, Object>> selectAll() throws Exception;
			
			//增加新闻
			public void addJobInf(Map<String, Object> map) throws Exception;
			//删除新闻
			public void deleteJobInf(Map<String, Object> map) throws Exception;
			
			public void updateJobInf(Map<String, Object> map) throws Exception;
			
			
			//test
			public List<Map<String, Object>> test() throws Exception;
			
			public Map<String, Object> test1(Map<String, Object> map) throws Exception;
			
}
