<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站后台管理</title>
<link rel="stylesheet" type="text/css" href="include/jquery-easyui-1.3.3/themes/${theme}/easyui.css">
<link rel="stylesheet" type="text/css" href="include/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.min.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:50px; line-height: 50px;overflow:hidden">
		<span style="font-weight: bold; font-size: 16px; margin-left: 3%;">网站后台管理</span>
		<span style="float: right; margin-right: 1%;">登录账号：${USER.userNick }</span>
	</div>
	<div data-options="region:'west'" title="菜单" style="width:230px;">
		<!-- 左侧树型菜单 -->
		<div style="margin:5px 0;">
			<a href="#" class="easyui-linkbutton" onclick="collapseAll()">合并</a>
			<a href="#" class="easyui-linkbutton" onclick="expandAll()">展开</a>
		</div>
		<div class="easyui-panel" style="padding:5px;overflow-x:hidden">
			<ul class="easyui-tree" id="ww">
               	<!-- 一级分类 -->
               	<c:forEach var="PowerMenu" items="${powerMenuList }">
               		<c:choose><c:when test="${PowerMenu.menuPid == 0}">
               		<li>
           			<span>${PowerMenu.menuName}</span>
               		</c:when></c:choose>
               		
						<ul>
							<!-- 二级分类 -->
			               	<c:forEach var="PowerMenu1" items="${powerMenuList }">
		               		<c:choose><c:when test="${PowerMenu1.menuPid == PowerMenu.menuId}">
		               			<ul>
									<!-- 三级分类 -->
					               	<c:forEach var="PowerMenu2" items="${powerMenuList }">
				               		<c:choose><c:when test="${PowerMenu2.menuPid == PowerMenu1.menuId}">
					           			<span>${PowerMenu1.menuName}</span>
										<li><a href="javascript:openTab('${ PowerMenu2.menuName }','${PowerMenu2.menuUrl}')" data-options="plain:true">${ PowerMenu2.menuName }</a></li>
									</c:when></c:choose>
					               	</c:forEach>
		               			</ul>
		               			
								<li><a href="javascript:openTab('${ PowerMenu1.menuName }','${PowerMenu1.menuUrl}')" data-options="plain:true">${ PowerMenu1.menuName }</a></li>
							
							</c:when></c:choose>
			               	</c:forEach>
               			</ul>
	               		
               		<c:choose><c:when test="${PowerMenu.menuPid == 0}">
               		</li>
               		</c:when></c:choose>
               		
               	</c:forEach>
               	
            </ul>
            <ul class="easyui-tree" id="ww2">  	
				<li data-options="state:'closed'">
					<span>系统管理</span>
					<ul>
						<li>
							<span>主题风格</span>
							<ul>
								<li><a href="theme.do?theme_id=1" data-options="plain:true">default</a></li>
								<li><a href="theme.do?theme_id=2" data-options="plain:true">black</a></li>
								<li><a href="theme.do?theme_id=3" data-options="plain:true">bootstrap</a></li>
								<li><a href="theme.do?theme_id=4" data-options="plain:true">gray</a></li>
								<li><a href="theme.do?theme_id=5" data-options="plain:true">metro</a></li>
							</ul>
						</li>
						<li><a id="passbtn" data-options="plain:true,iconCls:'icon-edit'">修改密码</a></li>
						<li><a id="logoutbtn" data-options="plain:true,iconCls:'icon-edit'">退出系统</a></li>
						<li><a href="javascript:refreshSystem()" data-options="plain:true,iconCls:'icon-refresh'">刷新系统缓存</a></li>
						<li><a href="javascript:openTab2('网页编辑','lefuSSM/system/plugin/index_edit/index_edit.do')" >网页编辑</a></li>
					</ul>
				</li>
			</ul>
			<!-- 菜单--><%@ include file="plugin/index_menu_demoList.jsp"%>
		</div>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" data-options="iconCls:'icon-ok'">
				<div align="center" style="padding-top: 100px"><font color="red" size="10">欢迎使用</font></div>
			</div>
		</div>
	</div>
	<!-- 修改密码dialog -->
	<div id="dlg" class="easyui-dialog" style="width: 400px;height: 200px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
	<form id="fm" method="post">
		<table cellspacing="8px">
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" id="userName" name="userLogId" value="${USER.userLogId }" readonly="readonly" style="width: 200px"/>
				</td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td>
					<input type="password" id="newPassword1" name="newPassword1" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
			<tr>
				<td>确认新密码：</td>
				<td>
					<input type="password" id="newPassword2" name="newPassword2" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
		</table>
	</form>
	</div>
	<!-- 工具栏 -->
	<div id="dlg-buttons">
		<a id="savepassbtn" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a id="closebtn"  class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	</body>
	</html>
