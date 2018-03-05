<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="include/jquery-easyui-1.3.3/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="include/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.min.js"></script>
</head>
<body>
	<!-- 数据显示 -->
	<table id="dg" title="技嘉显卡管理" class="easyui-datagrid"  fitColumns="true" pagination="true" rownumbers="true" url="${pageContext.request.contextPath}/system/videoCardList.do" fit="true" toolbar="#tb" Style="fit:true">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" hidden="true" align="center" >编号</th>
				<th field="type"  align="center">技嘉显卡型号</th>
				<th field="agency_price" align="center">代理价</th>
				<th field="jingdong_price" align="center" >京东零售价</th>
				<th field="tianmao_price" align="center" >天猫建议零售价</th>
				<th field="Cdian_price" align="center">C店建议零售价</th>
				<th field="core_clock" align="center">核心频率</th>
				<th field="memory_clock" align="center">显存频率</th>
				<th field="SP_amount" align="center">SP数量（个）</th>
				<th field="video_memory_size" hidden="true" align="center">内存大小</th>
				<th field="bit_width" align="center">位宽</th>
				<th field="output_interface" align="center">输出接口</th>
				<th field="power_consumption" align="center" >显卡功耗</th>
				<th field="slot" align="center" >PCI槽使用</th>
				<th field="PCB_dimension" align="center">PCB尺寸</th>
				<th field="card_dimension" align="center">卡尺寸</th>
				<th field="amount_per_box" align="center">包装:个/箱</th>
				<th field="cooling_solution" align="center">散热方案</th>
				<th field="illustrate" align="center">说明</th>
				<th field="video_core" align="center">显示核心</th>
				<th field="one_level_name" align="center">一级分类</th>
				<th field="two_level_name" align="center">二级分类</th>
				<th data-options="field:'picture_name1',align:'center',formatter:imgFormatter">图片预览</th> 
				<th field="state" align="center" formatter="formatStatus">当前状态</th>
				<th field="add_time" align="center">添加时间</th>
			</tr>
		</thead>
	</table>
	<!-- 工具栏 -->
	<div id="tb">
		<div>
			<a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
			<!--  <a href="javascript:updateComputerState()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改状态</a>-->
			<a href="javascript:searchTitle()" class="easyui-linkbutton" iconCls="icon-search" plain="true" style="float:right">商品型号</a>
			<input type="text" id="type" size="20" onkeydown="if(event.keyCode==13) searchTitle()" style="float:right"/>
		</div>
	</div>
	<!-- 添加修改 -->
	<div id="dlg" class="easyui-dialog" style="width: 700px;height: 300px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post" enctype="multipart/form-data" formaction="register">
			<table cellspacing="8px">
				<tr>
					<td>技嘉显卡型号：</td>
					<td><input type="text" id="type" name="type" class="easyui-validatebox" style="width: 200px"/></td>
				</tr>
				<tr>
					<td>代理价：</td>
					<td><input type="text" id="agency_price" name="agency_price" class="easyui-validatebox" required="true" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>京东零售价：</td>
					<td><input type="text" id="jingdong_price" name="jingdong_price" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>天猫建议零售价：</td>
					<td><input type="text" id="tianmao_price" name="tianmao_price" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>C店建议零售价：</td>
					<td><input type="text" id="Cdian_price" name="Cdian_price" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>核心频率：</td>
					<td><input type="text" id="core_clock" name="core_clock" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>显存频率：</td>
					<td><input type="text" id="memory_clock" name="memory_clock" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>SP数量（个）：</td>
					<td><input type="text" id="SP_amount" name="SP_amount" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>内存大小：</td>
					<td><input type="text" id="video_memory_size" name="video_memory_size" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>位宽：</td>
					<td><input type="text" id="bit_width" name="bit_width" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>输出接口：</td>
					<td><input type="text" id="output_interface" name="output_interface" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>显卡功耗：</td>
					<td><input type="text" id="power_consumption" name="power_consumption" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>PCI槽使用：</td>
					<td><input type="text" id="slot" name="slot" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>PCB尺寸：</td>
					<td><input type="text" id="PCB_dimension" name="PCB_dimension" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>卡尺寸：</td>
					<td><input type="text" id="card_dimension" name="card_dimension" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>包装:个/箱：</td>
					<td><input type="text" id="amount_per_box" name="amount_per_box" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>散热方案：</td>
					<td><input type="text" id="cooling_solution" name="cooling_solution" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>说明：</td>
					<td><input type="text" id="illustrate" name="illustrate" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>显示核心：</td>
					<td><input type="text" id="video_core" name="video_core" class="easyui-validatebox" style="width: 200px"value=""/></td>
				</tr>
				<tr>
					<td>当前状态：</td>
					<td>
					<span class="radioSpan">
		                <input type="radio" name="state" value="0">下架</input>
		                <input type="radio" name="state" value="1">上架</input>
		            </span>
					</td>
				</tr>
				<tr>
					<td> 图片1:</td>
					<td><input id="picture_name1" style="width:224px" runat="server" name="photos" onchange="javascript:setImagePreview(this,localImag,preview);" type="file" />
					</td>
				</tr>
				<tr>
					<td>一级分类：</td>
					<td>
						<select class="easyui-combogrid" name="one_level_id" style="width:250px" id="deptIds" required="true" data-options="
								panelWidth: 250,
								multiple: true,
								idField: 'one_level_id',
								textField: 'one_level_name',
								url: '${pageContext.request.contextPath}/system/oneLevelList.do',
								columns: [[
									{field:'ck',checkbox:true},
									{field:'one_level_id',title:'一级分类序号',width:80,align:'center'},
									{field:'one_level_name',title:'一级分类名称',width:170,align:'center'}
								]],
								fitColumns: true">
						</select>
					</td>
				</tr>
				<tr>
					<td>二级分类：</td>
					<td>
						<select class="easyui-combogrid" name="two_level_id" style="width:250px" id="deptIds" required="true" data-options="
								panelWidth: 250,
								multiple: true,
								idField: 'two_level_id',
								textField: 'two_level_name',
								url: '${pageContext.request.contextPath}/system/twoLevelList.do',
								columns: [[
									{field:'ck',checkbox:true},
									{field:'two_level_id',title:'二级分类序号',width:80,align:'center'},
									{field:'two_level_name',title:'二级分类名称',width:170,align:'center'}
								]],
								fitColumns: true">
						</select>
					</td>
				</tr>			
			</table>
		</form>
	</div>
	<!-- 保存关闭 -->
	<div id="dlg-buttons">
		<a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>
