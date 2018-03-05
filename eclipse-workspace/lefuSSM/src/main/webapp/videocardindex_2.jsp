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
            <div class="item"><a href="index_1.jsp" clstag="shangpin|keycount|product|mbNav-2">${TwoLevel.two_level_name }</a></div>
        </div><!-- .crumb -->
        <div class="clr"></div>
    </div>
</div>

<div class="w">
    <div class="product-intro clearfix">
    	<!-- ---------------------------------商品图片信息与详细信息--------------------------------- -->
        <div class="preview-wrap">
            <div class="preview" id="preview">
                <div class="spec-list" clstag="shangpin|keycount|product|lunbotu_1">
                    <script src="js/common.js"></script>
                    <script type="text/javascript">
                      $(document).ready(function(){
                          var showproduct = {
                              "boxid":"showbox",
                              "sumid":"showsum",
                              "boxw":350,//宽度,该版本中请把宽高填写成一样
                              "boxh":350,//高度,该版本中请把宽高填写成一样
                              "sumw":60,//列表每个宽度,该版本中请把宽高填写成一样
                              "sumh":60,//列表每个高度,该版本中请把宽高填写成一样
                              "sumi":11,//列表间隔
                              "sums":4,//列表显示个数
                              "sumsel":"sel",
                              "sumborder":1,//列表边框，没有边框填写0，边框在css中修改
                              "lastid":"showlast",
                              "nextid":"shownext"
                              };//参数定义    
                         $.ljsGlasses.pcGlasses(showproduct);//方法调用，务必在加载完后执行
                      });
                    </script>
                    <div id="showbox">
                      <c:if test="${videocard.picture_url1 !=null }"><img src="${pageContext.request.contextPath }/${videocard.picture_url1 }" width="270" height="180" /></c:if>
                    </div><!--展示图片盒子-->
                    <div id="showsum"></div><!--展示图片里边-->
                    <p class="showpage">
                      <a href="javascript:void(0);" id="showlast"> < </a>
                      <a href="javascript:void(0);" id="shownext"> > </a>
                    </p>
                </div>
            </div>
            </div>
            <div class="itemInfo-wrap">
                <div class="sku-name">
                <c:choose>
                <c:when test="${empty videocard}">
					<span style="color: red; text-align: center;">您请求的记录不存在！</span>
				</c:when>
				<c:otherwise>
					<!-- start -->
                	<a target="_top" >
                   		${videocard.type} 
                    </a>  
                </c:otherwise>
                </c:choose>
                         
                </div>
                <div class="news2">
                    <div class="item hide" id="p-ad" data-hook="hide" style="display: none;" ></div>
                    <div class="item hide" id="p-ad-phone" clstag="shangpin|keycount|product|sloganb" data-hook="hide"></div>
                </div>

                <div class="summary summary-first">
                    <div class="summary-price-wrap">
                        <div class="summary-price J-summary-price">
                            <div class="dt">代理价</div>
                            <div class="dd">
                                <span class="p-price"><span>￥</span><span class="price J-p-1361956">${videocard.agency_price }</span></span>

                            </div>
                        </div>
                        <div class="summary-info J-summary-info clearfix">
                            <div id="buy-rate" class="buy-rate item fl hide" style="display: block;">
                                <p>选购指数</p>
                                <a class="count" href="#" target="_top" clstag="shangpin|keycount|product|xuangouzhishu_1361956">5.3</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="summary p-choose-wrap">

                    <div class="summary-line" ></div>
                    
                    <div id="summary-weight" class="li" style="">
                         <div class="dt">京东零售价  </div>
                        <div class="dd">￥${videocard.jingdong_price}</div>
                    </div>
                    
                    <div class="summary-line" ></div>
                    
                    <div id="summary-weight" class="li" style="">
                         <div class="dt">天猫建议零售价   </div>
                        <div class="dd">￥${videocard.tianmao_price}</div>
                    </div>
                    
                    <div class="summary-line" ></div>
                    
                    <div id="summary-weight" class="li" style="">
                         <div class="dt">核心频率   </div>
                        <div class="dd">${videocard.core_clock}</div>
                    </div>
                    
                    <div class="summary-line"></div>
                    
                    <div id="summary-weight" class="li" style="">
                        <div class="dt">显存频率    </div>
                        <div class="dd">${videocard.memory_clock}</div>
                    </div>
                    
                    <div class="summary-line"></div>

                    <div id="summary-weight" class="li" style="">
                        <div class="dt">内存大小    </div>
                        <div class="dd">${videocard.video_memory_size}</div>
                    </div>
                    
                    <div class="summary-line"></div>
                  </div>
               </div>
               <!-- ---------------------------------商品图片信息与详细信息完毕--------------------------------- -->
           </div>
    </div>

	<div class="w">
	</div>

    <div class="w">
        <div class="aside">                                      
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
	    <div class="m m-aside ELazy-loading" id="sp-new" clstag="shangpin|keycount|product|dianpuxinpin_1"></div>
	
	    <div id="miaozhen7886" class="m m-aside" clstag="shangpin|keycount|product|ad_1">
	        <a href="" target="_top"><img data-img="2" data-lazyload="//img1.360buyimg.com/da/jfs/t9472/174/852621269/25407/50e987c3/59afd5edN2829395d.jpg" class="ELazy-loading" src="images/blank.gif" height="261" width="211"></a>
	    </div>
	    <div id="miaozhen10767" class="m m-aside" clstag="shangpin|keycount|product|ad_1"></div>
	        <div id="ad_market_1" class="m m-aside">
	            <img id="tracker_bannerc6bcb577-0b18-4986-b29f-879d4633d3dc" src="images/np" style="position: absolute; top: 0px; left: 0px;" height="0" width="0" border="0">
	            <div id="jd_bannerc6bcb577-0b18-4986-b29f-879d4633d3dc" style="width: 211px; height: 261px; position: relative;">
	    </div>
		</div>
	</div>
        

    <div class="detail">
        <div class="ETab" id="detail">
            <div class="tab-main large" data-fixed="pro-detail-hd-fixed">
                <ul>
                    <li data-tab="trigger" data-anchor="#detail" class="current" clstag="shangpin|keycount|product|shangpinjieshao_1">商品介绍</li>
                    
                    <li data-tab="trigger" data-anchor="#detail" clstag="shangpin|keycount|product|pcanshutab">规格与包装</li>
                    
                    <li data-tab="trigger" data-anchor="#detail" clstag="shangpin|keycount|product|ershouzhijian" style="display: none;">质检报告</li>
                    
                    <li data-tab="trigger" data-anchor="#detail" clstag="shangpin|keycount|product|psaleservice">售后保障</li>
                    
                    <li data-tab="trigger" data-offset="38" data-anchor="#comment" clstag="shangpin|keycount|product|shangpinpingjia_1" style="display: none;">商品评价<s>(3.3万+)</s></li>
                    
                    <li style="display: none;" data-tab="trigger" data-offset="38" data-anchor="#try-holder" clstag="shangpin|keycount|product|try-entry">京东试用<sup>new<b>◤</b></sup></li>
                </ul>
                <div class="extra">
            </div>
        </div>
        <div class="tab-con">
            <div data-tab="item">
                <div class="p-parameter">
                    <ul id="parameter-brand" class="p-parameter-list">
                        <li title="格力（GREE）">品牌： <a href="#" clstag="shangpin|keycount|product|pinpai_1" target="_top">${videocard.two_level_name }</a></li>
                    </ul>
                    <ul class="parameter2 p-parameter-list">
                        <li title="${videocard.core_clock }">核心频率：${videocard.core_clock }</li>
                        <li title="${videocard.memory_clock }">显存频率：${videocard.memory_clock }</li>
                        <li title="${videocard.SP_amount }">SP数量（个）：${videocard.SP_amount }</li>
                        <li title="${videocard.video_memory_size }">内存大小：${videocard.video_memory_size }</li>
                        <li title="${videocard.bit_width }">位宽：${videocard.bit_width }</li>
                        <li title="${videocard.output_interface }">输出接口：${videocard.output_interface }</li>
                        <li title="${videocard.power_consumption }">显卡功耗：${videocard.power_consumption }</li>
                        <li title="${videocard.slot }">PCI槽使用：${videocard.slot }</li>
                    </ul>
                </div>
                <div id="quality-life" class="quality-life" style="display: none;" clstag="shangpin|keycount|product|pinzhishenghuo">
                    <div class="q-logo">
                        <img src="images/56ca6792n64e5eafc.png" alt="品质生活">
                    </div>
                    <ul class="quality-icon">
                        <li class="J-ql-iframe ql-ico-1" data-type="1" data-text="质量承诺" style="display: none;" data-title="质量承诺" clstag="shangpin|keycount|product|zhijianchengnuo">
                                    <a href="#none"><i></i><span>质量承诺</span></a>
                        </li>
                        <li class="ql-ico-5" data-type="5" data-text="耐久性标签" style="display: none;" clstag="shangpin|keycount|product|naijiuxingbiaoqian">
                            <a href="#none"><i></i><span>耐久性标签</span></a>
                        </li>
                        <li class="ql-ico-3" data-type="3" data-text="吊牌" style="display: none;" clstag="shangpin|keycount|product|diaopai">
                            <a href="#none"><i></i><span>吊牌</span></a>
                        </li>
                        <li class="ql-ico-4" data-type="4" data-text="质检报告" style="display: none;" clstag="shangpin|keycount|product|zhijianbaogao">
                            <a href="#none"><i></i><span>质检报告</span></a>
                        </li>
                        <li class="ql-ico-2" data-type="2" data-text="CCC证书" style="display: none;" clstag="shangpin|keycount|product|3czhengshu">
                            <a href="#none"><i></i><span>CCC证书</span></a>
                        </li>
                        <li class="fresh-ico-1" data-text="实时温控" data-type="v1" style="display: none;" clstag="shangpin|keycount|product|shishiwenkong">
                                    <a href="#none"><i></i><span class="J-fresh-wd fresh-wd"></span><span>实时温控</span></a>
                        </li>
                        <li class="fresh-ico-2" data-text="检验报告" data-type="v2" style="display: none;" clstag="shangpin|keycount|product|jiancebaogao">
                            <a href="#none"><i></i><span>检验报告</span></a>
                        </li>
                    </ul>
                </div>
                <div id="suyuan-video"></div>
                <div id="J-detail-banner"><a id="p-cat-insert" target="_top" title="" href=""><img alt="" src="" width="990"></a></div>                                                                      
                <div class="detail-content clearfix z-have-detail-nav" data-name="z-have-detail-nav">
                    <div class="detail-content-wrap">                                                                                       
                       
                    </div>
                                                        
                   
                </div>
                <div class="clb"></div>
            </div>
            <div data-tab="item" class="hide">
                <div class="Ptable">
                    <div class="Ptable-item">
                        <h3>主体</h3>
                        <dl>
                            <dt>品牌</dt><dd>格力 GREE</dd>
                            <dt>型号</dt><dd>KFR-72LW/(72596)FNAa-A3</dd>
                            <dt>颜色</dt><dd>白色</dd>
                            <dt>类别</dt><dd>立柜式</dd>
                        </dl>
                    </div>
                    <div class="Ptable-item">
                        <h3>功能</h3>
                        <dl><dd>参数1</dd>
                            <dt>功能2</dt><dd>参数1</dd>
                            <dt>功能3</dt><dd>参数2</dd>
                            <dt>功能4</dt><dd>参数3</dd>
                        </dl>
                   	</div>
                    <div class="Ptable-item">
                        <h3>产品特色</h3>
                        <dl>
                            <dt>特色1</dt><dd>参数1</dd>
                            <dt>特色2</dt><dd>参数2</dd>
                            <dt>特色3</dt><dd>参数3</dd>
                            <dt>特色4</dt><dd>参数4</dd>
                        </dl>
                    </div>
                    <div class="Ptable-item">
                        <h3>规格</h3>
                        <dl>
                            <dt>规格1</dt>
                            <dd class="Ptable-tips">
                              <a href="#none"><i class="Ptable-sprite-question"></i></a>
                              <div class="tips">
                                <div class="Ptable-sprite-arrow"></div>
                                <div class="content">
                                  <p>说明1</p>
                                </div>
                              </div>
                            </dd>
                            <dd>参数1</dd>
                            <dt>规格2</dt>
                            <dd class="Ptable-tips">
                              <a href="#none"><i class="Ptable-sprite-question"></i></a>
                              <div class="tips">
                                <div class="Ptable-sprite-arrow"></div>
                                <div class="content">
                                  <p>说明2</p>
                                </div>
                              </div>
                            </dd>
                            <dd>参数2</dd>
                            <dt>规格3</dt>
                            <dd class="Ptable-tips">
                              <a href="#none"><i class="Ptable-sprite-question"></i></a>
                              <div class="tips">
                                <div class="Ptable-sprite-arrow"></div>
                                <div class="content">
                                  <p>说明3</p>
                                </div>
                              </div>
                            </dd>
                            <dd>参数3</dd>
                        </dl>
                    </div>
                    </div>
                    <div class="package-list">
                        <h3>包装清单</h3>
                        <p>本机 X 1； 保修卡 X 1； 说明书 X 1；</p>
                    </div>
                </div>
                <div data-tab="item" class="hide">
                        <!--质检报告-->
                </div>
                <div data-tab="item" class="hide">
                    <!--售后保障 家用电器展示一个图文的字段 -->
                </div>
                <div data-tab="item" class="hide">
                    <!--商品评价-->
                </div>
                <div data-tab="item" class="hide"></div>
            </div>
        </div>

       
                
                <div id="try-holder"></div>
            
            <div id="try-report" class="try-report"></div>
        </div>
        <div class="clb"></div>
    </div>

    <script>

               seajs.use('MOD_ROOT/main/main.js', function (App) {
            App.init(pageConfig.product);
        });

    </script>
            
    </div>                


</div>

</body>
</html>
