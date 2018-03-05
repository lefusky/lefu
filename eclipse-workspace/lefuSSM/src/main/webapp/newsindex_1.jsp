<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="root61" lang="zh-CN">
<head>
<title>${aio.type}</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">    
<meta name="keywords" content="${aio.type}">
<meta name="description" content="上商城,放心又轻松">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="mobile-agent" content="format=xhtml; url=//index_2.jsp">
<meta http-equiv="mobile-agent" content="format=html5; url=//index_2.jsp">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">            
        <script charset="gbk">
        var pageConfig = {
            product: {
                modules: [
                    'track',
                    'detail',
                    'gift',
                ],
                                   
            skuid: 1361956,
                        cat: [737,794,870],

        shopId:
                '1000003445',       
                specialAttrs:[
                ],
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
<body>
<!-- 底部 -->
<%@ include file="index_head.jsp"%>
           
           
           
<!--nav start-->

<div id="nav-2015">
    <div class="www">
        <div class="w-spacer"></div>



        <!-- 左侧二级导航  start -->

        <div id="category-2016" onMouseOver="this.className='on'" onmouseleave="this.className=''">
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





        <div id="navitems-2014" style="padding-left: 220px;">
            <ul id="navitems-group1">
                <li clstag="" id="nav-fashion" class="fore1">
                    <a class="b" target="_top" href="index.jsp">首页</a>
                </li>
            </ul>
        </div>
        <div id="treasure"></div>
        <span class="clr"></span>
    </div>
</div>
<!--nav end-->
                
       <div class="www" id="J_crumbsBar">
            <div class="crumbs-bar clearfix">
                <div class="crumbs-nav">
                    <div class="crumbs-nav-main clearfix">
                     <a href="${pageContext.request.contextPath }/computerToindex_1.html?one_level_id=${OneLevel.one_level_name }" class="crumbs-link">${OneLevel.one_level_name }</a>  <i class="crumbs-arrow">&gt;</i>
                     <a href="${pageContext.request.contextPath }/aioindex_1.jsp" class="crumbs-link">新聞列表</a> 

                </div>
            </div>
          </div>
        </div>
        <div class="www" id="J_searchWrap">
            <div class="container" id="J_container">
                <div class="selector" id="J_selector">

</div>           

<div id="J_main" class="g-main2">
    <div class="m-list">
        <div class="ml-wrap">
            

<div class="clr"></div>
                                                      
    <div id="plist" class="goods-list-v2 J-goods-list gl-type-1 ">
       <!-- ---------------------------------商品图片信息与详细信息--------------------------------- -->
       <div class="mod_tab_head J_tab_head clearfix" style="background-color:#f7f7f7;padding:12px;font-size:14px">
      		<h5><span style="float:right;color:rgb(102, 102, 102);padding-right:20px">发表时间</span><a href="${pageContext.request.contextPath }/newsindex_1.jsp" >新闻列表</a></h5>
      	</div>
      	<div class="mod_tab_content_item mod_tab_content_item_on" style="dispaly:block;height:200px">
      		<ul class="news_list"style="padding-top:4px">
      		<c:forEach var="news" items="${afficheList}">
      			<li class="news_item" style="max-width:970px;border-bottom:1px dashed #e5e5e5;line-height:28px"><a href="${pageContext.request.contextPath }/newsList.html?id=${news.newsId }" class="news_link" >${news.newsTitle} </a>
      				<span style="float:right;color:rgb(102, 102, 102)">${news.addTime }</span></li>
     		</c:forEach>
      		</ul>
      	</div>
	<!-- ---------------------------------商品图片信息与详细信息完毕--------------------------------- -->
</div>

                                                          

</div>
</div>
      

<div class="m-aside">
    <div class="aside-bar">
        <div class="ab-goods" id="finalbuy" style="display: block;">
            <div class="mt"><h2>商品分类</h2></div>

            <div class="mc">
                <ul>
                    <li class="fore" sku_c="647948">
                        <h3 style="margin-bottom:10px"><a href="${pageContext.request.contextPath }/aioindex_1.jsp" title="" target="_top">一体机</a></h3>
                    </li>
                    <li class="fore" sku_c="647948">
                        <h3 style="margin-bottom:10px"><a href="${pageContext.request.contextPath }/videocardindex_1.jsp" title="" target="_top">显卡</a></h3>
                    </li>
                    <li class="fore" sku_c="647948">
                        <h3 style="margin-bottom:10px"><a href="${pageContext.request.contextPath }/screenindex_1.jsp" title="" target="_top">显示器</a></h3>
                    </li>
                    <li class="fore" sku_c="647948">
                        <h3 style="margin-bottom:10px"><a href="${pageContext.request.contextPath }/monitoringindex_1.jsp" title="" target="_top">监控器</a></h3>
                    </li>
                    <li class="fore" sku_c="647948">
                        <h3 style="margin-bottom:10px"><a href="${pageContext.request.contextPath }/interchangerindex_1.jsp" title="" target="_top">交换机 路由器</a></h3>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>




        </div>
    </div>
    <span class="clr"></span>
</div>
      
<!-- 底部 -->
<%@ include file="index_foot.jsp"%>
      </body>

</html>
