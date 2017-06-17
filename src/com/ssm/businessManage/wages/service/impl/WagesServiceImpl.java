package com.ssm.businessManage.wages.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;
import com.ssm.businessManage.wages.dao.WagesMapper;
import com.ssm.businessManage.wages.service.WagesService;

@Service
public class WagesServiceImpl implements WagesService{
	
	
	//@Autowired
	@Resource
	private WagesMapper wagesMapper;
	
	public void selectAll11(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		int page = Integer.parseInt((String)map.get("page"));
		int onePageNum = 5;
		
		List<Map<String,Object>> allNews = wagesMapper.selectAll11(new PageBounds(page, onePageNum, true));
		
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
		List<Map<String,Object>> allNews = wagesMapper.selectAll();
		outputObject.setBeans(allNews);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}


	public void addWages(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		wagesMapper.addWages(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("添加成功");
		
	}


	public void deleteWages(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		
		wagesMapper.deleteWages(map);
		System.out.println("===============delete====  " + map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("删除成功");
		
	}


	public void updateWages(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		System.out.println("====================update=====================" + map);
		wagesMapper.updateWages(map);
		
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("修改成功");
			
	}

}
