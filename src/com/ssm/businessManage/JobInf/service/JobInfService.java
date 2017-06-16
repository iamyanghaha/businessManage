package com.ssm.businessManage.JobInf.service;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;


public interface JobInfService {
	public void selectAll11(InputObject inputObject,OutputObject outputObject) throws Exception;
	
	//查询所有新闻
		public void selectAll(InputObject inputObject,OutputObject outputObject) throws Exception;
		//增加新闻
		public void addJobInf(InputObject inputObject,OutputObject outputObject) throws Exception;
		//删除新闻
		public void deleteJobInf(InputObject inputObject,OutputObject outputObject) throws Exception;
			
		public void updateJobInf(InputObject inputObject,OutputObject outputObject) throws Exception;
		
}
