<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站后台管理</title>
<link rel="stylesheet" type="text/css" href="include/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="include/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.min.js"></script>
</head>
<body>
	<!-- 数据显示 -->
	<table id="dg" title="公告新闻管理" class="easyui-datagrid"  fitColumns="true" pagination="true" rownumbers="true" url="${pageContext.request.contextPath}/system/newsAfficheList.do" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="newsTitle"  width="550" align="center">新闻标题</th>
				<th field="addTime" width="100" align="center">发布时间</th>
				<th field="userNick" width="80" align="center">发布人</th>
				<!-- <th field="topId" width="50" align="center" formatter="formatTop">置顶</th> -->
				<th field="statusId" width="100" align="center" formatter="formatStatus">当前状态</th>
				<th field="newsId" width="50" align="center" formatter="formatBrowse">预览</th>
			</tr>
		</thead>
	</table>
	<!-- 工具栏 -->
	<div id="tb">
		<div>
			<a href="javascript:openNewsAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
			<a href="javascript:openNewsModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="javascript:newsDelete()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;标题：&nbsp;<input type="text" id="newsTitle" size="20" onkeydown="if(event.keyCode==13) searchTitle()"/>
			<a href="javascript:searchTitle()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
	<!-- 添加修改 -->
	<div id="dlg" class="easyui-dialog" style="width: 1000px; height: 520px; padding: 10px 10px" closed="true" buttons="#dlg-buttons" data-options="maximizable:true">
		<form id="fm" method="post">
			<table cellspacing="8px" style="width: 100%;">
				<tr>
					<td style="width: 10%;">标题：</td>
					<td style="width: 90%;">
						<input type="text" id="newsTitle" name="newsTitle" class="easyui-validatebox" style="width: 400px"required="true"/>
					</td>
				</tr>
				<tr>
					<td>新闻内容：</td>
					<td>
						<script id="editor" name="newsContent" type="text/plain" style="width:100%;height:500px;"></script>
					</td>
				</tr>
				<!-- <tr>
					<td>置顶：</td>
					<td>
						<input type="radio" name="topId" value="0" />否
		                <input type="radio" name="topId" value="1" />是
					</td>
				</tr> -->
			</table>
		</form>
	</div>
	<!-- 保存 -->
	<div id="dlg-buttons" style="text-align: center; margin-top: 5px;">
		<a href="javascript:saveNews()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeNewsDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>
<!-- js -->
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="include/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<!-- ueditor -->
<script type="text/javascript" src="include/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="include/ueditor/ueditor.all.js"> </script>
<script type="text/javascript" src="include/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	var url;
	
	//实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
	
	/*打开添加*/
	function openNewsAddDialog() {
		// 清空窗体数据
		$('#fm').form('clear');
		// 清空编辑器
		ue.setContent("");
		document.getElementsByName("topId")[0].checked = true;
		$("#dlg").dialog("open").dialog("setTitle","添加公告新闻");
		url = "${pageContext.request.contextPath}/system/doNewsAfficheSave.do";
	}
	
	/*打开修改*/
	function openNewsModifyDialog() {
		// 获取选中行
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length != 1){
			$.messager.alert("系统提示","请选择一条修改记录，进行修改！");
			return;
		}
		$("#dlg").dialog("open").dialog("setTitle","修改公告新闻");
		var row= selectedRows[0];
		$("#fm").form("load",row);
		
		$.post("${pageContext.request.contextPath}/system/findNewsAfficheById.do",{newsId:row.newsId},function(result){
			
			result=eval("("+result+")");
			
			if(result.error){
				$.messager.alert("系统提示", result.error);
			}else{
				// 设置编辑内容
		    	UE.getEditor('editor').setContent(result.newsContent);
			}
		});
		url = "${pageContext.request.contextPath}/system/doNewsAfficheSave.do?newsId="+row.newsId;
	}
	
	/*执行保存*/
	function saveNews(){
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
	
	/*执行删除*/
	function newsDelete() {
		var selectedRows=$("#dg").datagrid("getSelections");
		if(selectedRows.length == 0){
			$.messager.alert("系统提示","请选择一条或多条记录，进行删除！");
			return;
		}
		var strIds=[];
		for(var i = 0; i< selectedRows.length; i++){
			strIds.push(selectedRows[i].newsId);
		}
		// 每个原素增加一个字符
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确定要删除这<font color=red>&nbsp;"+ selectedRows.length +"&nbsp;</font>条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/system/doNewsAfficheDelete.do",{ids:ids},function(result){
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
	
	/*格式化状态*/
	function formatTop(val, row){
		if(val == 1){
			return "<a href=\"javascript:newsTop("+row.newsId+", 0)\"><span style=\"color:green;\">是</span></a>";
		}else {
			return "<a href=\"javascript:newsTop("+row.newsId+", 1)\"><span style=\"color:red;\">否</span></a>";	
		}
	}
	
	function newsTop(newsId, topId){
		$.post("${pageContext.request.contextPath}/system/doNewsAfficheTop.do",{newsId:newsId,topId:topId},function(result){
			if(result.success){
				if(result.exist){
					$.messager.alert("系统提示",result.exist);
				}else{
					$.messager.alert("系统提示","数据修改成功！");							
				}
				$("#dg").datagrid("reload");
			}else if(result.error){
				$.messager.alert("系统提示", result.error);
			}else{
				$.messager.alert("系统提示","数据修改失败！");
			}
		},"json");
	}
	
	/*格式化状态*/
	function formatStatus(val, row){
		if(val == 1){
			return "<a href=\"javascript:newsAudit("+row.newsId+", 0)\"><span style=\"color:green;\">已发布</span></a>";
		}else {
			return "<a href=\"javascript:newsAudit("+row.newsId+", 1)\"><span style=\"color:red;\">等待审核</span></a>";	
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
	
	/*格式化预览*/
	function formatBrowse(val, row){
		return "<a href=\"${pageContext.request.contextPath}/index.jsp\" target='_blank'>预览首页</a>";
	}
	
	function newsAudit(newsId, statusId){
		$.post("${pageContext.request.contextPath}/system/doNewsAfficheAudit.do",{newsId:newsId,statusId:statusId},function(result){
			if(result.success){
				if(result.exist){
					$.messager.alert("系统提示",result.exist);
				}else{
					$.messager.alert("系统提示","数据已成功审核！");							
				}
				$("#dg").datagrid("reload");
			}else if(result.error){
				$.messager.alert("系统提示", result.error);
			}else{
				$.messager.alert("系统提示","数据审核失败！");
			}
		},"json");
	}
	
	/*关闭对话框*/
	function closeNewsDialog() {
		$('#dlg').dialog("close");
		// 重新加载数据
		$("#dg").datagrid("reload");
	}
	
	/*检索*/
	function searchTitle(){
		$("#dg").datagrid("load",{
			"newsTitle":$("#newsTitle").val()
		});
	}
</script>