var Upload={};

Upload.query=function(){
	Upload.queryFile();
}

Upload.queryFile=function()
{		
	var data={};
	data.pageSize=10;
	var rand = Math.random();
	data.pageNo=1;
	data.rand = rand;
	data.dir='mis';
	data.category='save';
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
					var filenum="";
					for(var i=start;i<end;i++){
						var obj = data[i];
						FileHtml +='  <div class="item global-clearfix"><div style="width: 40%" class="col c1">'+obj.filename+'</div><div style="width: 16%;" class="col">'+obj.size+'</div><div style="width: 23%;" class="col">'+obj.modify+'</div><div style="width: 20%;" class="col"><a href="'+basePath +'pages/DownLoad/TransferFile.do?filename='+obj.filename+'&dir=mis&category=class">设置为在线课程</a> | <a href="'+basePath +'pages/DownLoad/TransferFile.do?filename='+obj.filename+'&dir=mis&category=mat">设置为实验素材</a> | <a href="'+basePath +'pages/DownLoad/TransferFile.do?filename='+obj.filename+'&dir=mis&category=stu">设置为学生作品</a> | <a class="del" href="javascript:;">删除</a></div></div>';
					}
					filenum = '<span class="loaded" >已加载全部文件，共'+result.total+'个</span>';
				}
				$("#FileHtml").html(FileHtml);
				$("#filenum").html(filenum);
			}
		}
	});
}

Upload.Search=function()
{	
	var filename=$("#keyword").val();
	var data={};
	data.pageSize=10;
	var rand = Math.random();
	data.pageNo=1;
	data.rand = rand;
	data.filename=filename;
	data.dir='mis';
	var myurl = basePath+"pages/Upload/SearchFile.do";
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
				$("#FileHtml").html("");
				$("#filenum").html("");
				var data = result.jsonData;
				if(data!=[] && data!="" && data.length!=0){
					var FileHtml = "";
					var filenum="";
					for(var i=start;i<end;i++){
						var obj = data[i];
						FileHtml +='  <div class="item global-clearfix"><div style="width: 40%" class="col c1">'+obj.filename+'</div><div style="width: 16%;" class="col">'+obj.size+'</div><div style="width: 23%;" class="col">'+obj.modify+'</div><div style="width: 20%;" class="col"><a href="'+basePath +'pages/DownLoad/TransferFile.do?filename='+obj.filename+'&dir=mis&category=class">设置为在线课程</a> | <a href="'+basePath +'pages/DownLoad/TransferFile.do?filename='+obj.filename+'&dir=mis&category=mat">设置为实验素材</a> | <a href="'+basePath +'pages/DownLoad/TransferFile.do?filename='+obj.filename+'&dir=mis&category=stu">设置为学生作品</a> | <a class="del" href="javascript:;">删除</a></div></div>';
					}
					filenum = '<span class="loaded" >已加载全部文件，共'+result.total+'个</span>';
				}
				$("#FileHtml").html(FileHtml);
				$("#filenum").html(filenum);
			}
		}
	});
}

//删除文件
$(".list-view-home").on('click','a.del',function(){
	
	var myurl=basePath+"pages/DownLoad/DelFile.do";
	var filename=$(this).parent().parent().find(".col.c1").html();
	Prompt.add();
	Prompt.init({
		title : "请选择从什么地方将该文件删除",
		shade : true,
		opacity : 20,
		width : 550,
		height : 250,
		html : $('.choose_class').html(),
		ConfirmFun : a1,
        CancelFun : a2
		});
		function a1(){
			var type=$("input[name='cType']:checked").val();
			var dir='mis';
			$.ajax({
				   type: "POST",
				   url:  myurl,	
				   async: true,
				   data:{filename:filename,category:type,dir:dir},
				   dataType:"json",
				   success: function(result){
					   MU.msgTips('warn',"用户删除成功",1000,function(){
						   location.reload();
					   });
				   }
				});
		}
		function a2(){
	}
})