<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath %>home/css/file.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>home/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>home/css/login.css" rel="stylesheet" type="text/css" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>搜索引擎技术与原理课件上传管理界面</title>
</head>
<body>
<div class="yao-b">
    <div class="module-toolbar">
        <div class="bar global-clearfix" style="margin-left:15px;margin-top: 1%;">
            <div style="float:left;width:35%;height: 42px;">
	            <form name="upform" action= "<%=basePath %>pages/Upload/UploadFile.do?dir=search" method="POST" enctype="multipart/form-data">
	            <input type ="file" name= "file1" id="file1" />
	            <input type= "submit" value ="文件上传" style="width: 10%"/>
	            </form>
            </div>
            <div style="float:left;width:30%">
            <a href="<%=basePath %>search/show.jsp">搜索引擎技术与原理课件上传管理界面（点击进入前台）</a>
            </div>
	       	<div class="upload_search" style="margin-top:10px;height: 42px;">
				<div class="search">
				<input id="keyword" class="txt" type="text" placeholder="请输入文件名" value="">
				<a id="searchUser" class="submit" href="javascript:Upload.Search();">搜索</a>
				</div>
			</div>
        </div>
     </div>
    <div class="module-crumbs">
        <div class="title global-clearfix" id=filenum>
        </div>
    </div>
    <div class="module-list-view">
        <div class="list-view-home">
            <div class="title" style="padding-right: 0px;">        
                <div class="item global-clearfix">
                    <div style="width: 40%;" class="col c1">文件名</div>
                    <div style="width: 16%;" class="col">大小</div>
                    <div style="width: 23%;" class="col">修改日期</div>
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

<div class="choose_class hide">
<ul class="class_list">
	<li ><input type="radio" name="cType" value="save" />从搜索引擎管理文件系统中将该文件删除</li> 
   	<li ><input type="radio" name="cType" value="class" />从在线课程将该文件删除</li> 
	<li ><input type="radio" name="cType" value="mat" />从实验素材将该文件删除</li>
	<li ><input type="radio" name="cType" value="stu" />从学生作品将该文件删除</li> 
</ul>
</div> 

<script type="text/javascript" src="<%=basePath %>home/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>home/js/jquery.whpage.js"></script>
<script type="text/javascript" src="<%=basePath %>search/js/upload.js"></script>
<script type="text/javascript" src="<%=basePath %>home/js/pop-window.js"></script>

<script type="text/javascript">
var basePath = "<%=basePath%>";
$(document).ready(function()
{
	Upload.query();
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
