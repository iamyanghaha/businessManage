package com.ssm.businessManage.train.service;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;


public interface TrainService {
	public void selectAll11(InputObject inputObject,OutputObject outputObject) throws Exception;
	
	//查询所有新闻
		public void selectAll(InputObject inputObject,OutputObject outputObject) throws Exception;
		//增加新闻
		public void addTrain(InputObject inputObject,OutputObject outputObject) throws Exception;
		//删除新闻
		public void deleteTrain(InputObject inputObject,OutputObject outputObject) throws Exception;
			
		public void updateTrain(InputObject inputObject,OutputObject outputObject) throws Exception;
		
}
