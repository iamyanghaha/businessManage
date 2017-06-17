package com.ssm.businessManage.wages.service;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;


public interface WagesService {
		public void selectAll11(InputObject inputObject,OutputObject outputObject) throws Exception;
	
	//查询所有新闻
		public void selectAll(InputObject inputObject,OutputObject outputObject) throws Exception;
		//增加新闻
		public void addWages(InputObject inputObject,OutputObject outputObject) throws Exception;
		//删除新闻
		public void deleteWages(InputObject inputObject,OutputObject outputObject) throws Exception;
			
		public void updateWages(InputObject inputObject,OutputObject outputObject) throws Exception;

		
}
