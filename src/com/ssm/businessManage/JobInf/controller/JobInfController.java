package com.ssm.businessManage.JobInf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.businessManage.JobInf.service.JobInfService;
import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;

@Controller
public class JobInfController {
	
	@Resource
	private JobInfService jobInfService;
	/**
	 *功能：查询所有职工信息（支持模糊查询），默认tempTitle参数为空时，查询所有
	 *参数：职工姓名
	 *返回值：按姓名查询的职工信息 
	 */
	@RequestMapping("/post/JobInf/selectAllJobInf")
	@ResponseBody
	public void selectAllJobInf(InputObject inputObject,OutputObject outputObject) throws Exception{
		jobInfService.selectAllJobInf(inputObject, outputObject);
	}
	/**
	 *功能：查询单个职工信息
	 *参数：职工id
	 *返回值：单个职工信息 
	 */
	@RequestMapping("/post/JobInf/selectJobInf")
	@ResponseBody
	public void selectJobInf(InputObject inputObject,OutputObject outputObject) throws Exception{
		jobInfService.selectJobInf(inputObject, outputObject);
	}
	/**
	 * 功能：增加职员信息
	 * 参数：职员id、职员姓名（name）、性别（sex）、生日（birthday）、学历（education）、住址（address）、电话号码（telphone）、部门（department）、职位（work）
	 */
	@RequestMapping("/post/jobInf/addJobInf")
	@ResponseBody
	public void addJobInf(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		jobInfService.addJobInf(inputObject, outputObject);	
	}
	
	/**
	 * 功能：修改职工信息
	 * 参数：职工id、职员姓名（name）、性别（sex）、生日（birthday）、学历（education）、住址（address）、电话号码（tellphone）、部门（department）、职位（work） 
	 */
	@RequestMapping("/post/jobInf/updateJobInf")
	@ResponseBody
	public void updateJobInf(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		jobInfService.updateJobInf(inputObject, outputObject);	
	}
	
	/**
	 * 功能：删除职员信息
	 * 参数：职员id
	 */
	@RequestMapping("/post/jobInf/deleteJobInf")
	@ResponseBody
	public void deleteJobInf(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		jobInfService.deleteJobInf(inputObject, outputObject);	
	}
	
}
