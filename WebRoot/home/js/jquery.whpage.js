(function($) {//异步分页
	$.fn.whpage = function(set) {
		set = jQuery.extend({       //参数初始化，默认设置
 			url: "",
			type: "front",//前端分页 后台分页区分
			action: 'get',
			data: {},
			page: 1,
			cur: 'current', //当前页
			next: '下一页',
			prev: '上一页',
			dis: 'disabled',//不能点击样式
			recond: 'reconds',//总记录样式
			count: 'count',//总页数
			nextClass: 'next',
			prevClass: 'prev',
			timeout: '25000',
			pagesize: 10,
			format: function(msg,page,pagesize){ return msg;},//分页数据不同类型的获取
			insert: function(msg,start,end){},
			showNum : 5
		},set);
		var self = this;//当前对象 赋值
 		function init(){
			ajax(set.page);
		}
		function ajax(page){
			set.data['page'] = page;
			$.ajax({
				type:set.action,
				url:set.url,
				data:set.data,
				dataType:'json',
				timeout:set.timeout,
				success:function(msg){
					var data = set.format(msg,set.page,set.pagesize);
					var cur = parseInt(data.cur);
					var count = parseInt(data.pageCount);
					var records = parseInt(data.records);
					if(set.type != 'front'){
						self.data = msg;
						var end = set.pagesize > records ? records : set.pagesize;
						set.insert(self.data,0,end);
					}
					handle(cur,count,records);
					bind();	
				},
				error:function(request,status,error){
				}	   
			});
		}
		function handle(cur,total,records){
			var html = [];
			var start = parseInt(cur) - set.showNum;
			var end = parseInt(cur) + set.showNum;
			var cur = cur > total ? total : cur;
			if(cur > 1){
				html.push('<a href="javascript:;" class="'+set.prevClass+'">'+set.prev+'</a>');
			}
			if(start <= 1){
				start = 1;
				end = end < 10 ? end : 10;
			}else{
				html.push('<a href="javascript:;">1...</a>');	
			}
			end = end >= total ? total : end;
			if(total - end <= 1){
				var endstr = '';
			}else{
				var endstr = '<a href="javascript:;">...'+total+'</a>';	
			}
			if(end > 1){
				for(pg = start;pg<=end;pg++){
					if(cur == pg){
						html.push('<span class="'+set.cur+'">'+pg+'</span>');
					}else{
						html.push('<a href="javascript:;">'+pg+'</a>');
					}
				}
			}
			html.push(endstr);
			if(cur < total){
				html.push('<a href="javascript:;" class="'+set.nextClass+'">'+set.next+'</a>');
			}
			if(total > 1){
				html.push('<span class="wh-page">到<input type="text" name="jump_url"></span><a class="pages-goto" href="javascript:;">确定</a>');
			}
			$(self).html(html.join(""));
		}
		function bind(){
			$(self).find('a').unbind('click').bind('click',function(){
				var page = $(this).html();
				var cur = parseInt($(self).find('.'+set.cur).text());
				if(page == set.next){
					page = cur+1;
				}else if(page == set.prev){
					page = cur-1;
				}else{
					page = page.replace(/[^0-9]/ig,"");	
				}
				if(page == NaN || page == 0 || page == ""){page =1}
				if(set.type == 'front'){
					ajax(page);
				}else{
					ajaxHtml(page);
				}
			});
			$(self).find('.pages-goto').unbind('click').bind('click',function(){
				var page = $(self).find('input[name=jump_url]').val();
				if(isNaN(page) || page.indexOf('.') > 0 || page == ''){
					MU.msgTips('error','请输入一个正整数');
					$(self).find('input[name=jump_url]').focus();
				}else{
					if(set.type == 'front'){
						ajax(page);
					}else{
						ajaxHtml(page);
					}
				}
			});
		}
		function ajaxHtml(page){
			var page = page || set.page;
			var data = set.format(self.data,page,set.pagesize);
			var count = parseInt(data.pageCount);
			var records = parseInt(data.records);
			if(page > count){
				page = count;	
			}
			var end = page * set.pagesize > records ? records : page * set.pagesize;
			var start = (page - 1) * set.pagesize;
			set.insert(self.data,start,end);
			handle(page,count,records);
			bind();
		}
 		return init();
	};//end	 	  
})(jQuery);