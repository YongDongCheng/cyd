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
			
				
					<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/sys/style/images/title_arrow.gif"/>  更新个人关系				
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/pc?method=update" method="post">
	
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${pageContext.request.contextPath }/sys/style/images/item_point.gif"> 关系信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
						<tr>
						<tr>
							<td width="80px">编号</td>
							<td>
							
								<input type="text" name="id" class="InputStyle" value="${pc.id}" readonly=true/> *
							</td>
</tr>
<tr>
							<td width="80px">创建者名字</td>
							<td>
							
								<input type="text" name="pc_create_name" class="InputStyle" value="${pc.pc_create_name}"/> *
															
							</td>
							</tr>
							<tr>
							<td width="80px">创建者身份证</td>
							<td>
							
								<input type="text" name="pc_create_identicard_id" class="InputStyle" value="${pc.pc_create_identicard_id}"/> *
															
							</td>
							</tr>
							<tr>
							<td width="80px">关系对象</td>
							<td>
							
							
								<input type="text" name="pc_object" class="InputStyle" value="${pc.pc_object}"/> *
                               
                                 						
							</td>
							</tr>
							<tr>
							<td width="80px">关系对象公司</td>
							<td>
							
								<input type="text" name="object_company" class="InputStyle" value="${pc.object_company}"/> *
														
							</td>
						</tr>
						<tr>
							<td width="80px">关系对象联系方式</td>
							<td>
							
								<input type="text" name="object_mobile" class="InputStyle" value="${pc.object_mobile}"/> *
															
							</td>
							</tr>
						<tr>
							<td width="80px">与对象关系</td>
							<td>
							
								<input type="text" name="object_con" class="InputStyle" value="${pc.object_con}"/> *
															
							</td>
							</tr>
							<tr>
							<td width="80px">关系对象工作</td>
							<td>
							
								<input type="text" name="object_job" class="InputStyle" value="${pc.object_job}"/> *
															
							</td>
							</tr>
						<tr>
							<td width="80px">关系对象备注</td>
							<td>
							
								<input type="text" name="object_info" class="InputStyle" value="${pc.object_info}"/> *
								
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
