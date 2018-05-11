package com.cyd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyd.entity.User;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IUserService;

/**
 * 4. 用户管理Servlet开发
 * 
 * a. 添加用户 
 * b. 用户列表展示
 * c. 进入更新页面
 * d. 删除
 * e. 更新
 * 
 * @author YongDong.Cheng
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 调用的用户Service
		private IUserService userService = BeanFactory.getInstance("userService",IUserService.class);
		// 跳转资源
		private Object uri;
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				
				// 获取操作的类型
				String method = request.getParameter("method");
				// 判断
				if ("addUser".equals(method)) {
					// 添加
					addUser(request, response);
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
					//搜索
					search(request,response);
				}
	}

	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//1. 获取请求数据封装
		String name = request.getParameter("name");
		
		//由于是get，所以在编码时，先要将name传过来的乱码ISO一下，然后utf-8返回原先的字节编码
		 name = new String(name.getBytes("ISO8859-1"), "utf-8");
		
		 User user = new User();
		 user.setName(name);
		//2. 调用Service更新
			List<User> list = userService.getAll(name);
			request.setAttribute("listUser", list);
			//3. 跳转
			//list(request,response);
			//uri = "/user?method=search";
			uri = request.getRequestDispatcher("/sys/user/user_list.jsp");
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
			String identicard_id =request.getParameter("identicard_id");
			String name = request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String sex=request.getParameter("sex");
			int salary=Integer.parseInt(request.getParameter("salary"));
			String marry_condition=request.getParameter("marry_condition");
			String job=request.getParameter("job");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
		    User user = new User();
			user.setIdenticard_id(identicard_id);
			user.setName(name);
			user.setAge(age);
			user.setSex(sex);
			user.setSalary(salary);
			user.setMarry_condition(marry_condition);
			user.setJob(job);
			user.setAddress(address);
			user.setPhone(phone);
			
			//2. 调用Service更新
			userService.update(user);
			//3. 跳转
			//list(request,response);
			uri = "/user?method=list";
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
			String identicard_id = request.getParameter("identicard_id");
			// 2. 调用Service
			userService.delete(identicard_id);
			// 3. 跳转
			uri = "/user?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
		
	}

// 进入更新页面
	private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 获取请求id
			String identicard_id = request.getParameter("identicard_id");
			// 2. 根据id查询对象
			User user = userService.findByIdenticard_id(identicard_id);
			// 3. 保存
			request.setAttribute("user", user);
			// 4. 跳转
			uri = request.getRequestDispatcher("/sys/user/user_update.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
		
	}

//用户列表展示
	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// 调用Service查询所有的用户
			List<User> list = userService.getAll();
			// 保存
			request.setAttribute("listUser", list);
			// 跳转的用户列表页面
			uri = request.getRequestDispatcher("/sys/user/user_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// 跳转
		goTo(request, response, uri);
		
	}

//添加用户
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 获取请求数据封装
			String identicard_id =request.getParameter("identicard_id");
			String name = request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String sex=request.getParameter("sex");
			int salary=Integer.parseInt(request.getParameter("salary"));
			String marry_condition=request.getParameter("marry_condition");
			String job=request.getParameter("job");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			User user = new User();
			user.setIdenticard_id(identicard_id);
			user.setName(name);
			user.setAge(age);
			user.setSex(sex);
			user.setSalary(salary);
			user.setMarry_condition(marry_condition);
			user.setJob(job);
			user.setAddress(address);
			user.setPhone(phone);
			
			// 2. 调用service处理业务逻辑
			userService.save(user);
			
			// 3. 跳转
			uri = request.getRequestDispatcher("/user?method=list");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
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
