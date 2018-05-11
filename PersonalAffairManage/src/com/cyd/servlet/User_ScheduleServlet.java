package com.cyd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyd.entity.User_Schedule;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IUser_ScheduleService;

/**
 * Servlet implementation class User_ScheduleServlet
 */
@WebServlet("/us")
public class User_ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 调用的个人关系Service
	private IUser_ScheduleService usService = BeanFactory.getInstance("usService",IUser_ScheduleService.class);
	// 跳转资源
	private Object uri;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作的类型
		String method = request.getParameter("method");
		// 判断
		if ("addUS".equals(method)) {
			// 添加
			addUS(request, response);
		}

		else if ("list".equals(method)) {
			// 列表展示
			list(request, response);
		}
		
		else if ("viewUpdate".equals(method)) {
			// 进入更新页面
			viewUpdate(request, response);
		}
		
		else if ("delete".equals(method)) {
			// 删除
			delete(request, response);
		}
		
		else if ("update".equals(method)) {
			// 更新
			update(request, response);
		}
		else if("search".equals(method)){
			search(request,response);
		}	
	}

	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 获取请求数据封装
			String us_create_name = request.getParameter("us_create_name");
			
			//由于是get，所以在编码时，先要将name传过来的乱码ISO一下，然后utf-8返回原先的字节编码
			us_create_name= new String(us_create_name.getBytes("ISO8859-1"), "utf-8");
			
			 User_Schedule us=new User_Schedule();
			 us.setUs_create_name(us_create_name);
			//2. 调用Service更新
				List<User_Schedule> list =usService.getAll(us_create_name);
				request.setAttribute("listUS", list);
				//3. 跳转
				//list(request,response);
				//uri = "/user?method=search";
				uri = request.getRequestDispatcher("/sys/user_schedule/us_list.jsp");
			} catch (Exception e) {
				e.printStackTrace();
				uri = "/error/error.jsp";
			}
			// 跳转
		 goTo(request, response, uri);
		
		
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			//1. 获取请求数据封装
			int id =Integer.parseInt(request.getParameter("id"));
			String us_create_name = request.getParameter("us_create_name");
			String us_create_identicard_id=request.getParameter("us_create_identicard_id");
			String us_content=request.getParameter("us_content");
			String us_place=request.getParameter("us_place");
			String us_info=request.getParameter("us_info");
			
			
			 User_Schedule us=new User_Schedule();
			us.setId(id);
			us.setUs_create_name(us_create_name);
			us.setUs_create_identicard_id(us_create_identicard_id);
			us.setUs_content(us_content);
			us.setUs_place(us_place);
			us.setUs_info(us_info);
			
			//2. 调用Service更新
			usService.update(us);
			//3. 跳转
			//list(request,response);
			uri = "/us?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// 跳转
		goTo(request, response, uri);
		
		
		
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 获取请求id
			int id =Integer.parseInt(request.getParameter("id"));
			// 2. 调用Service
			usService.delete(id);
			// 3. 跳转
			uri = "/us?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
		
	}


	private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 获取请求id
			int id =Integer.parseInt(request.getParameter("id"));
			// 2. 根据id查询对象
			User_Schedule us = usService.findById(id);
			// 3. 保存
			request.setAttribute("us", us);
			// 4. 跳转
			uri = request.getRequestDispatcher("/sys/user_schedule/us_update.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
		
		
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 调用Service查询所有的数据
			List<User_Schedule> list = usService.getAll();
			// 保存
			request.setAttribute("listUS", list);
			// 跳转的个人关系列表页面
			uri = request.getRequestDispatcher("/sys/user_schedule/us_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// 跳转
		goTo(request, response, uri);
		
	}


	private void addUS(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			//1. 获取请求数据封装
			int id =Integer.parseInt(request.getParameter("id"));
			String us_create_name = request.getParameter("us_create_name");
			String us_create_identicard_id=request.getParameter("us_create_identicard_id");
			String us_content=request.getParameter("us_content");
			String us_place=request.getParameter("us_place");
			String us_info=request.getParameter("us_info");
			
			
			 User_Schedule us=new User_Schedule();
			us.setId(id);
			us.setUs_create_name(us_create_name);
			us.setUs_create_identicard_id(us_create_identicard_id);
			us.setUs_content(us_content);
			us.setUs_place(us_place);
			us.setUs_info(us_info);
			
			//2. 调用Service更新
			usService.save(us);
			//3. 跳转
			//list(request,response);
			uri = "/us?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// 跳转
		goTo(request, response, uri);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	/**
	 * 跳转的通用方法
	 */
	private void goTo(HttpServletRequest request, HttpServletResponse response, Object uri)
			throws ServletException, IOException {
		if (uri instanceof RequestDispatcher){
			((RequestDispatcher)uri).forward(request, response);
		} else if (uri instanceof String) {
			response.sendRedirect(request.getContextPath() + uri);
		} 
	}
}
