<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="" lang="zh-CN">
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<script type="text/javascript" async src="js/conversion_async.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/location.js"></script>
<script async src="js/gtm.js"></script>        
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <title>显卡</title>       
        <script type="text/javascript">           
             var params = {"isLogo":true,"ev":"4155_78904","istsyx":false,"isjd":false,"car_type":"","isbook":false,"multipleSort_view":true,"global":"0","jth":"","abTestFlag":"A","serverTime":"20170909102633","secondCatId":"794","delivery_jzun":"0","page":"1","area":"1,72,2799,0","mallpro":"0","isdjd":true,"is_ebook":false,"delivery_211":"0","newpro":"0","paragraph_tpl_type":0,"pageNo":"1","listck":"91f25c1297c4e61eea24036e3f82caf9","ms":"0","area_id":"1","c":"","delivery":"0","plist":"2","api_id":"798","exp_publishers":"","multicid3":"","thirdCatName":"平板电视","icon2":"","is_tid":false,"id2":"794","is3c":false,"delivery_glb":"0","firstCatId":"737","id1":"737","id3":"798","icon_up":false,"delivery_daofu":"0","ver":"a","cat":"737,794,798","md":"0","sort":"sort_rank_asc","icon":"","trans":"1","exp_price":"","stock":"1","abTempFlag":"A","icon3":"","exp_brand":"","pubsLen":0,"rid":"8727455a-1fb9-329a-baef-1be6a8e694b9","s_type":"0","show_jzun":true,"debug":"","thirdCatId":"798","is_book":false,"brandsLen":25};
             window.SEARCH=window.SEARCH || {};
             var domainName = '.tao.com'
             window.is3c = false;
             window.isbook = false;
             window.isjd = false;
             window.noleft = false;
             window.serverTime = 20170909102633;
             window.pageConfig = { jdfVersion:'2.0.0',version : "1.0.0",compatible: false,searchType:0,queryParam : {c1: params.id1, c2: params.id2,c3:params.id3,brand: params.exp_brand !="" ?params.exp_brand.split(',')[0]:"", price: params.exp_price,page: params.pageNo }, pSource:"list_pc_front"};
        </script>

        <script type="text/javascript" src="js/untitled"> </script>
        <meta name="keywords" content="显卡">
        <meta name="description" content="显卡">
<link media="all" href="index.css" type="text/css" rel="stylesheet">
</head>
<body>
<!-- 顶部 -->
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
					<c:when test="${TwoLevel.one_level_id == 2}">
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
                     <a href="${pageContext.request.contextPath }/videocardindex_1.jsp" class="crumbs-link">显卡</a> 

                </div>
            </div>
          </div>
        </div>
