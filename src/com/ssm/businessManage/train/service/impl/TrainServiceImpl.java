package com.ssm.businessManage.train.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;
import com.ssm.businessManage.train.dao.TrainMapper;
import com.ssm.businessManage.train.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService{
	
	@Resource
	private TrainMapper trainMapper; 
	
	public void selectAllTrain(InputObject inputObject,
			OutputObject outputObject) throws Exception {
		// TODO Auto-generated method stub
		//得到前台传过来的所有参数
		Map<String, Object> map = inputObject.getParams();
		
		int pageNum = Integer.parseInt((String) map.get("pageNum"));//第几页
		int onePageCount = Integer.parseInt((String) map.get("onePageCount"));//一页有多少条内容
		List<Map<String,Object>> all = trainMapper.selectAllTrain(map, new PageBounds(pageNum, onePageCount, true));
		
		//获取总数
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>)all;
		int totalTrain = abilityInfoPageList.getPaginator().getTotalCount();
		
		//计算总页数
		int totalPages = totalTrain / onePageCount;
		if(totalTrain % onePageCount > 0){
			totalPages++;
		}
		
		//将数据以json形式传给前台
		outputObject.setBeans(all);//拔查询到的新闻放进output
		outputObject.settotal(totalPages);//把总页数设置进output
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}


	public void addTrain(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		trainMapper.addTrain(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("添加成功");
		
	}


	public void deleteTrain(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		trainMapper.deleteTrain(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("删除成功");
		
	}


	public void updateTrain(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		trainMapper.updateTrain(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("修改成功");
			
	}
	
	public void selectSingleTrain(InputObject inputObject,
			OutputObject outputObject) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = inputObject.getParams();
		Map<String, Object> singleTrain = trainMapper.selectSingleTrain(map);
		outputObject.setBean(singleTrain);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}
	
}
