		$(function(){
			jQuery("#RightAccordion").accordion({ //初始化accordion
				fillSpace:true,
				fit:true,
				border:false,
				animate:false  
			});
			$.post("/@info/Home/GetTreeByEasyui", { "id": "0" }, //获取第一层目录
			   function (data) {
				   if (data == "0") {
					   window.location = "/Account";
				   }
				   $.each(data, function (i, e) {//循环创建手风琴的项
					   var id = e.id;
					   $('#RightAccordion').accordion('add', {
						   title: e.text,
						   content: "<ul id='tree"+id+"' ></ul>",
						   selected: true,
						   iconCls:e.iconCls//e.Icon
					   });
					   $.parser.parse();
					   $.post("/@info/Home/GetTreeByEasyui?id="+id,  function(data) {//循环创建树的项
						   $("#tree" + id).tree({
							   data: data,
							   onBeforeExpand:function(node,param){  
								   $("#tree" + id).tree('options').url = "/@info/Home/GetTreeByEasyui?id=" + node.id;
							   },   
							   onClick : function(node){  
								   if (node.state == 'closed'){  
									   $(this).tree('expand', node.target);  
								   }else if (node.state == 'open'){  
									   $(this).tree('collapse', node.target);  
								   }else{
									   var tabTitle = node.text;
									   var url = "../../" + node.attributes;
									   var icon = node.iconCls;
									   addTab(tabTitle, url, icon);
								   }
							   }
						   });
					   }, 'json');
				   });
			   }, "json");
		});

		
		$('#tt').tree({
			data: [{
				text: '妈妈咪三',
				state: 'closed',
				children: [{
					text: 'Item11'
				},{
					text: 'Item12'
				}]
			},{
				text: 'Item2'
			}]
		});