<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="root61" lang="zh-CN">
<head>
<title>${videocard.type}</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">    
<meta name="keywords" content="${videocard.type}">
<meta name="description" content="上商城,放心又轻松">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="mobile-agent" content="format=xhtml; url=//index_2.jsp">
<meta http-equiv="mobile-agent" content="format=html5; url=//index_2.jsp">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">            
    <script charset="gbk">
        var pageConfig = {
            product: {
            modules: ['track','detail','gift',],
            skuid: 1361956,
            cat: [737,794,870],
        	shopId:'1000003445',       
            specialAttrs:[],
        	recommend : [0,1,2,3,4,5,6,7,8,9],
 			}
        };                 
    </script>
    <script src="js/untitled"></script>
    <script>
        seajs.config({
            paths: {
                'MOD_ROOT' : '//static.360buyimg.com/item/default/1.0.33/components',
                'PLG_ROOT' : '//static.360buyimg.com/item/default/1.0.33/components/common/plugins',
                'JDF_UI'   : '//misc.360buyimg.com/jdf/1.0.0/ui',
            }
        });
    </script>
<link media="all" href="index.css" type="text/css" rel="stylesheet">
</head>
<body version="140120" class="clothing cat-1-737 cat-2-794 cat-3-870 item-1361956 JD JD-1">

<div id="shortcut">
    <div class="w">
        <ul class="fl">
            <li id="ttbar-home"><a href="index.jsp" target="_top">首页</a></li>
        </ul>
        <ul class="fr">
        <li class="spacer"></li>
        <li class="fore5" clstag="h|keycount|2016|01f">
          <div class="dt"><a target="_top" href="newsindex_2.jsp">企业采购</a></div>
        </li>
        <li class="spacer"></li>
        <li class="fore8 dorpdown" id="ttbar-serv" clstag="h|keycount|2016|01g" data-load="1">
          <div class="dt cw-icon">客户服务<i class="iconfont"></i><i class="ci-right"><s></s></i></div>
          <div class="dd dorpdown-layer">
              <div class="dd-spacer"></div>
              <div class="item-client">客户</div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">帮助中心</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">售后服务</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">在线客服</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">意见建议</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">电话客服</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">客服邮箱</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">金融咨询</a></div>
              <div class="item-business">商户</div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">合作招商</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">商家后台</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">商家帮助</a></div>
              <div class="item"><a href="newsindex_2.jsp" target="_top" true="">规则平台</a></div>
          </div>
        </li>        
      </ul>
        <span class="clr"></span>
    </div>
</div>
<div id="o-header-2013"></div>
<!-- #shortcut-2014 -->
<div class="w">
    <div id="logo-2014">
        <a href="index.jsp" clstag="shangpin|keycount|topitemnormal|b01" class="logo">商城</a>
    </div>
    <div id="search-2014">
        <ul id="shelper" class="hide" style="display: none;"></ul>
        <div class="form">
        <form action="${pageContext.request.contextPath }/videoCardList.html?conditionsByAll={conditionsByAll}" method="get">
            <input onkeydown="javascript:if(event.keyCode==13) search('key');" name="conditionsByAll" autocomplete="off" id="key" accesskey="s" class="text" clstag="shangpin|keycount|topitemnormal|b02" type="text">
            <button onclick="search('key');return false;" class="button cw-icon" clstag="shangpin|keycount|topitemnormal|b03"><i></i>搜索</button>
        </form>
        </div>
    </div>
    <span class="clr"></span>
</div>

