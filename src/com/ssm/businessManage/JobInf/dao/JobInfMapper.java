package com.ssm.businessManage.JobInf.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface JobInfMapper {
	//按照职工姓名查询职工信息
	public List<Map<String,Object>> selectAllJobInf(Map<String,Object> map,PageBounds pageBounds) throws Exception;
	
	//查询单个职工信息
	public Map<String,Object> selectJobInf(Map<String, Object> map) throws Exception;
	
	//增加职工信息
	public void addJobInf(Map<String, Object> map) throws Exception;
	
	//删除职工信息
	public void deleteJobInf(Map<String, Object> map) throws Exception;
	
	//更新职工信息
	public void updateJobInf(Map<String, Object> map) throws Exception;

}