<!-- js -->
<script type="text/javascript" src="include/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="include/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	$('#ww').tree('collapseAll');
	$('#ww1').tree('collapseAll');
	$('#ww2').tree('collapseAll');
})
function collapseAll(){
	$('#ww').tree('collapseAll');
	$('#ww1').tree('collapseAll');
	$('#ww2').tree('collapseAll');
}
function expandAll(){
	$('#ww').tree('expandAll');
	$('#ww1').tree('expandAll');
	$('#ww2').tree('expandAll');
}
var url;
function openTab3(text,url){
	$('#cw').panel({    
	    href:url,
	    title:text
	}); 
}
	
	$(function(){
		//修改密码
		$('#passbtn').bind('click',function(){
			$("#dlg").dialog("open").dialog("setTitle","修改密码");
			url="${pageContext.request.contextPath}/system/doUserPwdModify.do";
		});
		//退出系统
		$('#logoutbtn').bind('click',function(){
			$.messager.confirm("系统提示","您确定要退出系统吗?",function(r){
				if(r){
					window.location.href="${pageContext.request.contextPath}/system/doUserExit.do";
				}
			});
		});
		//保存密码
		$('#savepassbtn').bind('click',function(){
			$("#fm").form("submit",{
				url:url,
				onSubmit:function(){
					var newPassword1=$("#newPassword1").val();
					var newPassword2=$("#newPassword2").val();
					if(!$(this).form("validate")){
						return false;
					}
					if(newPassword1 != newPassword2){
						$.messager.alert("系统提示","确认密码输入错误！");
						return false;
					}
					return true;
				},
				success:function(result){
					var result=eval('('+result+')');
					if(result.success){
						$.messager.alert("系统提示","密码修改成功,下一次登录失效！");
						resetValue();
						$("#dlg").dialog("close");
					}else{
						$.messager.alert("系统提示","密码修改失败！");
						return;
					}
				}
			});
		});
		//关闭窗口
		$('#closebtn').bind('click',function(){
			resetValue();
			$("#dlg").dialog("close");
		});
		
	});
	
	var url;
	
	function openTab(text,url){
		if($("#tabs").tabs("exists",text)){
			$("#tabs").tabs("select",text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"+url+"'></iframe>";
			$("#tabs").tabs("add",{
				title:text,
				closable:true,
				content:content
			});
		}
	}
	function openTab2(text,url){
		if($("#tabs").tabs("exists",text)){
			$("#tabs").tabs("select",text);
		}else{
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='/"+url+"'></iframe>";
			$("#tabs").tabs("add",{
				title:text,
				closable:true,
				content:content
			});
		}
	}
	
	function resetValue(){
		$("#newPassword1").val("");
		$("#newPassword2").val("");
	}
	
	function refreshSystem(){
		$.post("${pageContext.request.contextPath}/system/doRefreshSystem.do",{},function(result){
			if(result.success){
				$.messager.alert("系统提示","已成功刷新系统缓存！");
			}else{
				$.messager.alert("系统提示","刷新系统缓存失败！");
			}
		},"json");
	}
</script>