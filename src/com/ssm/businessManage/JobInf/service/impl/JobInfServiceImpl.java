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
public class JobInfServiceImpl implements JobInfService {
	
	@Resource
	private JobInfMapper jobInfMapper;
	
	/**
	 *查询所有职工信息 
	 */
	public void selectAllJobInf(InputObject inputObject,OutputObject outputObject)
			throws Exception{
		//得到前台传过来的所有参数
		Map<String,Object> map = inputObject.getParams();
		
		//得到分页参数
		int pageNum = Integer.parseInt((String) map.get("pageNum"));//第几页
		int onePageCount = Integer.parseInt((String)map.get("onePageCount"));//一页有多少内容
		
		//调用数据库查询所有职工信息
		List<Map<String,Object>> list = jobInfMapper.selectAllJobInf(map,new PageBounds(pageNum,onePageCount,true));
		
		//获取职工信息总数
		PageList<Map<String,Object>> abilityInfoPageList = (PageList<Map<String,Object>>) list;
		int totalJobInf = abilityInfoPageList.getPaginator().getTotalCount();
		
		//计算总页数
		int totalPages = totalJobInf / onePageCount;
		if(totalJobInf % onePageCount > 0){
			totalPages++;
		}

		//将数据以json形式传给前台
		outputObject.setBeans(list);//把查询到的职工信息传入outPutObject
		outputObject.settotal(totalPages);//把总页数传入
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}
	/**
	 * 查询单个职工信息
	 */
	public void selectJobInf(InputObject inputObject,OutputObject outputObject)
			throws Exception{
		Map<String,Object> map = inputObject.getParams();
		//查询职工信息并放入map中
		Map<String,Object> select = jobInfMapper.selectJobInf(map);
		//将查询到的职工信息放入outputObject中输出到页面
		outputObject.setBean(select);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("查询成功！");
		
	}
	
	/**
	 *添加职工信息
	 */
	public void addJobInf(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		//将输入的职工信息写入InputObject中
		Map<String, Object> map = inputObject.getParams();
		jobInfMapper.addJobInf(map);
		//调用OutputObject判断添加是否正确
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("添加成功");

	}
	
	/**
	 * 删除职工信息
	 */
	public void deleteJobInf(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		jobInfMapper.deleteJobInf(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("删除成功");

	}
	
	/**
	 * 更新职工信息
	 */
	public void updateJobInf(InputObject inputObject, OutputObject outputObject)
			throws Exception {
		Map<String, Object> map = inputObject.getParams();
		jobInfMapper.updateJobInf(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("修改成功");
	}

}