<div id="nav-2014">
    <div class="w">
        <div class="w-spacer"></div>
        <!-- 左侧二级导航  start -->
        <div id="category-2016" name="category-2016" onMouseOver="this.className='on'" onmouseleave="this.className=''">
           <div class="ld">
              <h2>全部商品分类<b></b></h2>
            </div>
             <div id="allsort">
              <!-- 一级分类列表循环 
              <c:forEach var="OneLevel" items="${oneLevelList }">
              <div class="item" onMouseOver="this.className='item on'" onmouseleave="this.className='item'">
                <span><h3><a href="${pageContext.request.contextPath }/computerToindex_1.html?one_level_id=${OneLevel.one_level_id }">${OneLevel.one_level_name }</a></h3></span>
                <div class="i-mc">
                	<!-- 副菜单二级分类列表展示 
                	<c:forEach var="TwoLevel" items="${twoLevelList }">
                    <c:choose>
					<c:when test="${TwoLevel.one_level_id eq OneLevel.one_level_id}">
                		<div style=" margin-left:20px;"><i>&gt;</i><a href="${pageContext.request.contextPath }/computerToindex_1.html?two_level_id=${TwoLevel.two_level_id }">${TwoLevel.two_level_name }</a></div><br>
                	</c:when>
                	</c:choose>
                	</c:forEach>
                	<!-- 副菜单二级分类列表展示完毕 
                </div>
              </div>
              </c:forEach>
              <!-- 一级分类列表循环完毕 -->
              
              <div class="item" onMouseOver="this.className='item on'" onmouseleave="this.className='item'">
                <span><h3><a href="aioindex_1.jsp">一体机</a></h3></span>
                <div class="i-mc">
	             <!-- 副菜单二级分类列表展示 -->
	               	<c:forEach var="TwoLevel" items="${twoLevelList }">
	                   <c:choose>
					<c:when test="${TwoLevel.one_level_id ==2}">
	               		<div style=" margin-left:20px;"><i>&gt;</i><a href="${pageContext.request.contextPath }/aioList.html?two_level_id=${TwoLevel.two_level_id }">${TwoLevel.two_level_name }</a></div><br>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
	             <!-- 副菜单二级分类列表展示完毕  -->
	            </div>
	          </div>
	          <div class="item" onMouseOver="this.className='item on'" onmouseleave="this.className='item'">
                <span><h3><a href="videocardindex_1.jsp">显卡</a></h3></span>
                <div class="i-mc">
	             <!-- 副菜单二级分类列表展示 -->
	               	<c:forEach var="TwoLevel" items="${twoLevelList }">
	                   <c:choose>
					<c:when test="${TwoLevel.one_level_id ==3}">
	               		<div style=" margin-left:20px;"><i>&gt;</i><a href="${pageContext.request.contextPath }/videoCardList.html?two_level_id=${TwoLevel.two_level_id }">${TwoLevel.two_level_name }</a></div><br>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
	             <!-- 副菜单二级分类列表展示完毕  -->
	            </div>
	          </div>
	          <div class="item" onMouseOver="this.className='item on'" onmouseleave="this.className='item'">
                <span><h3><a href="screenindex_1.jsp">显示器</a></h3></span>
                <div class="i-mc">
	             <!-- 副菜单二级分类列表展示 -->
	               	<c:forEach var="TwoLevel" items="${twoLevelList }">
	                   <c:choose>
					<c:when test="${TwoLevel.one_level_id ==4}">
	               		<div style=" margin-left:20px;"><i>&gt;</i><a href="${pageContext.request.contextPath }/screenList.html?two_level_id=${TwoLevel.two_level_id }">${TwoLevel.two_level_name }</a></div><br>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
	             <!-- 副菜单二级分类列表展示完毕  -->
	            </div>
	          </div>
	          <div class="item" onMouseOver="this.className='item on'" onmouseleave="this.className='item'">
                <span><h3><a href="monitoringindex_1.jsp">监控器</a></h3></span>
                <div class="i-mc">
	             <!-- 副菜单二级分类列表展示 -->
	               	<c:forEach var="TwoLevel" items="${twoLevelList }">
	                   <c:choose>
					<c:when test="${TwoLevel.one_level_id ==5}">
	               		<div style=" margin-left:20px;"><i>&gt;</i><a href="${pageContext.request.contextPath }/monitoringList.html?two_level_id=${TwoLevel.two_level_id }">${TwoLevel.two_level_name }</a></div><br>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
	             <!-- 副菜单二级分类列表展示完毕  -->
	            </div>
	          </div>
	          <div class="item" onMouseOver="this.className='item on'" onmouseleave="this.className='item'">
                <span><h3><a href="interchangerindex_1.jsp">交换机 路由器</a></h3></span>
                <div class="i-mc">
	             <!-- 副菜单二级分类列表展示 -->
	               	<c:forEach var="TwoLevel" items="${twoLevelList }">
	                   <c:choose>
					<c:when test="${TwoLevel.one_level_id ==6}">
	               		<div style=" margin-left:20px;"><i>&gt;</i><a href="${pageContext.request.contextPath }/interchangerList.html?two_level_id=${TwoLevel.two_level_id }">${TwoLevel.two_level_name }</a></div><br>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
	             <!-- 副菜单二级分类列表展示完毕  -->
	            </div>
	          </div>
              
              
            </div>
        </div>
        <!-- 左侧二级导航  end -->
        <div id="navitems-2014" style="padding-left: 210px;">
            <ul id="navitems-group1">
                <li class="fore1" clstag="shangpin|keycount|topitemnormal|c03" id="nav-home">
                    <a href="index.jsp">首页</a>
                </li>
            </ul>  
            <ul id="navitems-group2">
                <li class="fore1" clstag="shangpin|keycount|topitemnormal|c08" id="nav-red">
                    <a href="videocardindex_1.jsp" target="_top" class="style-red" clstag="h|keycount|2016|03b01">技嘉显卡</a></li>
                <li class="fore1" clstag="shangpin|keycount|topitemnormal|c03" id="nav-home">
		          <a href="aioindex_1.jsp" target="_top" clstag="h|keycount|2016|03b02">一体机</a></li>
		        <li class="fore1" clstag="shangpin|keycount|topitemnormal|c03" id="nav-home">
		          <a href="screenindex_1.jsp" target="_top" clstag="h|keycount|2016|03b03">AOC显示器</a></li>
		        <li class="fore1" clstag="shangpin|keycount|topitemnormal|c03" id="nav-home">
		          <a href="interchangerindex_1.jsp" target="_top" clstag="h|keycount|2016|03b04">交换机</a></li>
		        <li class="fore1" clstag="shangpin|keycount|topitemnormal|c03" id="nav-home">
		          <a href="interchangerindex_1.jsp" target="_top" clstag="h|keycount|2016|03b05">路由器</a></li>
		        <li class="fore1" clstag="shangpin|keycount|topitemnormal|c03" id="nav-home">
		          <a href="monitoringindex_1.jsp" target="_top" clstag="h|keycount|2016|03b09">监控器</a></li>
            </ul>          
        </div>
        <div id="treasure"></div>
        <span class="clr"></span>
    </div>
