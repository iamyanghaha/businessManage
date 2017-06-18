package com.ssm.businessManage.JobInf.service;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;

public interface JobInfService {
	//查询所有职工信息(模糊查询)
	public void selectAllJobInf(InputObject inputObject,OutputObject outputObject) throws Exception;
	//查询单个职工信息
	public void selectJobInf(InputObject inputObject,OutputObject outputObject) throws Exception;
	//增加职员信息
	public void addJobInf(InputObject inputObject,OutputObject outputObject) throws Exception;
	//删除职员信息
	public void deleteJobInf(InputObject inputObject,OutputObject outputObject) throws Exception;
	//修改职员信息
	public void updateJobInf(InputObject inputObject,OutputObject outputObject) throws Exception;
		
}
