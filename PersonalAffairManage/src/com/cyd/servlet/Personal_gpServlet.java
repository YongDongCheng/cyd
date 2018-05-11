package com.cyd.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyd.entity.Personal_gp;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IPersonal_gpService;

/**
 * Servlet implementation class Personal_gpServlet
 */
@WebServlet("/pgp")
public class Personal_gpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 调用的个人关系Service
	private IPersonal_gpService pgpService = BeanFactory.getInstance("pgpService",IPersonal_gpService.class);
	// 跳转资源
	private Object uri; 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取操作的类型
		String method = request.getParameter("method");
		// 判断
		if ("addGP".equals(method)) {
			// 添加
			addGP(request, response);
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
			String pgp_create_name = request.getParameter("pgp_create_name");
			
			//由于是get，所以在编码时，先要将name传过来的乱码ISO一下，然后utf-8返回原先的字节编码
			pgp_create_name= new String(pgp_create_name.getBytes("ISO8859-1"), "utf-8");
			
			Personal_gp pgp=new Personal_gp();
			 pgp.setPgp_create_name(pgp_create_name);
			//2. 调用Service更新
				List< Personal_gp> list =pgpService.getAll(pgp_create_name);
				request.setAttribute("listGP", list);
				//3. 跳转
				//list(request,response);
				//uri = "/user?method=search";
				uri = request.getRequestDispatcher("/sys/personal_gp/pgp_list.jsp");
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
			String pgp_create_name = request.getParameter("pgp_create_name");
			String pgp_create_identicard_id=request.getParameter("pgp_create_identicard_id");
			int getmoney=Integer.parseInt(request.getParameter("getmoney"));
			int paymoney=Integer.parseInt(request.getParameter("paymoney"));
			String pgp_info=request.getParameter("pgp_info");
			
			
			Personal_gp pgp=new Personal_gp();
			pgp.setId(id);
			pgp.setPgp_create_name(pgp_create_name);
			pgp.setPgp_create_identicard_id(pgp_create_identicard_id);
			pgp.setGetmoney(getmoney);
			pgp.setPaymoney(paymoney);
			pgp.setPgp_info(pgp_info);
			
			//2. 调用Service更新
			pgpService.update(pgp);
			//3. 跳转
			//list(request,response);
			uri = "/pgp?method=list";
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
			pgpService.delete(id);
			// 3. 跳转
			uri = "/pgp?method=list";
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
			Personal_gp pgp= pgpService.findById(id);
			// 3. 保存
			request.setAttribute("pgp", pgp);
			// 4. 跳转
			uri = request.getRequestDispatcher("/sys/personal_gp/pgp_update.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		goTo(request, response, uri);
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 调用Service查询所有的数据
			List<Personal_gp> list = pgpService.getAll();
			// 保存
			request.setAttribute("listGP", list);
			// 跳转的个人关系列表页面
			uri = request.getRequestDispatcher("/sys/personal_gp/pgp_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}
		
		// 跳转
		goTo(request, response, uri);
		
	}

	private void addGP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		//1. 获取请求数据封装
		int id =Integer.parseInt(request.getParameter("id"));
		String pgp_create_name = request.getParameter("pgp_create_name");
		String pgp_create_identicard_id=request.getParameter("pgp_create_identicard_id");
		int getmoney=Integer.parseInt(request.getParameter("getmoney"));
		int paymoney=Integer.parseInt(request.getParameter("paymoney"));
		String pgp_info=request.getParameter("pgp_info");
		
		
		Personal_gp pgp=new Personal_gp();
		pgp.setId(id);
		pgp.setPgp_create_name(pgp_create_name);
		pgp.setPgp_create_identicard_id(pgp_create_identicard_id);
		pgp.setGetmoney(getmoney);
		pgp.setPaymoney(paymoney);
		pgp.setPgp_info(pgp_info);
		
		//2. 调用Service更新
		pgpService.save(pgp);
		//3. 跳转
		//list(request,response);
		uri = "/pgp?method=list";
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
