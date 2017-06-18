package com.ssm.businessManage.wages.service;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;

public interface WagesService {
		//查找多个职工薪资信息
		public void selectAllWages(InputObject inputObject,OutputObject outputObject) throws Exception;
		//查找单个职工薪资信息
		public void selectWages(InputObject inputObject,OutputObject outputObject) throws Exception;
		//增加职工薪资信息
		public void addWages(InputObject inputObject,OutputObject outputObject) throws Exception;
		//删除职工薪资信息
		public void deleteWages(InputObject inputObject,OutputObject outputObject) throws Exception;
		//更新职工薪资信息	
		public void updateWages(InputObject inputObject,OutputObject outputObject) throws Exception;

		
}
