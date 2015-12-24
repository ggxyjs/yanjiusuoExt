<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>精品课程-搜索引擎技术与原理</title>
<link href="<%=basePath %>home/css/file.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>home/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>home/css/show.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>home/js/swfobject.js"></script>
</head>

<body>
	<div style="margin-top:2%"><span>搜索引擎技术与原理精品课程</span></div>
	<li>课程介绍</li>
	<p>课程《搜索引擎技术与原理》，将重点讲解Google 、百度两个知名综合搜索引擎进行学习，掌握其中的核心技术，包括：搜索引擎中的检索算法、搜索引擎的基本原理、搜索引擎的信息采集技术、信息采集系统开发实践等环节的学习。同时，本课程采用研究型教学，面向问题式的学习，大部分在机房学习；每次学习都有具体要求，小组形式完成学习汇报。技术部分要求小组掌握信息采集方法或软件；应用部分要求掌握实训的全流程操作。</p>
	<p>考核方式采取：小组汇报（系统开发学习）+个人阶段学习汇报+课堂表现</p>
	
	<div class="video" id="CuPlayer">
	<strong><a href="http://http://www.baidu.com/link?url=trK4XLvspBY6tdccYVjTW7ZwSYrnbpXYxO95q4h7zwveMnZJIdrQiK61sgntdeBfl59fsr7vPjO5y7uZrJq-6_&wd=&eqid=be6bce460000b9570000000255755426&ie=utf-8/">提示：您的Flash Player版本过低，请点此进行网页播放器升级</a>！</strong>
	</div>
	<script type="text/javascript">
		var so = new SWFObject("CuPlayerMiniV4.swf","CuPlayerV4","900","600","9","#000000");
		so.addParam("allowfullscreen","true");
		so.addParam("allowscriptaccess","always");
		so.addParam("wmode","opaque");
		so.addParam("quality","high");
		so.addParam("salign","lt");
 		so.addVariable("CuPlayerSetFile","<%=basePath %>home/CuPlayerSetFile.xml"); 
		so.addVariable("CuPlayerFile","<%=basePath %>home/search.mp4"); //视频文件地址
		so.addVariable("CuPlayerImage","<%=basePath %>home/images/startsearch.png");//视频略缩图,本图片文件必须正确
		so.addVariable("CuPlayerWidth","900"); //视频宽度
		so.addVariable("CuPlayerHeight","600"); //视频高度
		so.addVariable("CuPlayerAutoPlay","no"); //是否自动播放
		so.addVariable("CuPlayerLogo","<%=basePath %>home/images/Logo.png"); //Logo文件地址
		so.addVariable("CuPlayerPosition","top-right"); //Logo显示的位置 
		so.write("CuPlayer");
	</script>
	
	<li>课程大纲</li>
	<p>一、理论学习 </p>
	<p>1.1 绪论</p>
	<p>1.2 有关搜索引擎的发展现状及主要不足</p>
	<p>1.3 搜索引擎工作基本原理</p>
	<p>1.4 搜索引擎中的检索算法 </p>
	<p>1.5 传统检索算法</p>
	<p>1.6 搜索引擎的营销应用</p>
	<p>二、研讨与实践 </p>
	<p>2.1 搜索引擎的信息采集问题</p>
	<p>2.2 搜索引擎的现有抓取、采集软件学习与操作</p>
	<p>2.3 自己编程写抓取软件的实现路径</p>
	<p>2.4 网络信息采集效果大比拼及展示 </p>
	<p>三、设计与开发</p>
	<p>3.1 自选一个深度搜索软件进行解刨学习</p>
	<p>3.2 搜索引擎的营销实践（关键词竞价策略设计）</p>
	<p>3.3 完成一个小型主题内容采集与排序、课检索的系统</p>
	
	<li>课程课件(点击在线预览)</li>
	  	<div class="module-grid-view" >
		<div class="wrapper global-clearfix" node-type="list" id="ImgView">        
	    </div>
	  	</div>	  	
	<li>课程实验素材下载</li>
	<div class="yao-b">
	    <div class="module-list-view">
	        <div class="list-view-home">
	            <div class="title" style="padding-right: 0px;">        
	                <div class="item global-clearfix">
	                    <div style="width: 40%;" class="col c1">文件名</div>
	                    <div style="width: 16%;" class="col">大小</div>
	                    <div style="width: 23%;border-right: none;" class="col">修改日期</div>
	                    <div style="width: 20%;border-right: none;" class="col">权限</div>
	                </div>
	            </div>
	            <div class="list" id="FileHtml"> 
	            </div>
	              <!--翻页-->
		         <div class="page_v2" id="jg_ajax_page">
		         </div>
		         <!--翻页-->
	        </div>
	    </div>
	</div>
	<li>优秀学生作品下载</li>
	<div class="yao-b">
	    <div class="module-list-view">
	        <div class="list-view-home">
	            <div class="title" style="padding-right: 0px;">        
	                <div class="item global-clearfix">
	                    <div style="width: 40%;" class="col c1">文件名</div>
	                    <div style="width: 16%;" class="col">大小</div>
	                    <div style="width: 23%;border-right: none;" class="col">修改日期</div>
	                    <div style="width: 20%;border-right: none;" class="col">权限</div>
	                </div>
	            </div>
	            <div class="list" id="FileHtml1"> 
	            </div>
	              <!--翻页-->
		         <div class="page_v2" id="jg_ajax_page1">
		         </div>
		         <!--翻页-->
	        </div>
	    </div>
	</div>
	<script type="text/javascript" src="<%=basePath %>home/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>home/js/jquery.whpage.js"></script>
	<script type="text/javascript" src="<%=basePath %>search/js/show.js"></script>
	<script type="text/javascript">
	var basePath = "<%=basePath%>";
	$(document).ready(function()
	{
		show.query();
	});
	$(function(){
		$(".module-list-view .item").hover(function(){
			$(this).addClass("item-hover");	
		},function(){
			$(this).removeClass("item-hover");
		})
	})
	</script>
</body>
</html>
