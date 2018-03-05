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
	<table id="dg" title="用户管理" class="easyui-datagrid"  fitColumns="true" pagination="true" rownumbers="true" url="${pageContext.request.contextPath}/system/powerUserList.do" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="userId" width="auto" align="center">用户ID</th>
				<th field="userName" width="auto" align="center">用户名</th>
				<th field="userTime" width="auto" align="center">添加时间</th>
			</tr>
		</thead>
	</table>
	<!-- 工具栏 -->
	<div id="tb">
		<div>
			<a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:openUserPermissionDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">设置权限</a>
			<a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
	</div>
	<!-- 添加修改 -->
	<div id="dlg" class="easyui-dialog" style="width: 700px;height: 300px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>登录账号：</td>
					<td>
						<input type="text" id="userLogId" name="userLogId" class="easyui-validatebox" required="true" style="width: 200px"/>
					</td>
				</tr>
				<tr>
					<td>登录密码：</td>
					<td>
						<input type="text" id="newPassword" name="newPassword" class="easyui-validatebox" style="width: 200px"value=""/>
					</td>
				</tr>
				<tr>
					<td>用户昵称：</td>
					<td>
						<input type="text" id="userNick" name="userNick" class="easyui-validatebox" required="true" style="width: 200px"/>
					</td>
				</tr>
				<tr>
					<td>所属角色：</td>
					<td>
						<select class="easyui-combobox" style="width: 154px" id="roleId" name="roleId" editable="false" panelHeight="auto">
							<option value="0">请选择所属角色...</option>
							<c:if test="${USER.roleId == 1 }">
								<option value="1">超级管理员</option>
							</c:if>
								<option value="2">管理员</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>所属部门：</td>
					<td>
						<select class="easyui-combobox" style="width: 154px" id="departmentId" name="departmentId" editable="false" panelHeight="auto">
							<option value="0">请选择所属部门...</option>
							<c:forEach var="department" items="${applicationScope.departmentTypes }">
								<option value="${department.departmentId }">${department.departmentName }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<c:if test="${USER.roleId == 1 }">
				<tr style="display: none;" id="manageDepartment">
					<td>管理部门：</td>
					<td>
						<select class="easyui-combogrid" style="width:250px" id="deptIds" data-options="
								panelWidth: 250,
								multiple: true,
								idField: 'departmentId',
								textField: 'departmentName',
								url: '${pageContext.request.contextPath}/system/departmentList.do',
								columns: [[
									{field:'ck',checkbox:true},
									{field:'departmentId',title:'部门序号',width:80,align:'center'},
									{field:'departmentName',title:'部门名称',width:170,align:'center'}
								]],
								fitColumns: true">
						</select>
					</td>
				</tr>
				</c:if>
				<tr style="display: none;">
					<td>
						<input type="text" id="departmentIds" name="departmentIds">
					</td>
				</tr>
				<tr>
					<td>当前状态：</td>
					<td>
					<span class="radioSpan">
		                <input type="radio" name="statusId" value="0">禁止登录</input>
		                <input type="radio" name="statusId" value="1">允许登录</input>
		            </span>
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
	<div id="dlgp" class="easyui-dialog" style="width: 700px;height: 300px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fmp" method="post">
			<table cellspacing="8px">
				<tr>
					<td>登录账号：</td>
					<td>
						<input type="text" id="userLogId" name="userLogId" class="easyui-validatebox" required="true" readonly="readonly" style="width: 200px"/>
					</td>
				</tr>
				<tr>
					<td>用户昵称：</td>
					<td>
						<input type="text" id="userNick" name="userNick" class="easyui-validatebox" required="true" readonly="readonly" style="width: 200px"/>
					</td>
				</tr>
				<tr>
					<td>设置权限</td>
					<td>
						<ul id="tt" class="easyui-tree" data-options="url:'${pageContext.request.contextPath}/system/permissionList.do',animate:true,checkbox:true,lines:true"></ul>
					</td>
				</tr>
				<tr style="display: none;">
					<td></td>
					<td>
						<input type="text" id="permissionIds" name="permissionIds">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 保存关闭 -->
	<div id="dlg-buttons">
		<a href="javascript:saveUserPermission()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeUserPermissionDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
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
		$('#roleId').combobox('select', '0');
		$('#departmentId').combobox('select', '0');
		document.getElementsByName("statusId")[1].checked = true;
		$("#dlg").dialog("open").dialog("setTitle","添加用户");
		url = "${pageContext.request.contextPath}/system/doUserSave.do";
	}
	
	/*打开修改*/
	function openUserModifyDialog() {
		$('#fm').form('clear');//清空窗体数据
		$('#userPassword').val("");
		// 获取选中行
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length != 1){
			$.messager.alert("系统提示","请选择一条修改记录，进行修改！");
			return;
		}
		$("#dlg").dialog("open").dialog("setTitle","修改用户");
		var row= selectedRows[0];
		$("#fm").form("load",row);
		
		$.get("${pageContext.request.contextPath}/system/findUserById.do?userId="+row.userId,function(data,status){
			data=eval("("+data+")");
			// 更新其它数据
			$('#roleId').combobox('select', data.roleId);
			$('#departmentId').combobox('select', data.departmentId);
			
			if(data.roleId == 2){
				var deptIds = "";
				var departmentIds = "";
				$.each(data.departmentList,function(n,value) {
					deptIds += value.departmentId
					departmentIds += value.departmentId+",";
				});
				$('#deptIds').combogrid('setValues', deptIds);
				departmentIds = departmentIds.substring(0, departmentIds.length - 1);
				$('#departmentIds').val(departmentIds);
			}
		});
		url = "${pageContext.request.contextPath}/system/doUserSave.do?userId="+row.userId;
	}
	
	/*执行保存*/
	function saveUser(){
		
		var val = $('#deptIds').combogrid('getValues');
		$('#departmentIds').val(val);
		
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
	
	/*打开修改权限对话框*/
	function openUserPermissionDialog(){
		
		$('#fmp').form('clear');//清空窗体数据
		
		// 获取选中行
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length != 1){
			$.messager.alert("系统提示","请选择一条修改记录，进行修改！");
			return;
		}
		$("#dlgp").dialog("open").dialog("setTitle","设置权限");
		var row= selectedRows[0];
		$("#fmp").form("load",row);
		
		//先将回显数据全部清除  
		var root=$("#tt").tree('getRoot');
		$("#tt").tree('uncheck',root.target);
		
		$.get("${pageContext.request.contextPath}/system/findUserById.do?userId="+row.userId,function(data,status){
			data=eval("("+data+")");
			// 更新数据
			$.each(data.permissionList,function(n, value) {
				if(value.permissionEnd == 1){
					var node = $('#tt').tree('find', value.permissionId);
					$('#tt').tree('check', node.target);
				}
			});
		});
		url = "${pageContext.request.contextPath}/system/doUserPermissionSave.do?userId="+row.userId;
	}
	
	/*保存权限*/
	function saveUserPermission(){
	
		var nodes = $('#tt').tree('getChecked','indeterminate');  
        var nodes1 = $('#tt').tree('getChecked');
        
        var s = '';  
        for(var i=0; i<nodes.length; i++){  
            if (s != ''){ s += ','};  
            s += nodes[i].id;  
        }  
        
        for(var i=0; i<nodes1.length; i++){  
            if (s != ''){ s += ','};  
            s += nodes1[i].id;  
        }
		
		$('#permissionIds').val(s);
		
		$("#fmp").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				var result=eval('('+result+')');
				if(result.success){
					$.messager.alert("系统提示","保存成功！");
					$("#dlgp").dialog("close");
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
	
	/*执行删除*/
	function deleteUser() {
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length == 0){
			$.messager.alert("系统提示","请选择一条或多条记录，进行删除！");
			return;
		}
		var strIds=[];
		for(var i = 0; i< selectedRows.length; i++){
			strIds.push(selectedRows[i].userId);
		}
		// 每个原素增加一个字符
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确定要删除这<font color=red>&nbsp;"+ selectedRows.length +"&nbsp;</font>条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/system/doUserDelete.do",{ids:ids},function(result){
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
	
	/*格式化角色*/
	function formatRole(val, row){
		if(val == 1){
			return "超级管理员";
		}else{
			return "管理员";
		}
	}
	
	/*格式化状态*/
	function formatStatus(val, row){
		if(val == 1){
			return "<span style=\"color:green;\">允许登录</span>";
		}else {
			return "<span style=\"color:red;\">禁止登录</span>";	
		}
	}
	
	$(function (){
		/*是否显示管理部门*/
		$('#roleId').combobox({
	            onSelect : function(param){
	            	roleId = param.value;
					if(roleId ==2){
						$('#manageDepartment').show();
					}else{
						$('#manageDepartment').hide();
					}
	        }
		});
	});
</script>