package com.ssm.businessManage.wages.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;
import com.ssm.businessManage.wages.service.WagesService;

@Controller
public class WagesController {
	
	@Resource
	private WagesService wagesService;
	
	/**
	 *功能：查询所有职工薪资信息（支持模糊查询） 
	 */
	@RequestMapping("/post/Wages/selectAllWages")
	@ResponseBody
	public void selectAllWages(InputObject inputObject,OutputObject outputObject) throws Exception{
		wagesService.selectAllWages(inputObject, outputObject);
	}
	/**
	 * 功能:查找单个职工薪资信息
	 */
	@RequestMapping("/post/Wages/selectWages")
	@ResponseBody
	public void selectWages(InputObject inputObject,OutputObject outputObject) throws Exception{
		wagesService.selectWages(inputObject, outputObject);
	}
	/**
	 * 功能：增加职工薪资信息
	 * 参数：职工工号，姓名，基本工资，岗位工资，加班工资，绩效奖，工龄奖，合计
	 */
	@RequestMapping("/post/wages/addWages")
	@ResponseBody
	public void addWages(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		wagesService.addWages(inputObject, outputObject);	
	}
	
	/**
	 * 功能：修改职工信息
	 * 参数：职工id，职工工号，姓名，基本工资，岗位工资，加班工资，绩效奖，工龄奖，合计
	 */
	@RequestMapping("/post/wages/updateWages")
	@ResponseBody
	public void updateWages(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		wagesService.updateWages(inputObject, outputObject);	
	}
	
	/**
	 * 功能：删除职工薪资信息
	 * 参数：职工id
	 */
	@RequestMapping("/post/wages/deleteWages")
	@ResponseBody
	public void deleteWages(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		wagesService.deleteWages(inputObject, outputObject);	
	}
	
}
