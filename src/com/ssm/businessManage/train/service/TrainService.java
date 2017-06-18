package com.ssm.businessManage.train.service;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;


public interface TrainService {
	//查询所有
	public void selectAllTrain(InputObject inputObject,OutputObject outputObject) throws Exception;
	//增加
	public void addTrain(InputObject inputObject,OutputObject outputObject) throws Exception;
	//删除
	public void deleteTrain(InputObject inputObject,OutputObject outputObject) throws Exception;
	//修改
	public void updateTrain(InputObject inputObject,OutputObject outputObject) throws Exception;
	//单个查询
	public void selectSingleTrain(InputObject inputObject,OutputObject outputObject) throws Exception;
}
