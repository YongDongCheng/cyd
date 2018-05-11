package com.cyd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyd.entity.Personal_Con;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IPersonal_ConService;

/**
 * 4. 个人关系管理Servlet开发
 * 
 * a. 添加个人关系数据
 * b. 个人关系列表展示
 * c. 进入更新页面
 * d. 删除
 * e. 更新
 * 
 * @author YongDong.Cheng
 */

@WebServlet("/pc")
public class Personal_ConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 调用的个人关系Service
			private IPersonal_ConService pcService = BeanFactory.getInstance("pcService",IPersonal_ConService.class);
			// 跳转资源
			private Object uri;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作的类型
		String method = request.getParameter("method");
		// 判断
		if ("addObject".equals(method)) {
			// 添加
			addObject(request, response);
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
			String pc_create_name = request.getParameter("pc_create_name");
			
			//由于是get，所以在编码时，先要将name传过来的乱码ISO一下，然后utf-8返回原先的字节编码
			pc_create_name= new String(pc_create_name.getBytes("ISO8859-1"), "utf-8");
			
			 Personal_Con pc = new Personal_Con();
			 pc.setPc_create_name(pc_create_name);
			//2. 调用Service更新
				List<Personal_Con> list =pcService.getAll(pc_create_name);
				request.setAttribute("listObject", list);
				//3. 跳转
				//list(request,response);
				//uri = "/user?method=search";
				uri = request.getRequestDispatcher("/sys/personal_con/pc_list.jsp");
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
			String pc_create_name = request.getParameter("pc_create_name");
			String pc_create_identicard_id=request.getParameter("pc_create_identicard_id");
			String pc_object=request.getParameter("pc_object");
			String object_company=request.getParameter("object_company");
			String object_mobile=request.getParameter("object_mobile");
			String object_con=request.getParameter("object_con");
			String object_job=request.getParameter("object_job");
			String object_info=request.getParameter("object_info");
			
		   Personal_Con pc=new Personal_Con();
			pc.setId(id);
			pc.setPc_create_name(pc_create_name);
			pc.setPc_create_identicard_id(pc_create_identicard_id);
			pc.setPc_object(pc_object);
			pc.setObject_company(object_company);
			pc.setObject_mobile(object_mobile);
			pc.setObject_con(object_con);
			pc.setObject_job(object_job);
			pc.setObject_info(object_info);
			
			//2. 调用Service更新
			pcService.update(pc);
			//3. 跳转
			//list(request,response);
			uri = "/pc?method=list";
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
			pcService.delete(id);
			// 3. 跳转
			uri = "/pc?method=list";
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
			Personal_Con pc = pcService.findById(id);
			// 3. 保存
			request.setAttribute("pc", pc);
			// 4. 跳转
			uri = request.getRequestDispatcher("/sys/personal_con/pc_update.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
		
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 调用Service查询所有的数据
			List<Personal_Con> list = pcService.getAll();
			// 保存
			request.setAttribute("listObject", list);
			// 跳转的个人关系列表页面
			uri = request.getRequestDispatcher("/sys/personal_con/pc_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// 跳转
		goTo(request, response, uri);
	}
//添加
	private void addObject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1.获取请求封装数据
		try{
		int id =Integer.parseInt(request.getParameter("id"));
		String pc_create_name = request.getParameter("pc_create_name");
		String pc_create_identicard_id=request.getParameter("pc_create_identicard_id");
		String pc_object=request.getParameter("pc_object");
		String object_company=request.getParameter("object_company");
		String object_mobile=request.getParameter("object_mobile");
		String object_con=request.getParameter("object_con");
		String object_job=request.getParameter("object_job");
		String object_info=request.getParameter("object_info");
		
	   Personal_Con pc=new Personal_Con();
		pc.setId(id);
		pc.setPc_create_name(pc_create_name);
		pc.setPc_create_identicard_id(pc_create_identicard_id);
		pc.setPc_object(pc_object);
		pc.setObject_company(object_company);
		pc.setObject_mobile(object_mobile);
		pc.setObject_con(object_con);
		pc.setObject_job(object_job);
		pc.setObject_info(object_info);
		
		//2. 调用Service添加
		pcService.save(pc);
		uri = "/pc?method=list";
	} catch (Exception e) {
		e.printStackTrace();
		uri = "/error/error.jsp";
	}
		
		goTo(request, response, uri);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
