package com.ssm.businessManage.wages.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface WagesMapper {
	//查询所有新闻
			public List<Map<String, Object>> selectAll11(PageBounds pageBounds) throws Exception;
			public List<Map<String, Object>> selectAll() throws Exception;
			
			//增加
			public void addWages(Map<String, Object> map) throws Exception;
			//删除
			public void deleteWages(Map<String, Object> map) throws Exception;
			
			public void updateWages(Map<String, Object> map) throws Exception;
			
			
			//test
			public List<Map<String, Object>> test() throws Exception;
			
			public Map<String, Object> test1(Map<String, Object> map) throws Exception;
			
}
