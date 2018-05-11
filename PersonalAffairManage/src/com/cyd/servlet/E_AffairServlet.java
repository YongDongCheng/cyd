package com.cyd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyd.entity.E_Affair;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IE_AffairService;

/**
 * 4. 个人事务管理Servlet开发
 * 
 * a. 添加个人事务数据
 * b. 个人事务列表展示
 * c. 进入更新页面
 * d. 删除
 * e. 更新
 * 
 * @author YongDong.Cheng
 */
@WebServlet("/ea")
public class E_AffairServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 调用的个人关系Service
				private IE_AffairService eaService = BeanFactory.getInstance("eaService",IE_AffairService.class);
				// 跳转资源
				private Object uri;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				
				// 获取操作的类型
				String method = request.getParameter("method");
				// 判断
				if ("addAffair".equals(method)) {
					// 添加
					addAffair(request, response);
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
			String ea_create_name = request.getParameter("ea_create_name");
			
			//由于是get，所以在编码时，先要将name传过来的乱码ISO一下，然后utf-8返回原先的字节编码
			ea_create_name= new String(ea_create_name.getBytes("ISO8859-1"), "utf-8");
			
			 E_Affair ea= new  E_Affair();
			 ea.setEa_create_name(ea_create_name);
			//2. 调用Service更新
				List< E_Affair> list =eaService.getAll(ea_create_name);
				request.setAttribute("listAffair", list);
				//3. 跳转
				//list(request,response);
				//uri = "/user?method=search";
				uri = request.getRequestDispatcher("/sys/e_affair/ea_list.jsp");
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
			String ea_create_name = request.getParameter("ea_create_name");
			String ea_create_identicard_id=request.getParameter("ea_create_identicard_id");
			String ea_object=request.getParameter("ea_object");
			String ea_place=request.getParameter("ea_place");
			String ea_content=request.getParameter("ea_content");
			String ea_info=request.getParameter("ea_info");
			
			
			 E_Affair ea= new  E_Affair();
			ea.setId(id);
			ea.setEa_create_name(ea_create_name);
			ea.setEa_create_identicard_id(ea_create_identicard_id);
			ea.setEa_object(ea_object);
			ea.setEa_place(ea_place);
			ea.setEa_content(ea_content);
			ea.setEa_info(ea_info);
			
			//2. 调用Service更新
			eaService.update(ea);
			//3. 跳转
			//list(request,response);
			uri = "/ea?method=list";
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
			eaService.delete(id);
			// 3. 跳转
			uri = "/ea?method=list";
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
			E_Affair ea = eaService.findById(id);
			// 3. 保存
			request.setAttribute("ea", ea);
			// 4. 跳转
			uri = request.getRequestDispatcher("/sys/e_affair/ea_update.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
		
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 调用Service查询所有的数据
			List<E_Affair> list = eaService.getAll();
			// 保存
			request.setAttribute("listAffair", list);
			// 跳转的个人关系列表页面
			uri = request.getRequestDispatcher("/sys/e_affair/ea_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// 跳转
		goTo(request, response, uri);
		
	}


	private void addAffair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		//1.获取请求封装数据
		int id =Integer.parseInt(request.getParameter("id"));
		String ea_create_name = request.getParameter("ea_create_name");
		String ea_create_identicard_id=request.getParameter("ea_create_identicard_id");
		String ea_object=request.getParameter("ea_object");
		String ea_place=request.getParameter("ea_place");
		String ea_content=request.getParameter("ea_content");
		String ea_info=request.getParameter("ea_info");
		
		
		 E_Affair ea= new  E_Affair();
		ea.setId(id);
		ea.setEa_create_name(ea_create_name);
		ea.setEa_create_identicard_id(ea_create_identicard_id);
		ea.setEa_object(ea_object);
		ea.setEa_place(ea_place);
		ea.setEa_content(ea_content);
		ea.setEa_info(ea_info);
		
		//2. 调用Service更新
		eaService.save(ea);
		//3. 跳转
		//list(request,response);
		uri = "/ea?method=list";
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