</div><!-- #nav-2014 -->

<div class="crumb-wrap" id="crumb-wrap">
    <div class="w">
        <div class="crumb fl clearfix">
            <div class="item first"><a href="index.jsp" clstag="shangpin|keycount|product|mbNav-1">${OneLevel.one_level_name }</a></div>
            <div class="item sep">&gt;</div>
            <div class="item"><a href="newsindex_1.jsp" clstag="shangpin|keycount|product|mbNav-2">新闻列表</a></div>
        </div><!-- .crumb -->
        <div class="clr"></div>
    </div>
</div>


	<div class="w">
	</div>

    <div class="w">
        <div class="aside" style="margin-top:47px">                                      
        <div id="sp-category" class="m m-aside sp-category" clstag="shangpin|keycount|product|pop-04">
            <div class="mt">
                <h3>商品分类</h3>
            </div>
            <div class="mc no-padding">
              
            <!-- 一级分类列表循环 
            <c:forEach var="OneLevel" items="${oneLevelList }">                                   
            <dl class="">
                <dt class=""><s></s><a href="${pageContext.request.contextPath }/computerToindex_1.html?one_level_id=${OneLevel.one_level_id }" target="_top">${OneLevel.one_level_name }</a></dt>
				<!-- 副菜单二级分类列表展示 
                	<c:forEach var="TwoLevel" items="${twoLevelList }">
                    <c:choose>
					<c:when test="${TwoLevel.one_level_id eq OneLevel.one_level_id}">
              			  <dd><a href="${pageContext.request.contextPath }/computerToindex_1.html?two_level_id=${TwoLevel.two_level_id }" target="_top">${TwoLevel.two_level_name }</a></dd>
                    </c:when>
                	</c:choose>
                	</c:forEach>
                	<!-- 副菜单二级分类列表展示完毕                          
            </dl>
            </c:forEach>
            <!-- 一级分类列表循环 完毕-->
            <dl class="">
            	<dt class=""><s></s><a href="${pageContext.request.contextPath }/aioindex_1.jsp" target="_top">一体机</a></dt>
            		<c:forEach var="TwoLevel" items="${twoLevelList }">
	                <c:choose>
					<c:when test="${TwoLevel.one_level_id ==2}">
	               		<dd><a href="${pageContext.request.contextPath }/aioList.html?two_level_id=${TwoLevel.two_level_id }" target="_top">${TwoLevel.two_level_name }</a></dd>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
            		 
        	</dl>
        	<dl class="">
            	<dt class=""><s></s><a href="${pageContext.request.contextPath }/videocardindex_1.jsp" target="_top">显卡</a></dt>
            		<c:forEach var="TwoLevel" items="${twoLevelList }">
	                <c:choose>
					<c:when test="${TwoLevel.one_level_id ==3}">
	               		<dd><a href="${pageContext.request.contextPath }/videoCardList.html?two_level_id=${TwoLevel.two_level_id }" target="_top">${TwoLevel.two_level_name }</a></dd>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
            		 
        	</dl>
        	<dl class="">
            	<dt class=""><s></s><a href="${pageContext.request.contextPath }/screenindex_1.jsp" target="_top">显示器</a></dt>
            		<c:forEach var="TwoLevel" items="${twoLevelList }">
	                <c:choose>
					<c:when test="${TwoLevel.one_level_id ==4}">
	               		<dd><a href="${pageContext.request.contextPath }/screenList.html?two_level_id=${TwoLevel.two_level_id }" target="_top">${TwoLevel.two_level_name }</a></dd>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
            		 
        	</dl>
        	<dl class="">
            	<dt class=""><s></s><a href="${pageContext.request.contextPath }/monitoringindex_1.jsp" target="_top">监控器</a></dt>
            		<c:forEach var="TwoLevel" items="${twoLevelList }">
	                <c:choose>
					<c:when test="${TwoLevel.one_level_id ==5}">
	               		<dd><a href="${pageContext.request.contextPath }/monitoringList.html?two_level_id=${TwoLevel.two_level_id }" target="_top">${TwoLevel.two_level_name }</a></dd>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
            		 
        	</dl>
        	<dl class="">
            	<dt class=""><s></s><a href="${pageContext.request.contextPath }/interchangerindex_1.jsp" target="_top">交换机 路由器</a></dt>
            		<c:forEach var="TwoLevel" items="${twoLevelList }">
	                <c:choose>
					<c:when test="${TwoLevel.one_level_id ==6}">
	               		<dd><a href="${pageContext.request.contextPath }/interchangerList.html?two_level_id=${TwoLevel.two_level_id }" target="_top">${TwoLevel.two_level_name }</a></dd>
	               	</c:when>
	               	</c:choose>
	               	</c:forEach>
            		 
        	</dl>
        	
        	</div>
    	</div>
	</div>
        

    <div class="detail">
		<div class="m-list">
		        <div class="ml-wrap">
					<div class="right-extra">                           
					    <div id="detail" class="m ">
					    	<div class="mt">
					    		<h1 style="border-bottom:1px dashed #e5e5e5;text-align:center;padding-bottom:10px">${news.newsTitle}</h1>
					    		<div class="summary" style="text-align:center;color:#999"><fmt:formatDate	value="${news.addTime }" pattern="yyyy-MM-dd" />
					    		</div>
					    	</div>
					    	<div class="mc" style="margin-top:30px">
					    		<p>${news.newsContent }</p>
					    	</div>
						</div>
					</div>
				</div>
			</div>


        </div>
        <div class="clb"></div>
    </div>

    <script>

               seajs.use('MOD_ROOT/main/main.js', function (App) {
            App.init(pageConfig.product);
        });

    </script>
    <script>
  function todate(str) {
	  str = str.replace(/ GMT.+$/, '');// Or str = str.substring(0, 24)
	  var d = new Date(str);
	  var a = [d.getFullYear(), d.getMonth() + 1, d.getDate(), d.getHours(), d.getMinutes(), d.getSeconds()];
	  for(var i = 0, len = a.length; i < len; i ++) {
	      if(a[i] < 10) {
	          a[i] = '0' + a[i];
	      }
	  }
	  return  str = a[0] + '-' + a[1] + '-' + a[2] + ' ' + a[3] + ':' + a[4] + ':' + a[5];
    }

  </script>        
    </div>                


</div>

</body>
</html>
