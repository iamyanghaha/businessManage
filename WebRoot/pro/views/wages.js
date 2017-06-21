var pageNum = 1;//当前页码
var onePageCount = 15;//默认每一页显示的数目
var pageRecord = 1;//用于修改，删除时记录当前页码，便于修改，删除完城刷新时还在当前页
var totalPage = 0;

$(function() {
	dataInit();
	eventInit();
})

//========================以下为两个函数（事件初始化函数  和  数据初始化函数）=========================
function eventInit(){
	//增加按钮事件
	$('body').on('click', '#addButton', function(){
		//$("#introduction").val("");
		openadd('新增职员薪资信息')//打开新增对话框
	});
	//新增时保存按钮事件
	$('body').on('click', '#add', function(e){
		var params = {
				num:1001,
				name:$("#name").val(),
				balansal: $("#baseWage").val(),
				jobsal: $("#postWage").val(),
				addsal: $("#overtimeWage").val(),
				jxsal: $("#performance").val(),
				glsal: $("#seniority").val()
		};
		console.log(params);
		alert($("#wage.baseWage").val());
		AjaxUtil.request({url:path+"/post/wages/addWages",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				//清除
				$("#baseWage").val("");
				$("#postWage").val("");
				$("#overtimeWage").val("");
				$("#performance").val("");
				$("#seniority").val("");
				//隐藏添加面板
				$('#closeBtn').click();
				//重新加载数据
				//封装分页参数
				var params = {
					pageNum:totalPage,//请求的页码
					onePageCount:onePageCount//单页显示的数目
				}; 
				
				//请求数据
				AjaxUtil.request({url : path + "/post/Wages/selectAllWages",params : params,type : 'json',callback : function(json) {
					refreshData(json);	
					}
				});
			}else{
				alert(json.returnMessage);
			}
		}
		});
	});
	
	//修改按钮事件
	$('body').on('click', '#editId', function(e){
		var id = $(this).attr('editId');
		var params = {
				id:id
		}
		//点击修改按钮之后，查询出此条信息并回显在页面上
		AjaxUtil.request({url:path+"/post/Wages/selectWages",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				$("#name").val(json.bean.name);
				$("#baseWage").val(json.bean.balansal);
				$("#postWage").val(json.bean.jobsal);
				$("#overtimeWage").val(json.bean.addsal);
				$("#performance").val(json.bean.jxsal);
				$("#seniority").val(json.bean.glsal);
			}else{
				alert("数据获回显失败！");
			}
		}
		});
		
		openedt('修改薪资信息');
		$("#edt").attr("editId", id);//将 要修改的 信息的id 暂存在  修改保存按钮  的属性
	});
	//确定修改按钮点击事件
	$('body').on('click', '#edt', function(e){
		var id = $(this).attr("editId");//获取要修改的id（每个标签在数据初始化循环时已经加上各自的id）
		var params = {
			id:id,
			num:1001,
			name: $("#name").val(),
			balansal:$("#baseWage").val(),
			jobsal:$("#postWage").val(),
			addsal:$("#overtimeWage").val(),
			jxsal:$("#performance").val(),
			glsal:$("#seniority").val()
		}
		AjaxUtil.request({url:path+"/post/wages/updateWages",params:params,type:'json',callback:function(json){
			if (json.returnCode == 0){
				//清除文本编辑框信息
				$("#name").val("");
				$("#baseWage").val("");
				$("#postWage").val("");
				$("#overtimeWage").val("");
				$("#performance").val("");
				$("#seniority").val("");
				//使添加的model隐藏起来
				$('#closeBtn').click();
				//数据刷新
				dataInit();
			}else{
				alert("修改失败！");
			}
		}
		});
	});
	
	//翻页按钮事件（因为几个按钮都采用按照按钮上的pageNum属性传递想要翻页的页数，所以事件相同）
	$('body').on('click', '.pageButton', function(e){
		var tempPageNum = $(this).attr("pageNum");
		pageNum = parseInt(tempPageNum);//因为js为弱类型语言，所以在上一步取出时，tempPageNum变为字符串类型，所以要转型成为int
		var params = {
			tempName:$('#tempName').val(),//获取查询参数
			pageNum : tempPageNum,
			onePageCount:onePageCount
		}
		//请求数据
		AjaxUtil.request({url : path + "/post/Wages/selectAllWages",params : params,type : 'json',callback : function(json) {
			refreshData(json);	
			}
		});
	});
	
	//查询按钮事件
	$('body').on('click', '#searchButton', function(e){
		var params = {
			tempName:$('#tempName').val(),//获取查询参数
			pageNum:1,
			onePageCount:onePageCount
		};
		//请求数据
		AjaxUtil.request({url : path + "/post/Wages/selectAllWages",params : params,type : 'json',callback : function(json) {
			refreshData(json);	
			}
		});
	});
	
}

function dataInit(){
	//封装分页参数
	var params = {
		pageNum:pageRecord,//请求的页码
		onePageCount:onePageCount//单页显示的数目
	}; 
	
	//请求数据
	AjaxUtil.request({url : path + "/post/Wages/selectAllWages",params : params,type : 'json',callback : function(json) {
		refreshData(json);
		}
	});
	
}


//====================以下为静态包装的函数========================
//创建一个刷新数据的函数
function refreshData(json){
	if (json.returnCode == "0") {
		totalPage = json.total;
		
		//用handlebar给页面表格放置数据
		var source = $("#infTable").html();
		var template = Handlebars.compile(source);
		$("#tbody").html(template(json));
		
		//设置翻页按钮参数
		$("#thisPageNum").html(pageNum);
		$("#totalPageNum").html(json.total);
		
		if(pageNum > 1){//设置上一页的页码
			$("#prePage").attr("pageNum", pageNum-1);
		}else{
			$("#prePage").attr("pageNum", 1);
		}
		
		if(pageNum < json.total){//设置下一页的页码
			$("#nextPage").attr("pageNum", pageNum + 1);
		}else{
			$("#nextPage").attr("pageNum", pageNum);
		}
		
		$("#lastPage").attr("pageNum", json.total);//尾页
		
	} else {
		alert("数据加载失败！");
	}
}

/*<a class="btn" onclick="openedt('修改职员薪资信息');">修改</a>&nbsp;&nbsp;*/