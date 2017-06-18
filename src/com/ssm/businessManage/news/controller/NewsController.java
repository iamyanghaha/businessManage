package com.ssm.businessManage.news.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.businessManage.news.service.NewsService;
import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;

/*
 *	新闻公告部分   
*/
@Controller
public class NewsController {
	
	@Resource
	private NewsService newsService;
	
	/**
	 * 功能：查询所有新闻（支持模糊查询，默认（tempTitle参数为空时）查询全部）
	 * 参数：pageNum（第几页), onePageCount（一页有多少条内容）,tempTitle(模糊查询时的标题)
	 */
	@RequestMapping("/post/news/selectAllNews")
	@ResponseBody
	public void selectAllNews(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		newsService.selectAllNews(inputObject, outputObject);	
	}
	
	/**
	 * 功能：增加新闻
	 * 参数：新闻标题，内容，时间
	 */
	@RequestMapping("/post/news/addNews")
	@ResponseBody
	public void addNews(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		newsService.addNews(inputObject, outputObject);	
	}
	
	/**
	 * 功能：删除新闻s
	 * 参数：新闻id
	 */
	@RequestMapping("/post/news/deleteNews")
	@ResponseBody
	public void deleteNews(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		newsService.deleteNews(inputObject, outputObject);	
	}
	
	/**
	 * 功能：修改新闻
	 * 参数：新闻id， 新闻内容
	 */
	@RequestMapping("/post/news/updateNews")
	@ResponseBody
	public void updateNews(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		newsService.updateNews(inputObject, outputObject);	
	}
	
	/**
	 * 功能：查询单个新闻
	 * 参数：新闻id
	 */
	@RequestMapping("/post/news/selectSingleNews")
	@ResponseBody
	public void selectSingleNews(InputObject inputObject,OutputObject outputObject) throws Exception{ 
		newsService.selectSingleNews(inputObject, outputObject);
	}
	
}
