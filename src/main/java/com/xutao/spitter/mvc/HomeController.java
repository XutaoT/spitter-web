package com.xutao.spitter.mvc;

import com.xutao.spitter.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by Tau_Hsu on 2016/10/6.
 */
@Controller//声明控制器 @Controller 是@Component注解的一种 <context:component-scan>将查找@Component注解的类并将其注册为Bean
public class HomeController {
    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    private SpitterService spitterService;



    @Autowired //注入spitterService
    public HomeController(SpitterService spitterService){
        this.spitterService = spitterService;
    }

    @RequestMapping({"/","/home"})//处理对首页的请求，处理‘/’，‘/home’路径的请求
    public String showHomePage(Map<String,Object> model){
        //map代表的模型-控制器和视图之间传递的数据，这样当视图渲染的时候，就可以展现出来
        //同时我们也可将HttpServletRequest,HttpServletResponse,String传递过来，获得需要的数据
        model.put("spittles",spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));
        return "home";//返回视图名称，DispatcherServlet将会使用视图解析器来根据这个名字查找真正的视图实现，
        // 控制器不直接参与渲染结果给客户端
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
                                  @RequestParam(value = "logout",required = false) String logout){
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;
    }
}
