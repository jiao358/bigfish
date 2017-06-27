	function loadSelectCusMain(array){
		
		//alert($('#wu-form select').attr('dicType'));
		$(array).each(function(idx,obj){
			//alert(idx);
			var dic=$(obj).attr('dicType');
			
			$(obj).combobox({
				onSelect: function(param){
				}
			});

			
			  var options = {
			            url: '/bigfish/rdic.do',
			            type: 'get',
			            dataType: 'json',
			            data: {
						　　　　"dicName": dic,
						　　},
						async:false,
			            success: function (data) {
			            //	alert(data);
			            	var dataList=[];
			            	//append("<option value='"+value+"'>"+text+"</option>");
			            	$(data).each(function(dataidx,jsondata){
			            		var dicValue=jsondata.dicValue;
			            		var dicDes =jsondata.dicDesc;
			            		dataList.push({"value":dicValue,"text":dicDes});
			            		//$(obj).append("<option value='"+dicValue+"' >"+dicDes+"</option>");
			            	});
			            	 $(obj).combobox("loadData",dataList);
			            	//alert(JSON.stringify(data));
			            }
			        };
			  	
			  
			  	
				 	$.ajax(options); 
		});
		
	}
	

	function esteMessageEditError(){
		$.messager.alert('信息提示','加载异常','请重新打开');
	}
	
	

	
