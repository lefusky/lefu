<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class=" csstransitions cssanimations o2_gecko o2_firefox o2_56 o2_wide">
<head>
	<title>主页</title>
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
	<meta charset="UTF-8">
	<meta name="description" content="沈阳爱德蒙科技有限公司,数万个优质商品.便捷、诚信的服务!">
	<meta name="Keywords" content="沈阳爱德蒙科技有限公司,爱德蒙,显示器,主板,机箱,电源">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<link media="all" href="index.css" type="text/css" rel="stylesheet">
</head>
<body class="index" data-lazy-img-install="1">
<!-- 顶部 -->
<%@ include file="index_head.jsp"%>


<div class="grid_c1 fs_inner"  style="margin-bottom: 30px;">
	<!-- leftcate start -->
	<div class="fs_col1">
	    <div class="J_cate cate">
	     	<div id="nav-2014">
	            <div class="w">
	                <div class="w-spacer"></div>
	                <div class="dorpdown" id="categorys-20142">
	                    <div class="dd">
	                    	<!-- 左侧一级分类 列表-->
	                        <div class="dd-inner">
	                        	<!--<c:forEach var="OneLevel" items="${oneLevelList }">
		                            <div class="item fore1">
		                                <h3><a href="${pageContext.request.contextPath }/computerToindex_1.html?one_level_id=${OneLevel.one_level_id }" target="_top">${OneLevel.one_level_name }</a></h3>                           
		                            </div>
	                            </c:forEach>-->
	                            <div class="item fore1"><h3><a href="aioindex_1.jsp" target="_top">一体机</a></h3></div>
	                        </div>
	                        <!-- 左侧一级分类列表完毕 -->
	                        <!-- 左侧二级分类 -->
	                       	<div style="display: none;" class="dorpdown-layer" id="index_menus_sub">
	                        	<!-- 副菜单一级分类列表循环
	                        	<c:forEach var="OneLevel" items="${oneLevelList }">
	                            <div data-id="b" id="category-item-2" class="item-sub" style="display: block;">                                           
	                                <div clstag="h|keycount|2015|0501c" class="subitems">    
	                                	<!-- 副菜单二级分类列表循环                	
	                                	<c:forEach var="TwoLevel" items="${twoLevelList }">
	                                		<!-- 副菜单二级分类列表展示 
	                                		<c:choose>
											<c:when test="${TwoLevel.one_level_id eq OneLevel.one_level_id}">
			                                    <dl class="fore1">
			                                        <dt><i>&gt;</i>
			                                            <a target="_top" href="${pageContext.request.contextPath }/computerToindex_1.html?two_level_id=${TwoLevel.two_level_id }">${TwoLevel.two_level_name }</a>
			                                       </dt>
			                                    </dl>
			                                </c:when>
			                                </c:choose>
	                                    </c:forEach>            
	                                </div>
	                            </div>
	                            </c:forEach>-->
	                            <div data-id="b" id="category-item-2" class="item-sub" style="display: block;">                                           
	                                <div clstag="h|keycount|2015|0501c" class="subitems">    
	                            		<dl class="fore1">
	                                        <dt><i>&gt;</i>
	                                       <c:forEach var="TwoLevel" items="${twoLevelList }">
						                    <c:choose>
											<c:when test="${TwoLevel.one_level_id ==3}">
						                		<div style=" margin-left:20px;"><i>&gt;</i><a href="${pageContext.request.contextPath }/videoCardList.html?two_level_id=${TwoLevel.two_level_id }">${TwoLevel.two_level_name }</a></div><br>
						                	</c:when>
						                	</c:choose>
						                	</c:forEach>
						                	</dt>
	                                    </dl>
	                                </div>
	                            </div>
	                            
	                            
	                        </div>
	                        <!-- 左侧二级分类列表完毕 -->
	                    </div>
	                </div><!--index_ok-->
	                <span class="clr"></span>
	            </div>
	        </div>
	        <script src="js/jquery.js" type="text/javascript"></script> 
	        <script type="text/javascript">
	            $(function() {
	                $(".dd-inner").children(".item").hover(function() { //一级导航悬浮
	                    $(this).addClass("hover").siblings(".item").removeClass("hover");
	                    var index = $(this).index();
	                    $(".dorpdown-layer").children(".item-sub").hide();
	                    $(".dorpdown-layer").children(".item-sub").eq(index).show();
	                })
	                $(".dd-inner").hover(function() { //整个导航菜单悬浮，是否显示二级导航到出厂
	                    $("#index_menus_sub").show();
	                }, function() {
	                    $("#index_menus_sub").hide();
	                    $('.item').removeClass("hover");
	                })
	                $("#index_menus_sub").children(".item-sub").hover(function() { //二级导航悬浮
	                    var index = $(this).index();
	                    $(".dd-inner").children(".item").eq(index).addClass("hover");
	                    $("#index_menus_sub").show();
	                }, function() {
	                    $("#index_menus_sub").hide();
	                    $(".dd-inner").children(".item").removeClass("hover");
	                })
	            })
	        </script> 
	    </div>
	</div>
	<!-- leftcate start -->
	<div class="fs_col2">
	    <div class="J_slider slider">
	        <!-- 轮播图 -->
	        <script type="text/javascript" src="js/jquery.js"></script>
	        <script type="text/javascript" src="js/superslide.2.1.js"></script>
	        <div class="fullSlide">
	            <div class="bd">
	              <ul >
	              	<c:forEach var="newsindexpicture" items="${newsindexpictureList}">
            		<c:if test="${newsindexpicture.id eq '1'}">
	                	<li _src="url(images/${newsindexpicture.picture_name1})"><a href="videocardindex_1.jsp"></a></li>
	                </c:if></c:forEach>
	                <c:forEach var="newsindexpicture" items="${newsindexpictureList}">
            		<c:if test="${newsindexpicture.id eq '2'}">
	                	<li _src="url(images/${newsindexpicture.picture_name1})"><a href="videocardindex_1.jsp"></a></li>
	                </c:if></c:forEach>
	                <c:forEach var="newsindexpicture" items="${newsindexpictureList}">
            		<c:if test="${newsindexpicture.id eq '3'}">
	                	<li _src="url(images/${newsindexpicture.picture_name1})"><a href="videocardindex_1.jsp"></a></li>
	                </c:if></c:forEach>
	                
	              </ul>
	            </div>
	            <div class="hd"><ul></ul></div>
	            <span class="prev"></span>
	            <span class="next"></span>
	        </div>
	        <!--fullSlide end-->
	        <script type="text/javascript">
	          $(".fullSlide").hover(function(){
	              $(this).find(".prev,.next").stop(true, true).fadeTo("show", 0.5)
	          },
	          function(){
	              $(this).find(".prev,.next").fadeOut()
	          });
	          $(".fullSlide").slide({
	              titCell: ".hd ul",
	              mainCell: ".bd ul",
	              effect: "fold",
	              autoPlay: true,
	              autoPage: true,
	              trigger: "click",
	              startFun: function(i) {
	                  var curLi = jQuery(".fullSlide .bd li").eq(i);
	                  if ( !! curLi.attr("_src")) {
	                      curLi.css("background-image", curLi.attr("_src")).removeAttr("_src")
	                  }
	              }
	          });
		     </script>
		     <!-- 轮播图 -->
		     <div class="J_slider_extend slider_extend clearfix">
		         <div class="J_slider_bi slider_bi">  
		         <c:forEach var="newsindexpicture" items="${newsindexpictureList}">
            		<c:if test="${newsindexpicture.id eq '4'}">
	                	<a href="videocardindex_1.jsp" class="slider_bi_lk" target="_top">              
		                 <img class="J_slider_bi_img slider_bi_img" title="" alt="" src="upload/pic/${newsindexpicture.picture_name1}">            
		             	</a> 
	             </c:if></c:forEach>          
		                      
		         </div>
		         <div class="J_slider_bi slider_bi">  
		         <c:forEach var="newsindexpicture" items="${newsindexpictureList}">
            		<c:if test="${newsindexpicture.id eq '5'}">
	                	<a href="videocardindex_1.jsp" class="slider_bi_lk" target="_top">              
		                 <img class="J_slider_bi_img slider_bi_img" title="" alt="" src="upload/pic/${newsindexpicture.picture_name1}">            
		             	</a> 
	             </c:if></c:forEach>          
		                      
		         </div>
		     </div>
	     </div>
	 </div>
