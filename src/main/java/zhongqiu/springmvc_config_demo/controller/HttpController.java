package zhongqiu.springmvc_config_demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HttpController implements HttpRequestHandler{

	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//给Request设置值，在页面进行回显
		request.setAttribute("hello", "这是HttpRequestHandler！");
		//跳转页面
		request.getRequestDispatcher("/WEB-INF/jsps/index.jsp").forward(request, response);
	}

}
