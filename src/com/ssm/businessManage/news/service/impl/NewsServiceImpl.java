package com.ssm.businessManage.news.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ssm.businessManage.news.dao.NewsMapper;
import com.ssm.businessManage.news.service.NewsService;
import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Resource
	private NewsMapper newsMapper;
	
	/*
	 * 查询所有新闻
	 */
	public void selectAllNews(InputObject inputObject, OutputObject outputObject) throws Exception{
		//得到前台传过来的所有参数
		Map<String, Object> map = inputObject.getParams();
		
		//得到分页参数
		int pageNum = Integer.parseInt((String) map.get("pageNum"));//第几页
		int onePageCount = Integer.parseInt((String) map.get("onePageCount"));//一页有多少条内容
		
		//调用数据库查新所有新闻
		List<Map<String,Object>> allNews = newsMapper.selectAllNews(map, new PageBounds(pageNum, onePageCount, true));
		
		//获取新闻总数
		PageList<Map<String, Object>> abilityInfoPageList = (PageList<Map<String, Object>>)allNews;
		int totalNews = abilityInfoPageList.getPaginator().getTotalCount();
		
		//计算总页数
		int totalPages = totalNews / onePageCount;
		if(totalNews % onePageCount > 0){
			totalPages++;
		}
		
		//将数据以json形式传给前台
		outputObject.setBeans(allNews);//拔查询到的新闻放进output
		outputObject.settotal(totalPages);//把总页数设置进output
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}
	
	/*
	 * 增加新闻
	 */
	public void addNews(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		newsMapper.addNews(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("添加成功");
	}
	
	/*
	 * 删除新闻
	 */
	public void deleteNews(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		newsMapper.deleteNews(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("删除成功");
	}

	/*
	 * 修改新闻
	 */
	public void updateNews(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		newsMapper.updateNews(map);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("修改成功");
	}
	
	/*
	 * 查询单个新闻
	 */
	public void selectSingleNews(InputObject inputObject, OutputObject outputObject) throws Exception {
		Map<String, Object> map = inputObject.getParams();
		Map<String, Object> singleNews = newsMapper.selectSingleNews(map);
		outputObject.setBean(singleNews);
		outputObject.setreturnCode(0);
		outputObject.setreturnMessage("成功");
	}
	
}