<div class="www" id="J_searchWrap">
    <div class="container" id="J_container">
        <div class="selector" id="J_selector">
			<!-- 商品筛选 -->
			<div class="s-title" clstag="thirdtype|keycount|thirdtype|select">
			     <h3><b>${computer.computer_name}</b><em>商品筛选</em></h3>
			</div>
		    <div class="J_selectorLine s-line J_selectorFold" id="J_selectorPrice" style="display: block;" data-id="100002">
		      <div class="sl-wrap">
		        <div class="sl-key">
		          <span>价格：</span>
		        </div>
		        <div class="sl-value">
		          <div class="sl-v-list">
		            <ul class="J_valueList" style="width: 1270px">
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=10000" rel="nofollow"><i></i>10000以上 </a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=9000-9999" rel="nofollow"><i></i>9000-9999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=8000-8999" rel="nofollow"><i></i>8000-8999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=7000-7999" rel="nofollow"><i></i>7000-7999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=6000-6999" rel="nofollow"><i></i>6000-6999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=5000-5999" rel="nofollow"><i></i>5000-5999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=4000-4999" rel="nofollow"><i></i>4000-4999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=3000-3999" rel="nofollow"><i></i>3000-3999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=2000-2999" rel="nofollow"><i></i>2000-2999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=1000-1999" rel="nofollow"><i></i>1000-1999</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?agency_price=0-999" rel="nofollow"><i></i>0-999</a></li>
		            </ul>
		          </div>
		        </div>
		      </div>
    		</div>
		    <div class="J_selectorLine s-line J_selectorFold">
		      <div class="sl-wrap">
		        <div class="sl-key">
		          <span>显示核心：</span>
		        </div>
		        <div class="sl-value">
		          <div class="sl-v-list">
		            <ul class="J_valueList" style="width: 1270px">
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GTX1080Ti" rel="nofollow"><i></i>GTX1080Ti</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GTX1070Ti" rel="nofollow"><i></i>GTX1070Ti</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GTX1070" rel="nofollow"><i></i>GTX1070</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GTX1060 6GB" rel="nofollow"><i></i>GTX1060 6GB</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GTX1060 3GB" rel="nofollow"><i></i>GTX1060 3GB</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GTX1050Ti" rel="nofollow"><i></i>GTX1050Ti</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GTX1050" rel="nofollow"><i></i>GTX1050</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GT1030" rel="nofollow"><i></i>GT1030</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GTX 750Ti" rel="nofollow"><i></i>GTX 750Ti</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GT 730" rel="nofollow"><i></i>GT 730</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GT 710" rel="nofollow"><i></i>GT 710</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_core=GF 210" rel="nofollow"><i></i>GF 210</a></li>
		                
		            </ul>
		          </div>
		        </div>
		      </div>
		    </div>
		    <div class="J_selectorLine s-line J_selectorFold">
		      <div class="sl-wrap">
		        <div class="sl-key">
		          <span>显存容量：</span>
		        </div>
		        <div class="sl-value">
		          <div class="sl-v-list">
		            <ul class="J_valueList" style="width: 1270px">
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_memory_size=11264MB" rel="nofollow"><i></i>11264MB</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_memory_size=8192MB" rel="nofollow"><i></i>8192MB</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_memory_size=6144MB" rel="nofollow"><i></i>6144MB</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_memory_size=4096MB" rel="nofollow"><i></i>4096MB</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_memory_size=3072MB" rel="nofollow"><i></i>3072MB</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_memory_size=2048MB" rel="nofollow"><i></i>2048MB</a></li>
		                <li><a href="${pageContext.request.contextPath }/videoCardList.html?video_memory_size=1024MB" rel="nofollow"><i></i>1024MB</a></li>
		            </ul>
		       	  </div>
		        </div>
			  </div>
		    </div>
		</div>           

	<div id="J_main" class="g-main2">
	    <div class="m-list">
	        <div class="ml-wrap">
	            <div class="filter" id="J_filter">
	                <div class="f-line top">
	                    <div class="f-sort">
	                        <a href="${pageContext.request.contextPath }/videoCardList.html?sortingall=diminishing" class="curr">综合排序<i></i></a>
	                        <a href="${pageContext.request.contextPath }/videoCardList.html?sortingagency_price=increasing" class="">价格由低到高<i></i></a>
	                        <a href="${pageContext.request.contextPath }/videoCardList.html?sortingagency_price=diminishing" class="">价格由高到低<i></i></a>
	                        <a href="${pageContext.request.contextPath }/videoCardList.html?sortingadd_time=diminishing" class="">上架时间<i></i></a>
	                    </div>
	                <span class="clr"></span>
	           	    </div>      
	            </div>

			<div class="clr"></div>
                                                      
		    <div id="plist" class="goods-list-v2 J-goods-list gl-type-1 ">
		        <ul class="gl-warp clearfix">
		        <c:forEach var="videocard" items="${videocardList}">
		        <li class="gl-item">
		            <div class="gl-i-wrap j-sku-item" style="border-style: dotted; border-width: 1px;border-color:#CDC9C9" data-sku="3433317" venderid="1000000940" jdzy_shop_id="1000000940" selfservice="1" data-sku_temp="3433317" data-i="1" data-soldoversea="-1">
						<!-- 图片 -->
						<div class="p-img">
		                    <a target="_top" href="${pageContext.request.contextPath }/videoCardList.html?id=${videocard.id}">
		                         <img data-img="1" src="${pageContext.request.contextPath }/${videocard.picture_url1 }" title="${videocard.type}" height="150" width="220">
		                    </a>
		                </div>
		                <!-- 价格 -->
		                <div class="p-price">
		                    <strong class="J_price js_ys" style=""><em>¥</em><i>${videocard.agency_price}</i></strong>
		                </div>
		                <!-- 详情 -->
		                <div class="p-name p-name-type3">
		                    <a target="_top" title="${pageContext.request.contextPath}/system/videoCardList.do?id=${videocard.id}">
		                      <em>${videocard.memory_clock}  ${videocard.illustrate}</em>
		                      <i class="promo-words">${videocard.core_clock }</i>
		                    </a>
		                    <span class="p-attribute">
			                    <a title="${videocard.type}" target="_top" class="attr"><b>${videocard.type}</b></a>
		                    </span>
		                </div>
		              	<div class="p-icons J-pro-icons"><i class="icon-group-1 goods-icons J-picon-tips" data-tips="性价比">性价比</i><i class="icon-group-11 goods-icons4 J-picon-tips" data-tips="受欢迎">受欢迎</i> </div>
					</div>                  
		        </li>
				</c:forEach>
		    	</ul>
		    	<script type="text/javascript">
						(function() {
							var playdiv = $('#plist');
							var t = i = 0, c = clas("gl-item").find('a').size();
							showImg();
							t = setInterval(showImg, 0);
							function clas(className) {
								return playdiv.find('.' + className);
							}
							function showImg() {
								clas("gl-item").find('a').eq(i).siblings().hide()
										.end().fadeIn(1200);
								if(i<3){
									i++;
								}
							}
						})();
				</script>
		  	<div class="clr"></div>
			</div>                                       
		    <div class="page clearfix">
		        <div class="p-wrap" id="J_bottomPage">
		            <span class="p-num">
		           	<!--  <form action="${pageContext.request.contextPath }/computerListhtml.html"	method="get">-->
					<ul class="color_a in_bl m_t_e">
						<li>
							<a href="${pageContext.request.contextPath }/videoCardList.html?page=1
							&conditionsByAll=${conditionsByAll}
							&video_core=${video_core}&video_memory_size=${video_memory_size}&agency_price=${agency_price}
							&sortingall=${sortingall}&sortingagency_price=${sortingagency_price}&sortingadd_time=${sortingadd_time}">
							首页
							</a>
							<c:choose>
								<c:when test="${videocardpage > 1 }">
									<a href="${pageContext.request.contextPath }/videoCardList.html?page=${videocardpage-1 }
									&conditionsByAll=${conditionsByAll}
									&video_core=${video_core}&video_memory_size=${video_memory_size}&agency_price=${agency_price}
									&sortingall=${sortingall}&sortingagency_price=${sortingagency_price}&sortingadd_time=${sortingadd_time}">
									上一页
									</a>
								</c:when>
								<c:otherwise>
									<a style="color: #DCDCDC;">上一页</a>
								</c:otherwise>
							</c:choose> 
							<c:choose>
								<c:when test="${videocardpage < videocardmaxPage }">
									<a href="${pageContext.request.contextPath }/videoCardList.html?page=${videocardpage+1 }
									&conditionsByAll=${conditionsByAll}
									&video_core=${video_core}&video_memory_size=${video_memory_size}&agency_price=${agency_price}
									&sortingall=${sortingall}&sortingagency_price=${sortingagency_price}&sortingadd_time=${sortingadd_time}">
									下一页
									</a>
								</c:when>
								<c:otherwise>
									<a  style="color: #DCDCDC;">下一页</a>
								</c:otherwise>
							</c:choose> 
							<a href="${pageContext.request.contextPath }/videoCardList.html?page=${videocardmaxPage }
							&conditionsByAll=${conditionsByAll}
							&video_core=${video_core}&video_memory_size=${video_memory_size}&agency_price=${agency_price}
							&sortingall=${sortingall}&sortingagency_price=${sortingagency_price}&sortingadd_time=${sortingadd_time}">
							尾页
							</a>
							<span class="p-skip"><em>第 ${videocardpage}页&nbsp;/&nbsp;共 ${videocardmaxPage}页&nbsp;|&nbsp;总 ${videocardtotal}条&nbsp;&nbsp;</em></span> 
						</li>
					</ul>
				<!--</form>-->
				</span>
		        </div>
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
