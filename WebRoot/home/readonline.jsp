<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">	
<head>
<title>在线预览</title>
<script type="text/javascript" src="<%=basePath %>home/js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>home/js/flexpaper_flash.js"></script>
<script type="text/javascript" src="<%=basePath %>home/js/flexpaper_flash_debug.js"></script>
</head>
  <body> 
        <div style="position:absolute;left:10px;top:10px;">
        	<%-- 指定flexPaper的宽度和高度  --%>   
            <a id="viewerPlaceHolder" style="width:1200px;height:900px;display:block"></a>  
            <script type="text/javascript">
                var fp = new FlexPaperViewer(
                         '<%=basePath %>home/FlexPaperViewer', 
                         'viewerPlaceHolder',     <!--对应于a 标签的id-->
                         { config : {
                         SwfFile : escape('<%=basePath %>files/<%=(String)session.getAttribute("dir")%>/convert/<%=(String)session.getAttribute("fileName")%>'), 
                         Scale : 0.6, 
                         ZoomTransition : 'easeOut',
                         ZoomTime : 0.5,
                         ZoomInterval : 0.2,
                         FitPageOnLoad : true,
                         FitWidthOnLoad : false,
                         PrintEnabled : true,<%-- 是否可以打印  --%>
                         FullScreenAsMaxWindow : false,
                         ProgressiveLoading : false,
                         MinZoomSize : 0.2,
                         MaxZoomSize : 5,
                         SearchMatchAll : false,
                         InitViewMode : 'Portrait',
                         
                         ViewModeToolsVisible : true,
                         ZoomToolsVisible : true,
                         NavToolsVisible : true,
                         CursorToolsVisible : true,
                         SearchToolsVisible : true,
                           localeChain: 'en_US'
                         }});
            </script>
        </div>
</body>
</html>