</div>

<!-- headerad start -->
<div class="J_f J_f_lift need_ani entry entry_c3 entry_1 floor" id="entry_1" data-tpl="entry_tpl" data-backup="entry" data-source="bi:entry" data-backup2="801d789d73" data-inlazyqueue="true">
    <div class="ftit">
        <div class="grid_c1 ftit_inner">
            <h3>乐享品质</h3>
        </div>
    </div>
    <div class="grid_c1 entry_inner entry_n8">
        <ul class="entry_list clearfix">
            <li id="J_live" class="entry_item live live_disabled" style="width:388px;border-top:1px solid #e5e5e5;border-bottom:1px solid #e5e5e5;border-left:1px solid #e5e5e5;border-right:1px solid #e5e5e5">
                <div class="news J_news mc" style="height:350px">
                	<div class="mod_tab_head J_tab_head clearfix" style="background-color:#f7f7f7;padding:12px;width:390px;margin-left:-16px;font-size:14px">
                		<h5><span style="float:right;color:rgb(102, 102, 102);padding-right:20px">发表时间</span><a href="${pageContext.request.contextPath }/newsindex_1.jsp" >更多新闻</a></h5>
                	</div>
                	<div class="mod_tab_content_item mod_tab_content_item_on" style="dispaly:block;height:200px">
                		
                		<ul class="news_list"style="padding-top:4px">
			      		<c:forEach var="news" items="${afficheList}">
			      			<li class="news_item" style="max-width:358px;border-bottom:1px dashed #e5e5e5;line-height:28px"><div style="width:160px;overflow:hidden;position:absolute"><a href="${pageContext.request.contextPath }/newsList.html?id=${news.newsId }" class="news_link" >${news.newsTitle} </a></div>
			      				<span style="float:right;color:rgb(102, 102, 102)">${news.addTime }</span></li>
			     		</c:forEach>
			      		</ul>
                		
                	</div>

                </div>
            
            </li>

            <li class="entry_item entry_item_1">
            <c:forEach var="videocard" items="${videocardList}">
            <c:choose><c:when test="${videocard.id == 1}">
              <a class="entry_lk J_log" href="videocardindex_1.jsp" target="_top">
                  <div class="entry_bg" style="background: rgb(102, 182, 135) none repeat scroll 0% 0%;">
                      <div class="entry_info">
                          <h4 class="entry_info_tit">显卡</h4>
                          <p class="entry_info_desc">${videocard.illustrate}</p>
                      </div>
                  </div>
                  <img src="images/gigabyteindex1.jpg" data-lazy-img="done" class="entry_img" style="width:200px;height:200px;float:right">
              </a>
            </c:when></c:choose>
            </c:forEach>
            </li>

			            
            <li class="entry_item entry_item_7" style="width:390px">
           		<div style="padding-top:10px;margin-bottom:10px">
           			<ul style="margin-left:1px">
           			<li style="float:left; height:48px;border:1px solid #DDD;margin:-1px -1px 0 0;width:128px">
           				<a href="videocardindex_1.jsp"><i></i>
           					<img src="images/gigabyte.jpg" style="margin:7px 14px;vertical-align:top" name="技嘉">
           				</a>
           			</li>
           			
           			</ul>
           		</div>
            </li>
            
        </ul>
    </div>
