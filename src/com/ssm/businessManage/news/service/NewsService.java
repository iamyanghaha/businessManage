package com.ssm.businessManage.news.service;

import com.ssm.businessManage.object.InputObject;
import com.ssm.businessManage.object.OutputObject;

public interface NewsService {
	//查询所有新闻
	public void selectAllNews(InputObject inputObject,OutputObject outputObject) throws Exception;
	//增加新闻
	public void addNews(InputObject inputObject,OutputObject outputObject) throws Exception;
	//删除新闻
	public void deleteNews(InputObject inputObject,OutputObject outputObject) throws Exception;
	//修改新闻
	public void updateNews(InputObject inputObject,OutputObject outputObject) throws Exception;
	//查询单个新闻
	public void selectSingleNews(InputObject inputObject,OutputObject outputObject) throws Exception;
					
	
	
	//test
	public void test(InputObject inputObject,OutputObject outputObject) throws Exception;
	//查找某用户
	public void test1(InputObject inputObject,OutputObject outputObject) throws Exception;
}
