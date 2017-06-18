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
	 * 功能：查询所有
	 * 参数：pageNum（第几页）， onePageCount（一页有多少条内容）,tempTask(模糊查询参数，为空时查询全部)
	 * 返回：list《map》，每个map中卫一个信息
	 */
	@RequestMapping("/post/train/selectAllTrain")
	@ResponseBody
	public void selectAllTrain(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.selectAllTrain(inputObject, outputObject);	
	}

	
	/**
	 * 功能：增加
	 * 参数：
	 */
	@RequestMapping("/post/train/addTrain")
	@ResponseBody
	public void addTrain(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.addTrain(inputObject, outputObject);	
	}
	
	/**
	 * 功能：修改
	 * 参数：id
	 */
	@RequestMapping("/post/train/updateTrain")
	@ResponseBody
	public void updateTrain(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.updateTrain(inputObject, outputObject);	
	}
	
	/**
	 * 功能：删除
	 * 参数：id
	 */
	@RequestMapping("/post/train/deleteTrain")
	@ResponseBody
	public void deleteTrain(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.deleteTrain(inputObject, outputObject);	
	}
	
	/**
	 * 功能：单个查询
	 * 参数：id
	 * 返回：单个信息
	 */
	@RequestMapping("/post/train/selectSingleTrain")
	@ResponseBody
	public void selectSingleTrain(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		trainService.selectSingleTrain(inputObject, outputObject);	
	}
	
}
