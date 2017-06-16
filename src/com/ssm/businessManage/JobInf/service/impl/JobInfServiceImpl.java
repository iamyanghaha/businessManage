package com.ssm.businessManage.JobInf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.businessManage.JobInf.dao.JobInfMapper;
import com.ssm.businessManage.JobInf.service.JobInfService;
import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;

@Service
public class JobInfServiceImpl implements JobInfService{
	
	
	//@Autowired
	@Resource
	private JobInfMapper jobInfMapper; 
	
	public void selectAll11(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		int page = Integer.parseInt((String)map.get("page"));
		int onePageNum = 5;
		
		List<Map<String,Object>> allNews = jobInfMapper.selectAll11(new PageBounds(page, onePageNum, true));
		
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>)allNews;
		int total = abilityInfoPageList.getPaginator().getTotalCount();
		
		outputObject.settotal(total);
		outputObject.setBeans(allNews);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}
	

	public void selectAll(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		System.out.println("====================selectAll  ");
		List<Map<String,Object>> allNews = jobInfMapper.selectAll();
		outputObject.setBeans(allNews);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}


	public void addJobInf(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		jobInfMapper.addJobInf(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("添加成功");
		
	}


	public void deleteJobInf(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		jobInfMapper.deleteJobInf(map);
		System.out.println("===============delete====  " + map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("删除成功");
		
	}


	public void updateJobInf(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		System.out.println("====================update=====================" + map);
		jobInfMapper.updateJobInf(map);
		
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("修改成功");
			
	}

	
}
