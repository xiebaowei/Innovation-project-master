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
			<dd><a href="${pageContext.request.contextPath }/student_password.jsp?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">修改密码</a></dd> 
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
                    <ul class="sub-menu ">
                        <li class="current">
                            <a href="${pageContext.request.contextPath }/stulist.do?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                个人信息
                            </a>
                        </li>
   
                    </ul>
             
                <li class="list" >
                    <a href="javascript:;">
                        <i class="iconfont">&#xe6a3;</i>
                        项目管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath }/stuapplyprojectlist.do?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                项目列表
                            </a>
                        </li>
						<li>
                            <a href="${pageContext.request.contextPath }/applyprojectlist.do?name=<%=request.getParameter("name") %>&username=<%=request.getParameter("username") %>">
                                <i class="iconfont">&#xe6a7;</i>
                                申报项目
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
      
            <xblock> <p style="text-align:center;font-size:20px;">你已申报的项目信息如下</p> </xblock>
            <table class="layui-table">
                <thead>
                    <tr>
                      
                        <th>
                            项目编号
                        </th>
                        <th>
                            项目名称
                        </th>
                        <th>
                            教师编号
                        </th>
                        <th>
                            指导教师
                        </th>
						<th>
                            项目描述
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
                    </tr>
                </thead>
                <tbody>
                   <c:forEach items="${ApplystuList}" var="applystu">
                <tr >
					<td>${applystu.project_id}</td>
					<td>${applystu.project_name}</td>
					<td>${applystu.teacher_id}</td>
					<td>${applystu.teacher_name}</td>
					<td>${applystu.project_info}</td>
					<td>${applystu.project_progress}</td>
					<td>${applystu.pass_status}</td>
					<td>${applystu.project_content}</td>
					<td>${applystu.project_teach}</td>
					<td>${applystu.adju_number}</td>
					<td>${applystu.project_total_score}</td>
				
				</tr>
				 </c:forEach>  
                </tbody>
            </table>
            <!-- 右侧内容框架，更改从这里结束 -->
            <form action="studentlistdoUpload.do?username=<%=request.getParameter("username") %>&teacher_id=<%=request.getParameter("teacher_id") %>&project_id=<%=request.getParameter("project_id") %>&name=<%=request.getParameter("name") %>" enctype="multipart/form-data" method="post">
		<div class="layui-form-item">
		
			<div class="layui-input-inline">
				<input type="file" name="uploadFile" class="layui-input"required="" lay-verify="required" autocomplete="off" >
        	</div>  
				<button type="submit" class="layui-btn">上传</button>
				<button  class="layui-btn" lay-filter="add" lay-submit="">
                  <a href="studentdownload.do">下载申报模板</a>
                </button>
		  <div style = "color : red;font-size: 20px;">${error }</div>
		  <div style = "color : green;font-size: 20px;">${successerror }</div>
		</div>
	 </form>
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

        layui.use(['laydate'], function(){
          laydate = layui.laydate;//日期插件

          //以上模块根据需要引入
          //
          

          
          var start = {
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
              end.min = datas; //开始日选好后，重置结束日的最小日期
              end.start = datas //将结束日的初始值设定为开始日
            }
          };
          
          var end = {
            min: laydate.now()
            ,max: '2099-06-16 23:59:59'
            ,istoday: false
            ,choose: function(datas){
              start.max = datas; //结束日选好后，重置开始日的最大日期
            }
          };
          
          document.getElementById('LAY_demorange_s').onclick = function(){
            start.elem = this;
            laydate(start);
          }
          document.getElementById('LAY_demorange_e').onclick = function(){
            end.elem = this
            laydate(end);
          }
          
        });
		
		/*密码-修改*/
			function member_password(title,url,id,w,h){
					x_admin_show(title,url,w,h);  
				}
         //批量删除提交
             function delAll () {
                layer.confirm('确认要删除吗？',function(index){
                    //捉到所有被选中的，发异步进行删除
                    layer.msg('删除成功', {icon: 1});
                });
             }
           
            /*浏览-删除*/
            function view_del(obj,id){
                layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                });
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