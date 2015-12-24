<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath %>home/css/global.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>home/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	var basePath = "<%=basePath%>";
</script>
<title>信管与电子商务研究精品课程后台登录</title>
</head>
<body>
	<div class="wrapper">
		<div class="logo">信管与电子商务研究精品课程后台登录</div>
		<div class="container clearfix">
			<div class="banner">&nbsp;</div>
			<div class="login">
				<div class="form_tit">用户登录</div>
				<form name="f" >
					<ul class="form">
						<li>
	                    <span class="bor">
	                    <span class="login-ico"></span><input class="txt" id="username" name='username' type="text" value="" placeholder="请输入账号" />
	                    </span>
	                    </li>
	                    <li>
	                    <span class="bor">
	                    <span class="login-ico pwd"></span><input class="txt" id="password" type="password" name='password' value="" placeholder="请输入密码" />
	                    </span>
	                    </li>
	                    <li>
                    	<input class="txt-bor" value="" placeholder="验证码" id="code"/><img style="cursor:hand;cursor:pointer;" src='<%=basePath %>home/image.jsp' id='imgRand' onclick="javascript:this.src='<%=basePath %>home/image.jsp?a='+Math.random();">
                    	</li>
						<li class="li">
	                    	<input type="checkbox" class="checkbox checked" id="isAutoLogin" name="remember_me" checked=checked>两周内自动登录</input>
	                    </li>
						<li>
	                   		<a class="submit" id="submitLogin" href="#">登录</a>
	                    </li>
					</ul>
			</div>
		</div>
		</form>
	</div>
	
	<div class="choose_class hide">
		<ul class="class_list">
	    	<li><input type="radio" name="cType" value="mis" />信息系统分析与设计上传管理界面</li> 
			<li><input type="radio" name="cType" value="search" />搜索引擎技术与原理上传管理界面</li> 
	    </ul>	    
	</div> 
<script type="text/javascript" src="<%=basePath %>home/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>home/js/public.min.js"></script>
<script type="text/javascript" src="<%=basePath %>home/js/login.js"></script>
<script type="text/javascript" src="<%=basePath %>home/js/pop-window.js"></script>
</body>
</html>
