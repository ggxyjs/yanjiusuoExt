<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>精品课程-信息系统分析与设计</title>
<link href="<%=basePath %>home/css/file.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>home/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>home/css/show.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>home/js/swfobject.js"></script>
</head>

<body>
	<div style="margin-top:2%"><span>信息系统分析与设计精品课程</span></div>
	<li>课程介绍</li>
	<p>《信息系统分析与设计》是我院信息管理与信息系统专业、电子商务专业的核心专业课，同时，该课程还包含《信息系统分析与设计课程设计》分别记学分。</p>
	<p>《信息系统分析与设计》与《管理信息系统》之间的关系：这两门课在相当长一段时间内的教学定位不清楚。教育部管理科学与工程教学指导委员会于 2004年对管理科学与工程有关专业核心课程的设置进行了研讨，专门对“管理信息系统”和“信息系统分析与设计”进行了区分，专家经讨论后认为：管理信息系统课程是为管理者设置的，作为管理者必须了解的有关信息系统的内容、建设过程、存在的困难，是为非信管专业开设的；而信息系统分析与设计课程则作为从事信息系统建设的主管和系统分析设计人员设置的，必须对信息系统的分析和设计过程和有关工具、技术有熟练的理解与运用，是信息管理与信息系统专业、电子商务专业的核心课。</p>
	
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
		so.addVariable("CuPlayerFile","<%=basePath %>home/mis.flv"); //视频文件地址
		so.addVariable("CuPlayerImage","<%=basePath %>home/images/startmis.png");//视频略缩图,本图片文件必须正确
		so.addVariable("CuPlayerWidth","900"); //视频宽度
		so.addVariable("CuPlayerHeight","600"); //视频高度
		so.addVariable("CuPlayerAutoPlay","no"); //是否自动播放
		so.addVariable("CuPlayerLogo","<%=basePath %>home/images/Logo.png"); //Logo文件地址
		so.addVariable("CuPlayerPosition","top-right"); //Logo显示的位置 
		so.write("CuPlayer");
	</script>
	
	<li>课程大纲</li>
	<p>第一章 绪论 （4个学时讲授） 学习方法，学习资料，学习内容, 对一些项目进行案例分析，掌握系统总体规划方法；提出小组调研对象，研究其中的管理困境</p>
	<p>第二章 信息系统相关基本概念与基本理论（4学时教授）数据，信息，知识，智慧，系统，大数据，APP等</p>
	<p>第三章 信息系统建设的思路与方法（2学时教授）结构化方法、面向对象方法、原型法、CASE方法</p>
	<p>第四章 信息系统的总体规划方法（4学时，2学时案例讲解，2学时实践调研）</p>
	<p>第五章 信息系统的分析（实践学习4学时），结构化方法的分析（业务流程图、数据流程图、数据字典） </p>
	<p>第六章 信息系统的设计（实践学习4学时，结构化方法、面向对象方法的设计</p>
	<p>第七章 系统的实现方法与路径（4学时，开发工程授课）</p>
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
	<script type="text/javascript" src="<%=basePath %>mis/js/show.js"></script>
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
	});
	</script>
</body>
</html>
