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
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a>创新创业平台管理系统</a></div>
        <div class="open-nav"><i class="iconfont">&#xe699;</i></div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">设置</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
			<dd><a href="${pageContext.request.contextPath }/teacher_password.jsp?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">修改密码</a></dd> 
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
                    <a>
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
                    <ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/tealist.do?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                个人信息
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
                            <a href="${pageContext.request.contextPath }/teaproject.do?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                项目列表
                            </a>
                        </li>
						<li>
                            <a href="${pageContext.request.contextPath }/projectlist.do?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                申报列表
                            </a>
                        </li>
                    </ul>
                </li>
              
            </ul>
          </div>
        </div>
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
		<div class="page-content">
          <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
        <form class="layui-form xbs" action="${pageContext.request.contextPath }/teacherserch.do?username=<%=request.getParameter("username") %>"method="post" >
                <div class="layui-form-pane" style="text-align: center;">
                  <div class="layui-form-item" style="display: inline-block;">
               
               
                
                    <div class="layui-input-inline">
                      <input type="text" name="studentid"  placeholder="请输入学号" autocomplete="off" class="layui-input">
                    </div>
					 <div class="layui-input-inline">
                      <input type="text" name="projectid"  placeholder="请输入项目编号" autocomplete="off" class="layui-input">
                    </div>
					 <div class="layui-input-inline">
                      <input type="text" name="projectname"  placeholder="请输入项目名" autocomplete="off" class="layui-input">
                    </div>
					 <div class="layui-input-inline">
                      <input type="text" name="studentname"  placeholder="请输入学生姓名" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                    </div> 
                  </div>
                </div> 
        </form>
      
		   <xblock><p style="text-align:center;font-size:20px;">申报项目的学生信息如下</p></xblock> 
            <table class="layui-table">
                <thead>
                    <tr>
                      
                        <th>
                            学生学号
                        </th>
                        <th>
                            学生姓名
                        </th>
                        <th>
                            项目编号
                         </th>
                        <th>
                            项目名称
                        </th>
                        <th>
                            申报进度
                        </th>
                        <th>
                            通过状态
                        </th>
						 <th>
                            申报内容
                         </th>
						 <th>
                            辅导内容
                         </th>
						 <th>
                            目前评审员数
                         </th>
						 <th>
                            目前评审总分
                         </th>
						<th>
                            操作
                        </th>
                    
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${StuprojectList}" var="applystu">
                <tr >
                    <td>${applystu.student_id}</td>
					<td>${applystu.student_name}</td>
					<td>${applystu.project_id}</td>
					<td>${applystu.project_name}</td>
					<td>${applystu.project_progress}</td>
					<td>${applystu.pass_status}</td>
					<td>${applystu.project_content}</td>
					<td>${applystu.project_teach}</td>
					<td>${applystu.adju_number}</td>
					<td>${applystu.project_total_score}</td>
				
					<td class="td-manage">
                        
                            <a title="辅导" href="${pageContext.request.contextPath }/teacher_teach_project.jsp?student_id=${applystu.student_id}&username=${applystu.teacher_id}&name=${applystu.student_name}" 
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
		 /*用户-添加*/
        function member_add(title,url,w,h){
            x_admin_show(title,url,w,h);
        }
		// 用户-编辑
        function member_edit(title,url,id,w,h) {
            x_admin_show(title,url,w,h); 
        }
		/*密码-修改*/
			function member_password(title,url,id,w,h){
					x_admin_show(title,url,w,h);  
				}
        </script>
        <script>
        //百度统计可去掉
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
</body>
</html>