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
	<table id="dg" title="AOC一体机管理" class="easyui-datagrid"  fitColumns="true" pagination="true" rownumbers="true" url="${pageContext.request.contextPath}/system/newsIndexPictureList.do" fit="true" toolbar="#tb" Style="fit:true">
		<thead>
			<tr>
				<th field="cb" checkbox="true" align="center"></th>
				<th field="id" hidden="true" align="center" >编号</th>
				<th field="name" align="center">类型</th>
				<th data-options="field:'picture_name1',align:'center',formatter:imgFormatter">图片预览</th> 
				<th field="add_time" align="center">添加时间</th>
			</tr>
		</thead>
	</table>
	<!-- 工具栏 -->
	<div id="tb">
		<div>
			<a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
		</div>
	</div>
	<!-- 添加修改 -->
	<div id="dlg" class="easyui-dialog" style="width: 700px;height: 300px;padding: 10px 20px" closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post" enctype="multipart/form-data" formaction="register">
			<table cellspacing="8px">
				<tr>
					<td> 图片:</td>
				</tr>
				<tr>
					<td>请选好图片尺寸：（轮播大图：790*340，轮播大图下方的图片：390*130）</td>
				</tr>
				<tr>
					<td><input id="picture_name1" style="width:224px" runat="server" name="photos" onchange="javascript:setImagePreview(this,localImag,preview);" type="file" /></td>
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
		url = "${pageContext.request.contextPath}/system/newsIndexPictureSave.do";
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
		$("#dlg").dialog("open").dialog("setTitle","修改商品信息");
		var row= selectedRows[0];
		$("#fm").form("load",row);
		
		$.get("${pageContext.request.contextPath}/system/newsIndexPictureList.do?id="+row.id,function(data,status){
			data=eval("("+data+")");
		});
		url = "${pageContext.request.contextPath}/system/newsIndexPictureSave.do?id="+row.id;
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
		
		$.get("${pageContext.request.contextPath}/system/newsIndexPictureList.do?id="+row.id,function(data,status){
			data=eval("("+data+")");
			url = "${pageContext.request.contextPath}/system/newsIndexPictureSave.do?id="+row.id;
		})
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
				$.post("${pageContext.request.contextPath}/system/newsIndexPictureDelete.do",{ids:ids},function(result){
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
	
	/*格式化状态*/
	function formatStatus(val, row){
		if(val == "上架"){
			return "<span style=\"color:green;\">上架</span>";
		}else {
			return "<span style=\"color:red;\">下架</span>";	
		}
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