</div>
<!-- 底部 -->
<%@ include file="index_foot.jsp"%>

<!-- 右侧楼梯导航开始开始 -->
<div class="J-global-toobal">
 <div class="jdm_toobar_wrap">
    <div class="jdm_toobar">
    <div class="jdm_toolbar_footer">
        <div class="jdm_toolbar_tab jdm_toolbar_tab_top">
          <em class="tab_text"><a href="">顶部</a></em>
          <a href=""><i class="tab_ico"></i></a>
        </div>
    </div>
    </div>
 </div>
</div>  
<!-- 右侧楼梯导航结束 -->

<script src="js/shortcut.js"></script>
<script src="js/banner.js"></script>
<script type="text/javascript">
//*****************左侧导航***************//
var cate = $(".cate");
var num = $(".cate .cate_menu li").length;
var oleftli = $(".cate .cate_menu li");//显示区块
var ofloatli = $(".navfloat ul li");//隐藏区块
bannerplay(cate,ofloatli,oleftli,15,false,1);
//***************中间轮播图************//
var slider_main = $(".slider_main");
var picli = $(".slider_main .picban li");
var lilen = picli.length;
var leftbtn = $(".slider_main .left");
var rightbtn = $(".slider_main .right");
for(var i=1;i<=lilen;i++){  //创建图片个数相对应的底部数字个数
  var li="<li>"+i+"</li>";  //创建li标签，并插入到页面中
  $(".slider_main .num_btn").append(li);
} 
var numli = $(".slider_main .num_btn li")
bannerplay(slider_main,picli,numli,lilen,true,0,leftbtn,rightbtn);
//右侧选项卡
bannerplay($(".mod_tab_head"),$(".mod_tab_content_item"),$(".mod_tab_head_item"),2,false,2);

//*****************左侧楼梯导航*******************//
$(".lift ul li").click(function(){
  //alert("dianji ");
  var index = $(this).index();
  //让滚动条移动到对应页面位置
  var topslide = $(".floor").eq(index).offset().top;
  $("html,body").animate({"scrollTop":topslide},1000);
  
})
//滚动条事件
$(window).scroll(function(){
  var topslide = $(window).scrollTop();
  $(".floor").each(function(i){
    if(topslide >=$(this).offset().top){
      $(".lift ul li").eq(i).addClass("active").siblings().removeClass("active");
    }
  })
  //显示楼梯导航
  if(topslide>1600){
    $(".lift").show();
  }else{
    $(".lift").hide();
  }
  //显示搜索栏
  if(topslide>660){
    $("#search").addClass("search-fix");
  }else{
    $("#search").removeClass("search-fix");
  }
})
  

</script>
</body>
</html>
