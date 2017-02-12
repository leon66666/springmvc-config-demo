package zhongqiu.springmvc_config_demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import zhongqiu.springmvc_config_demo.domain.User;


//从页面接受参数，封装javaBean对象
public class CommandController extends AbstractCommandController{
	
	//指定参数绑定到哪个javaBean
	public CommandController(){
		
		this.setCommandClass(User.class);
		
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		//把命令对象强转成User对象
		User user = (User) command;
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("user", user);
		
		mv.setViewName("index");
		
		return mv;
	}
	
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		String str = request.getParameter("birthday");
		
		if(str.contains("/")){

			binder.registerCustomEditor(Date.class, 
					new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
		}else{

			binder.registerCustomEditor(Date.class, 
					new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));	
			
		}
	}
}

