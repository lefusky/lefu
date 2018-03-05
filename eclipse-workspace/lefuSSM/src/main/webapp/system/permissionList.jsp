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
	<table id="dg" title="权限列表" class="easyui-treegrid" data-options="url: '${pageContext.request.contextPath}/system/permissionList.do',
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
				<th data-options="field:'text'" width="200">权限名称</th>
				<th data-options="field:'pid'"  align="center" width="100">父级ID</th>
				<th data-options="field:'isEnd'" align="center" width="100"  formatter="formatStatus">最终节点</th>
				<th data-options="field:'url'" width="200">权限路径</th>
				<th data-options="field:'desc'" align="center" width="300">权限描述</th>
			</tr>
		</thead>
	</table>
</body>
</html>
<!-- js -->
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="include/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
/*格式化状态*/
function formatStatus(val, row){
	if(val == 1){
		return "<span style=\"color:green;\">是</span>";
	}else {
		return "<span style=\"color:red;\">否</span>";	
	}
}
</script>