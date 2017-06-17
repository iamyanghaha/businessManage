package com.ssm.businessManage.train.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;
import com.ssm.businessManage.train.service.TrainService;


@Controller
public class TrainController {
	@Resource
	private TrainService trainService;
	
	
	/**
	 * 功能：查询所有新闻
	 * 参数：pageNum（第几页）， onePageCount（一页有多少条内容）
	 */
	@RequestMapping("/post/train/selectAll11")
	@ResponseBody
	public void selectAll11(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.selectAll11(inputObject, outputObject);	
	}
	/**
	 * 功能：查询所有新闻
	 * 参数：pageNum（第几页）， onePageCount（一页有多少条内容）
	 */
	@RequestMapping("/post/train/selectAll")
	@ResponseBody
	public void selectAll(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.selectAll(inputObject, outputObject);	
	}
	
	/**
	 * 功能：增加新闻
	 * 参数：新闻标题，内容，时间
	 */
	@RequestMapping("/post/train/addTrain")
	@ResponseBody
	public void addTrain(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.addTrain(inputObject, outputObject);	
	}
	
	/**
	 * 功能：修改职工信息
	 * 参数：职工id
	 */
	@RequestMapping("/post/train/updateTrain")
	@ResponseBody
	public void updateTrain(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.updateTrain(inputObject, outputObject);	
	}
	
	/**
	 * 功能：删除新闻s
	 * 参数：新闻id
	 */
	@RequestMapping("/post/train/deleteTrain")
	@ResponseBody
	public void deleteTrain(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.deleteTrain(inputObject, outputObject);	
	}
	
}
