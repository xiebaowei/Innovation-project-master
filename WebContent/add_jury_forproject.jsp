<%@ page language="java" contentType="text/html; " pageEncoding="UTF-8"%>
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
    <!-- 顶部开始 --> 
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
            <form class="layui-form xbs" action="" >
                <div class="layui-form-pane" style="text-align: center;">
                </div> 
            </form>
            <xblock><p style="text-align:center;font-size:20px;">请为已选择的项目添加评审员</p></xblock>
            <table class="layui-table">
                <thead>
                    <tr>
                      
                        <th>
                            工号
                        </th>
                        <th>
                            姓名
                        </th>
                     <th>
                           操作           <div style = "color : red"> &nbsp; &nbsp; &nbsp;${ error }</div> 
                           
                      </th>
                    
                    </tr>
                </thead>
                <tbody>
                   <c:forEach items="${jury}" var="jury">
                <tr >
					<td>${jury.adjudicator_id}</td>
					<td>${jury.adjudicator_name}</td>
				<td class="td-manage">
                        
                            <a title="添加" href="${pageContext.request.contextPath }/addjury.do?adjuid=${jury.adjudicator_id}&sid=<%=request.getParameter("sid") %>&pid=<%=request.getParameter("pid") %>&username=<%=request.getParameter("username") %>&name=<%=request.getParameter("name") %>" 
                            class="ml-5" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                           
                </td>

				</tr>
				 </c:forEach>
                  
                </tbody>
            </table>
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
    <script>

        // 用户-编辑
        function member_edit (title,url,id,w,h) {
            x_admin_show(title,url,w,h); 
        }
        /*密码-修改*/
        function member_password(title,url,id,w,h){
            x_admin_show(title,url,w,h);  
        }
        
        </script>
</body>
</html>