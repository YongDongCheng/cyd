<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- 包含公共的JSP代码片段 -->
	
<title>事务管理平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/sys/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/sys/style/css/index_1.css" />
</head>
<body>


<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			
				
					<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif"/>  更新用户
				
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/user?method=update" method="post">
	
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath }/sys/style/images/item_point.gif"> 用户信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
						<td width="80px">身份证</td>
							<td>
							
								<input type="text" name="identicard_id" class="InputStyle" value="${user.identicard_id}" readonly=true/> *
															
							</td>
						</tr>
						<tr>
							<td width="80px">用户名称</td>
							<td>
							
								<input type="text" name="name" class="InputStyle" value="${user.name}"/> *
															
							</td>
							</tr>
							<tr>
							<td width="80px">年龄</td>
							<td>
							
								<input type="text" name="age" class="InputStyle" value="${user.age}"/> *
															
							</td>
						</tr>
						<tr>
							<td width="80px">性别</td>
							<td>
							<c:if test="${user.sex == '男'}">
								 <input type="radio" name="sex" value="男" checked="checked" />男
								  <input type="radio" name="sex" value="女"/>女
								 </c:if>
							<c:if test="${user.sex == '女'}">
								 <input type="radio" name="sex" value="男" />男
								  <input type="radio" name="sex" value="女" checked="checked" />女
								 </c:if>
                                 
                                 							
							</td>
								</tr>
							<tr>
							<td width="80px">收入</td>
							<td>
							
								<input type="text" name="salary" class="InputStyle" value="${user.salary}"/> *
															
							</td>
						</tr>
						<tr>
							<td width="80px">婚姻状况</td>
							<td>
							
								<input type="text" name="marry_condition" class="InputStyle" value="${user.marry_condition}"/> *
															
							</td>
						</tr>
						<tr>
							<td width="80px">职业</td>
							<td>
							
								<input type="text" name="job" class="InputStyle" value="${user.job}"/> *
														
							</td>
							</tr>
							<tr>
							<td width="80px">地址</td>
							<td>
							
								<input type="text" name="address" class="InputStyle" value="${user.address}"/> *
															
							</td>
							</tr>
							<tr>
							<td width="80px">手机号码</td>
							<td>
							
								<input type="text" name="phone" class="InputStyle" value="${user.phone}"/> *
								
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
			
				
					 <input type="submit" id="submit" value="修改" class="FunctionButtonInput">
				
				
			
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	
</div>



</body>
</html>
