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
	 * 功能：查询所有新闻
	 * 参数：pageNum（第几页）， onePageCount（一页有多少条内容）
	 */
	@RequestMapping("/post/wages/selectAll11")
	@ResponseBody
	public void selectAll11(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		wagesService.selectAll11(inputObject, outputObject);	
	}
	/**
	 * 功能：查询所有新闻
	 * 参数：pageNum（第几页）， onePageCount（一页有多少条内容）
	 */
	@RequestMapping("/post/wages/selectAll")
	@ResponseBody
	public void selectAll(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		wagesService.selectAll(inputObject, outputObject);	
	}
	
	/**
	 * 功能：增加新闻
	 * 参数：新闻标题，内容，时间
	 */
	@RequestMapping("/post/wages/addWages")
	@ResponseBody
	public void addWages(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		wagesService.addWages(inputObject, outputObject);	
	}
	
	/**
	 * 功能：修改职工信息
	 * 参数：职工id
	 */
	@RequestMapping("/post/wages/updateWages")
	@ResponseBody
	public void updateWages(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		wagesService.updateWages(inputObject, outputObject);	
	}
	
	/**
	 * 功能：删除新闻s
	 * 参数：新闻id
	 */
	@RequestMapping("/post/wages/deleteWages")
	@ResponseBody
	public void deleteWages(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		wagesService.deleteWages(inputObject, outputObject);	
	}
	
}
