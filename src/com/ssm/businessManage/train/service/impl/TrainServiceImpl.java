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
	
	
	//@Autowired
	@Resource
	private TrainMapper trainMapper; 
	
	public void selectAll11(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		int page = Integer.parseInt((String)map.get("page"));
		int onePageNum = 5;
		
		List<Map<String,Object>> allTrain = trainMapper.selectAll11(new PageBounds(page, onePageNum, true));
		
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>)allTrain;
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		
		outputObject.settotal(total);
		outputObject.setBeans(allTrain);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}
	

	public void selectAll(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		System.out.println("====================selectAll  ");
		List<Map<String,Object>> allTrain = trainMapper.selectAll();
		outputObject.setBeans(allTrain);
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
		System.out.println("===============delete====  " + map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("删除成功");
		
	}


	public void updateTrain(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		System.out.println("====================update=====================" + map);
		trainMapper.updateTrain(map);
		
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("修改成功");
			
	}

	
}
