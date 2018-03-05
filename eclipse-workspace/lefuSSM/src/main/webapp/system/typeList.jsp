<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="include/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="include/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.min.js"></script>
</head>
<body>
	<!-- 数据显示 -->
	<table id="dg" title="类型列表" class="easyui-treegrid" data-options="url: '${pageContext.request.contextPath}/system/typeList.do',
				rownumbers: true,
				fit: true,//自适应大小
				nowrap: true,//数据长度超出列宽时将会自动截取。
				rownumbers:true,//行号
				fitColumns:true,//自动使列适应表格宽度以防止出现水平滚动。
				idField: 'id',
				treeField: 'text'
			"  toolbar="#tb">
		<thead>
			<tr>
				<th data-options="field:'id'" width="*">ID</th>
				<th data-options="field:'text'" width="*">名称</th>
				<th data-options="field:'pid'" width="*">父级ID</th>
				<!-- <th data-options="field:'url'" width="150">跳转路径</th> 
				<th data-options="field:'isNavigation'" width="80"  formatter="formatStatus">是否为导航菜单</th>
				<th data-options="field:'isNext'" width="80"  formatter="formatStatus">是否有子分类</th>-->
			</tr>
		</thead>
	</table>
	<!-- 工具栏 -->
	<div id="tb">
		<div>
			<a href="javascript:openTypeAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openTypeModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:deleteType()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
	</div>
	<!-- 添加修改 -->
	<div id="dlg" class="easyui-dialog" style="width: 700px;height: 250px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>分类名称：(只能添加二级分类，否则不能正常显示)</td>
					<td>
						<input type="text" id="typeName" name="typeName" class="easyui-validatebox" required="true" style="width: 250px"/>
					</td>
				</tr>
				<tr>
					<td>父级分类：</td>
					<td>
						<select class="easyui-combotree" id="typePid" name="typePid" style="width:256px;"/>
					</td>
				</tr>
				<!-- <tr>
					<td>是否为导航菜单：</td>
					<td>
						<input type="radio" name="isNavigation" value="0" />否
		                <input type="radio" name="isNavigation" value="1" />是
					</td>
				</tr>
				<tr>
					<td>是否有下级分类：</td>
					<td>
						<input type="radio" name="isNext" value="0" />否
		                <input type="radio" name="isNext" value="1" />是
					</td>
				</tr> -->
				<!-- <tr>
					<td>跳转路径：</td>
					<td>
						<select class="easyui-combobox" id="typeUrl" name="typeUrl">
							<option value="index.html">index.html（首页）</option>
							<option value="navigation.html">navigation.html（详细页）</option>
							<option value="navigationList.html">navigationList.html（多条详细页）</option>
							<option value="navigationTableList.html">navigationTableList.html（列表页）</option>
							<option value="downloadList.html">downloadList.html（文档下载列表页）</option>
							<option value="download.html">download.html.html（文档下载详细页）</option>
						</select>
					</td>
				</tr> -->
			</table>
		</form>
	</div>
	<!-- 保存关闭 -->
	<div id="dlg-buttons">
		<a href="javascript:saveType()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeTypeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>
<!-- js -->
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="include/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	/*打开添加*/
	function openTypeAddDialog() {
		// 清空数据，以便下次使用
		resetValue();
		//document.getElementsByName("isNavigation")[0].checked = true;
		//document.getElementsByName("isNext")[0].checked = true;
		$("#dlg").dialog("open").dialog("setTitle","添加分类");
		url = "${pageContext.request.contextPath}/system/doTypeSave.do";
		$('#typePid').combotree({
			url:"${pageContext.request.contextPath}/system/typeList.do"
		});
	}
	
	/*打开修改*/
	function openTypeModifyDialog() {
		$('#typePid').combotree({
			url:"${pageContext.request.contextPath}/system/typeList.do"
		});
		// 获取选中行
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length != 1){
			$.messager.alert("系统提示","请选择一条修改记录，进行修改！");
			return;
		}
		$("#dlg").dialog("open").dialog("setTitle","修改分类");
		var row= selectedRows[0];
		
		$("#typeName").val(row.text);
		$("#typeUrl").val(row.url);
		$('#typePid').combotree('setValue', row.pid);
		
		$("#fm").form("load",row);
		url = "${pageContext.request.contextPath}/system/doTypeSave.do?typeId="+row.id;
	}
	
	/*执行保存*/
	function saveType(){
		
		var val = $('#typePid').combogrid('getValues');
		
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success){
					$.messager.alert("系统提示","保存成功！");
					// 清空数据，以便下次使用
					resetValue();
					$("#dlg").dialog("close");
					$('#dg').treegrid('reload');
				}else if(result.error){
					$.messager.alert("系统提示", result.error);
				}else{
					$.messager.alert("系统提示","保存失败！");
					return;
				}
			}
		});

	}
	
	/*执行删除*/
	function deleteType() {
		
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length == 0){
			$.messager.alert("系统提示","请选择一条或多条记录，进行删除！");
			return;
		}
		
		var row= selectedRows[0];
		
		$.messager.confirm("系统提示","您确定要删除分类名称为<font color=red>&nbsp;"+ row.text +"&nbsp;</font>的数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/system/doTypeDelete.do",{typeId:row.id},function(result){
					if(result.success){
						if(result.exist){
							$.messager.alert("系统提示",result.exist);
						}else{
							$.messager.alert("系统提示","数据已成功删除！");							
						}
						$("#dg").treegrid("reload");
					}else if(result.error){
						$.messager.alert("系统提示", result.error);
					}else{
						$.messager.alert("系统提示","数据删除失败！");
					}
				},"json");
			}
		});
	}
	
	/*格式化状态*/
	function formatStatus(val, row){
		if(val == 1){
			return "<span style=\"color:green;\">是</span>";
		}else {
			return "<span style=\"color:red;\">否</span>";	
		}
	}
	
	/*清空数据*/
	function resetValue() {
		$('#typeName').val("");
		$('#typePid').combotree('setValue', "根分类");
	}
	
	/*关闭对话框*/
	function closeTypeDialog() {
		$('#dlg').dialog("close");
		// 重新加载数据
		$("#dg").treegrid("reload");
	}
</script>