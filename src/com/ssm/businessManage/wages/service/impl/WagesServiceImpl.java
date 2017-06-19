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
	
	@Resource
	private WagesMapper wagesMapper;
	//查找所有职工薪资
	public void selectAllWages(InputObject inputObject,OutputObject outputObject)
			throws Exception{
		//将职工薪资信息写入inputObject
		Map<String,Object> map = inputObject.getParams();
		
		//得到分页信息
		int PageNum = Integer.parseInt((String)map.get("pageNum"));
		int onePageCount = Integer.parseInt((String) map.get("onePageCount"));
		
		//调用数据库查询所有职工薪资信息
		List<Map<String,Object>> list = wagesMapper.selectAllWages(map,new PageBounds(PageNum,onePageCount,true));
		
		//获取职工信息总数
		PageList<Map<String,Object>> abilityInfoPageList = (PageList<Map<String,Object>>) list;
		int totleWages = abilityInfoPageList.getPaginator().getTotalCount();
		
		//计算总页数
		int totlePage = totleWages / onePageCount;
		if(totleWages % onePageCount >0){
			totlePage++;
		}
		
		//将数据以json形式传输到前台
		outputObject.setBeans(list);
		outputObject.settotal(totlePage);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}
	//查找单个职工薪资信息
	public void selectWages(InputObject inputObject,OutputObject outputObject)
			throws Exception{
		Map<String,Object> map = inputObject.getParams();
		Map<String,Object> list = wagesMapper.selectWages(map);
		outputObject.setBean(list);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("查找成功");
	}
	
	//添加职工薪资信息
	public void addWages(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();	
//		double p1 = Double.parseDouble(map.get("base"));
//		double p1 = Double.parseDouble(map.get("baasd"));
//		double sum = p1 + ..;
//		map.put("sum", sum);
		wagesMapper.addWages(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("添加成功");
		
	}

	//删除职工薪资信息
	public void deleteWages(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		wagesMapper.deleteWages(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("删除成功");
		
	}

	//更新职工薪资信息
	public void updateWages(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		wagesMapper.updateWages(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("修改成功");
			
	}

}
