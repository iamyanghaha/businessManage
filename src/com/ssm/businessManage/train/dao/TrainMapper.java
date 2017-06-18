package com.ssm.businessManage.train.dao;

import java.util.List;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface TrainMapper {
	//查询所有职员培训信息
	public List<Map<String, Object>> selectAllTrain(Map<String, Object> map, PageBounds pageBounds) throws Exception;
	//增加职员培训信息
	public void addTrain(Map<String, Object> map) throws Exception;
	//删除增加职员培训信息
	public void deleteTrain(Map<String, Object> map) throws Exception;
	//修改职员培训信息
	public void updateTrain(Map<String, Object> map) throws Exception;
	//查询单个职员培训信息
	public Map<String, Object> selectSingleTrain(Map<String, Object> map) throws Exception;		

}