<!-- js -->
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="include/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	/*打开添加*/
	function openUserAddDialog() {
		$('#fm').form('clear');//清空窗体数据
		$('#one_level_id').combobox('select', '0');
		document.getElementsByName("state")[1].checked = true;
		$("#dlg").dialog("open").dialog("setTitle","添加商品");
		url = "${pageContext.request.contextPath}/system/videoCardSave.do";
	}
	/*打开修改*/
	function openUserModifyDialog() {
		$('#fm').form('clear');//清空窗体数据
		// 获取选中行
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length != 1){
			$.messager.alert("系统提示","请选择一条修改记录，进行修改！");
			return;
		}
		$("#dlg").dialog("open").dialog("setTitle","修改商品信息");
		var row= selectedRows[0];
		$("#fm").form("load",row);
		
		$.get("${pageContext.request.contextPath}/system/videoCardList.do?id="+row.id,function(data,status){
			data=eval("("+data+")");
		});
		url = "${pageContext.request.contextPath}/system/videoCardSave.do?id="+row.id;
	}
	
	/*执行保存*/
	function saveUser(){
				
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success){
					$.messager.alert("系统提示","保存成功！");
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}else if(result.error){
					$.messager.alert("系统提示", result.error);
				}else{
					$.messager.alert("系统提示","保存失败！");
					return;
				}
			}
		});
	}
	
	/*打开修改状态对话框*/
	function updateComputerState(){
		
		$('#fmp').form('clear');//清空窗体数据
		
		// 获取选中行
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length != 1){
			$.messager.alert("系统提示","请选择一条修改记录，进行修改！");
			return;
		}
		var row= selectedRows[0];
		$("#fmp").form("load",row);
		
		$("#dlg").dialog("open").dialog("setTitle","修改商品信息");
		var row= selectedRows[0];
		$("#fm").form("load",row);
		
		//先将回显数据全部清除  
		var root=$("#tt").tree('getRoot');
		$("#tt").tree('uncheck',root.target);
		
		$.get("${pageContext.request.contextPath}/system/videoCardList.do?id="+row.id,function(data,status){
			data=eval("("+data+")");
			url = "${pageContext.request.contextPath}/system/videoCardSave.do?id="+row.id;
		})
	}
	
	/*格式化状态*/
	function formatStatus(val, row){
		if(val == 1){
			return "<a href=\"javascript:newsAudit("+row.id+", 0)\"><span style=\"color:green;\">上架</span></a>";
		}else {
			return "<a href=\"javascript:newsAudit("+row.id+", 1)\"><span style=\"color:red;\">下架</span></a>";	
		}
	}
	
	function newsAudit(id, state){
		$.post("${pageContext.request.contextPath}/system/videoCardSave.do",{id:id,state:state},function(result){
			if(result.success){
				if(result.exist){
					$.messager.alert("系统提示",result.exist);
				}else{
					$.messager.alert("系统提示","更改状态成功！");							
				}
				$("#dg").datagrid("reload");
			}else if(result.error){
				$.messager.alert("系统提示", result.error);
			}else{
				$.messager.alert("系统提示","更改状态失败！");
			}
		},"json");
	}
	
	/*执行删除*/
	function deleteUser() {
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length == 0){
			$.messager.alert("系统提示","请选择一条或多条记录，进行删除！");
			return;
		}
		var strIds=[];
		for(var i = 0; i< selectedRows.length; i++){
			strIds.push(selectedRows[i].id);
		}
		// 每个原素增加一个字符
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确定要删除这<font color=red>&nbsp;"+ selectedRows.length +"&nbsp;</font>条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/system/videoCardDelete.do",{ids:ids},function(result){
					if(result.success){
						if(result.exist){
							$.messager.alert("系统提示",result.exist);
						}else{
							$.messager.alert("系统提示","数据已成功删除！");							
						}
						$("#dg").datagrid("reload");
					}else if(result.error){
						$.messager.alert("系统提示", result.error);
					}else{
						$.messager.alert("系统提示","数据删除失败！");
					}
				},"json");
			}
		});
	}
	
	/*关闭对话框*/
	function closeUserDialog() {
		$('#dlg').dialog("close");
		// 重新加载数据
		$("#dg").datagrid("reload");
	}
	
	/*关闭对话框*/
	function closeUserPermissionDialog() {
		$('#dlgp').dialog("close");
		// 重新加载数据
		$("#dg").datagrid("reload");
	}
	
	//检查图片的格式是否正确,同时实现预览
    function setImagePreview(obj, localImagId, imgObjPreview) {
        var array = new Array('gif', 'jpeg', 'png', 'jpg', 'bmp'); //可以上传的文件类型
        if (obj.value == '') {
            $.messager.alert("让选择要上传的图片!");
            return false;
        }
        else {
            var fileContentType = obj.value.match(/^(.*)(\.)(.{1,8})$/)[3]; //这个文件类型正则很有用 
            //布尔型变量
            var isExists = false;
            //循环判断图片的格式是否正确
            for (var i in array) {
                if (fileContentType.toLowerCase() == array[i].toLowerCase()) {
                    //图片格式正确之后，根据浏览器的不同设置图片的大小
                    if (obj.files && obj.files[0]) {
                        //火狐下，直接设img属性 
                        imgObjPreview.style.display = 'block';
                        imgObjPreview.style.width = '400px';
                        imgObjPreview.style.height = '400px';
                        //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式 
                        imgObjPreview.src = window.URL.createObjectURL(obj.files[0]);
                    }
                    else {
                        //IE下，使用滤镜 
                        obj.select();
                        var imgSrc = document.selection.createRange().text;
                        //必须设置初始大小 
                        localImagId.style.width = "400px";
                        localImagId.style.height = "400px";
                        //图片异常的捕捉，防止用户修改后缀来伪造图片 
                        try {
                            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader=").src = imgSrc;
                        }
                        catch (e) {
                            $.messager.alert("您上传的图片格式不正确，请重新选择!");
                            return false;
                        }
                        imgObjPreview.style.display = 'none';
                        document.selection.empty();
                    }
                    isExists = true;
                    return true;
                }
            }
            if (isExists == false) {
                $.messager.alert("上传图片类型不正确!");
                return false;
            }
            return false;
        }
    }
    //图片添加路径  
    function imgFormatter(value,row,index){  
	  	if(value!=null){	  		
	        return  "<img src='../upload/pic/"+value+"' style="+"width:50px;height:30px;"+"/>";   
	  	}else{
	  		return  "<img src='' style="+"width:50px;height:30px;"+"/>";
	  	}
        } 
    /*检索*/
	function searchTitle(){
		$("#dg").datagrid("load",{
			"type":$("#type").val()
			
		});
	}
</script>