package com.ssm.businessManage.wages.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface WagesMapper {
		//查找所有职工薪资
		public List<Map<String,Object>> selectAllWages(Map<String,Object> map,PageBounds pageBounds) throws Exception;
		//查找单个职工薪资
		public Map<String,Object> selectWages(Map<String,Object> map) throws Exception;
		//增加职工薪资
		public void addWages(Map<String, Object> map) throws Exception;
		//删除职工薪资
		public void deleteWages(Map<String, Object> map) throws Exception;
		//更新职工薪资	
		public void updateWages(Map<String, Object> map) throws Exception;
			
}
