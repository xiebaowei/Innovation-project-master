<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>创新创业平台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>

</head>
<body>
        <div class="container">
        <div class="logo"><a >创新创业平台管理系统</a></div>
        <div class="open-nav"><i class="iconfont">&#xe699;</i></div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">设置</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
             <dd><a href="${pageContext.request.contextPath }/admin_password.jsp?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">修改密码</a></dd>  
              <dd><a href="./login.jsp">切换帐号</a></dd>
              <dd><a href="./login.jsp">退出</a></dd>
            </dl>
          </li>
         
        </ul>
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
    <div class="wrapper">
        <!-- 左侧菜单开始 -->
           <div class="left-nav">
          <div id="side-nav">
            <ul id="nav">
                <li class="list" current>
                    <a >
                        <i class="iconfont">&#xe761;</i>
                        欢迎页面
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                </li>
              
                <li class="list">
                    <a href="javascript:;">
                        <i class="iconfont">&#xe70b;</i>
                        个人管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
               
                    <ul class="sub-menu "  >
                   
                        <li class="current" >
                            <a href="${pageContext.request.contextPath }/adminlist.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>" >
                                <i class="iconfont" >&#xe6a7;</i>
                    
                                                   个人信息
                           </a>
                        </li>
     				
                    </ul>
                
             </li>       
           
               <li class="list" >
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6a3;</i>
                        学生管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/studentlist.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                学生信息列表
                            </a>
                        </li>
					</ul>
					
                </li>
				<li class="list" >
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6a3;</i>
                        教师管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/teacherlist.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                教师信息列表
                            </a>
                        </li>
					</ul>
					
                </li>
				<li class="list" >
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6a3;</i>
                        评审员管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/jurylist.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                评审员信息列表
                            </a>
                        </li>
					</ul>
					<ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/juryprojectlist.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                项目分配评审员信息
                            </a>
                        </li>
					</ul>
                </li>
              
            
			<li class="list" >
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6a3;</i>
                        项目管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/auditprojectlist.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                项目审核通过
                            </a>
                        </li>
					</ul>
					<ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/addprojury.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                项目分配评审员
                            </a>
                        </li>
					</ul>
					<ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/projectfile.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                项目文件下载
                            </a>
                        </li>
					</ul>
					<ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/manager_file_upload.jsp?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                项目文件上传
                            </a>
                        </li>
					</ul>
           </li>
              
          </div>
        </div>
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
          <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
          
            <xblock> <p style="text-align:center;font-size:20px;">请上传创新创业项目相关要求文档</p> </xblock>
           <fieldset class="layui-elem-field layui-field-title site-title">
              <legend><a name="default">创新创业相关介绍</a></legend>
            </fieldset>
             <table class="layui-table">
                <thead>
                    <tr>
                        <th>大学生创新创业大赛</th>
             	  </tr>
                </thead>
                <tbody>
                 
                <tr>
                        <td>大学生创新创业大赛分为两大类，一类是创新类，一类是创业类。创新类（挑战杯比赛），创业类包括互联网+、创青春两个比赛。<br>
挑战杯<br>

“挑战杯”竞赛是由共青团中央、中国科协、教育部和全国学联共同主办的全国性的大学生课外学术实践竞赛。

这项活动坚持“崇尚科学，追求真知，勤奋学习，迎接挑战”的宗旨，被誉为中国大学生学术科技“奥林匹克。
<br>
挑战杯竞赛两个并列项目:

1.“挑战杯”中国大学生创业计划竞赛。

2.“挑战杯”全国大学生课外学术科技作品竞赛。<br>

互联网+<br>

互联网+旨在深化高等教育综合改革，激发大学生的创造力，培养造就“大众创业、万众创新”的生力军;推动赛事成果转化和产学研用紧密结合，促进“互联网+”新业态形成，服务经济提质增效升级;以创新引领创业、创业带动就业,推动高校毕业生更高质量创业就业，颜色更多更出彩。
<br>
创青春<br>

创青春是由共青团中央、教育部、人力资源社会保障部等部i联合主办的全国性的大学生创业竞赛。以"中国梦，创业梦, 我的梦"为主题，以增强大学生创新、创意、创造、创业的意识和能力为重点，以深化大学生创业实践为导向，着力打造权威性高、影响面广、带动力大的全国大学生创业大赛。

三大比赛作为高校深化创新创业教育改革的重要抓手；积极开展教学改革探索，把创新创业教育融入人才培养；推动赛事成果转化和产学研用紧密结合；以创新引领创业、创业带动就业，推动高校毕业生更高质量创业就业。


</td>
     			 </tr>
                    
                  
                 
                </tbody>
            </table>
<form action="managerdoUpload.do?username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>" enctype="multipart/form-data" method="post">
	<div class="layui-form-item">
		<div class="layui-input-inline">
		     
		      <input type="file" name="uploadFile" class="layui-input"required="" lay-verify="required" autocomplete="off" >
        </div>  
		     <button type="submit" class="layui-btn">上传</button>
		 <div style = "color : red;font-size: 20px;">${error }</div>
		  <div style = "color : green;font-size: 20px;">${successerror }</div>
	</div>
</form>
            <!-- 右侧内容框架，更改从这里结束 -->
          </div>
        </div>
        <!-- 右侧主体结束 -->
    </div>
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright"><p style="text-align:center;font-size:20px;">Copyright ©2020 创新创业平台管理系统（西安石油大学计算机学院）</p></div>  
    </div>
    <!-- 底部结束 -->
    <!-- 背景切换开始 -->
    <div class="bg-changer">
        <div class="swiper-container changer-list">
            <div class="swiper-wrapper">
                <div class="swiper-slide"><img class="item" src="./images/a.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/b.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/c.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/d.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/e.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/f.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/g.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/h.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/i.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/j.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/k.jpg" alt=""></div>
                <div class="swiper-slide"><span class="reset">初始化</span></div>
            </div>
        </div>
        <div class="bg-out"></div>
        <div id="changer-set"><i class="iconfont">&#xe696;</i></div>   
    </div>
    <!-- 背景切换结束 -->
    <!-- 页面动态效果 -->
    
        
</body>
</html>