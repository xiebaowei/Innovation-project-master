<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/info-reg.css" />
<title>网上招聘系统</title>
</head>

<body>
<div class="title"><h2>个人基本信息</h2></div>
<div class="main">
	<form action="${pageContext.request.contextPath }/download.do?project_id=${project.project_id}" method="post">
	<p class="short-input ue-clear newstyle">
    	<label>项目名称</label><input name="project_name" type="text"  style="border:0;background:transparent;"  value="${project.project_name}"/>
    </p>
    <p class="long-input ue-clear newstyle">
    	<label>教师姓名</label><input name="teacher_name" type="text"  style="border:0;background:transparent;" value="${project.teacher_name}">
    </p>
      <p class="short-input ue-clear newstyle">
    	<label>教师编号</label><input name="teacher_id" type="text"  style="border:0;background:transparent;" value="${project.teacher_id}">
    </p>
   
    <p class="short-input ue-clear newstyle">
    	<label>项目描述</label><input name="project_info" type="text"  style="border:0;background:transparent;" value="${project.project_info}">
    </p>
    <div class="btn ue-clear">
	<input style="height:50px;width:150px;background-color:#68B86C;color:white;border-radius:5px" type="submit" value="下载"/>
	</div>
    </form>
</div>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
showRemind('input[type=text], textarea','placeholder');
</script>
</html>
