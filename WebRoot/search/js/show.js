var show={};

show.query=function(){
	show.queryFile();
	show.queryImgFile();
	show.queryStuFile();
}

show.queryImgFile=function()
{		
	var data={};
	data.dir='search';
	var myurl = basePath+"pages/Upload/ShowImgFile.do";
	$.ajax({
		   type: "POST",
		   url:  myurl,	
		   async: true,
		   data:data,
		   dataType:"json",
		   success: function(result){
			   if((null==result)||(""==result))
				{
					return;
				}
				else
				{
					var jsonData = result.jsonData;
					if(jsonData != null && jsonData != "")
					{
						var ImgView = '';
						$(jsonData).each(function(idx,item){
							ImgView +='<div class="item enabled editEnabled" data-extname="docx" data-category="4" node-type="item"><a href="'+basePath +'pages/ReadOnline/ReadOnline.do?filename='+item.filename+'&dir=search"><div title="'+item.filename+'" class="thumb-large global-icon-62 global-icon-62-'+item.filefix+'"><span class="item-chk" node-type="item-chk"></span></div></a><div class="file-name"><a href="'+basePath +'pages/ReadOnline/ReadOnline.do?filename='+item.filename+'&dir=search" node-type="name">'+item.filename+'</a></div></div>';
						});
						$("#ImgView").html(ImgView);		
					}
					else
					{
						$("#ImgView").html("");
					}
				}
		   },
		  error:function(XmlHttpRequest,textStatus, errorThrown){
		   alert("保存失败;"+XmlHttpRequest.responseText+errorThrown);
		  	} 
		});
}

show.queryFile=function()
{		
	var data={};
	data.pageSize=10;
	var rand = Math.random();
	data.pageNo=1;
	data.rand = rand;
	data.dir='search';
	data.category='mat';
	var myurl = basePath+"pages/Upload/ShowFile.do";
	/**
	 * 前端分页
	 */
	$("#jg_ajax_page").whpage({
		url:myurl,
		data: data,
		showNum:5,
		type: 'java',
		pagesize: 10,
		cur: 'cur',
		action:'post',
		format: function(data,page,pagesize){
			var page = page || 1;
			var data = data.jsonData;
			var t = {};
			var records = parseInt(data.length);
			pageCount = Math.ceil(data.length / pagesize);
			t['cur'] = page;
			t['pageCount'] = pageCount;
			t['records'] = records;
			if(data.length>0){
				$("#jg_ajax_page").removeClass("hide");
			}else{
				$("#jg_ajax_page").removeClass("hide").addClass("hide");
			}
			return t;	
		},
		insert: function(result,start,end){
			if((null==result)||(""==result)){
				return;
			}
			else{
				var data = result.jsonData;
				if(data!=[] && data!="" && data.length!=0){
					var FileHtml = "";
					for(var i=start;i<end;i++){
						var obj = data[i];
						FileHtml +='  <div class="item global-clearfix"><div style="width: 40%" class="col c1"><a href="'+basePath +'pages/DownLoad/DownloadFile.do?filename='+obj.filename+'&dir=search">'+obj.filename+'</a></div><div style="width: 16%;" class="col">'+obj.size+'</div><div style="width: 23%;" class="col">'+obj.modify+'</div><div style="width: 20%;" class="col"><a href="'+basePath +'pages/DownLoad/DownloadFile.do?filename='+obj.filename+'&dir=search">点击下载</a></div></div>';
					}
				}
				$("#FileHtml").html(FileHtml);
			}
		}
	});
}

show.queryStuFile=function()
{		
	var data={};
	data.pageSize=10;
	var rand = Math.random();
	data.pageNo=1;
	data.rand = rand;
	data.dir='search';
	data.category='stu';
	var myurl = basePath+"pages/Upload/ShowFile.do";
	/**
	 * 前端分页
	 */
	$("#jg_ajax_page1").whpage({
		url:myurl,
		data: data,
		showNum:5,
		type: 'java',
		pagesize: 10,
		cur: 'cur',
		action:'post',
		format: function(data,page,pagesize){
			var page = page || 1;
			var data = data.jsonData;
			var t = {};
			var records = parseInt(data.length);
			pageCount = Math.ceil(data.length / pagesize);
			t['cur'] = page;
			t['pageCount'] = pageCount;
			t['records'] = records;
			if(data.length>0){
				$("#jg_ajax_page1").removeClass("hide");
			}else{
				$("#jg_ajax_page1").removeClass("hide").addClass("hide");
			}
			return t;	
		},
		insert: function(result,start,end){
			if((null==result)||(""==result)){
				return;
			}
			else{
				var data = result.jsonData;
				if(data!=[] && data!="" && data.length!=0){
					var FileHtml = "";
					for(var i=start;i<end;i++){
						var obj = data[i];
						FileHtml +='  <div class="item global-clearfix"><div style="width: 40%" class="col c1"><a href="'+basePath +'pages/DownLoad/DownloadFile.do?filename='+obj.filename+'&dir=search">'+obj.filename+'</a></div><div style="width: 16%;" class="col">'+obj.size+'</div><div style="width: 23%;" class="col">'+obj.modify+'</div><div style="width: 20%;" class="col"><a href="'+basePath +'pages/DownLoad/DownloadFile.do?filename='+obj.filename+'&dir=search">点击下载</a></div></div>';
					}
				}
				$("#FileHtml1").html(FileHtml);
			}
		}
	});
}
