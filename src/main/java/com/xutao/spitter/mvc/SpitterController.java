package com.xutao.spitter.mvc;

import com.xutao.spitter.common.ImageUploadException;
import com.xutao.spitter.domain.Spitter;
import com.xutao.spitter.service.SpitterService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * Created by Tau_Hsu on 2016/10/8.
 */
@Controller
@RequestMapping("/spitter")//根URL路径
public class SpitterController {
    private final SpitterService spitterService;

    @Autowired
    SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/spittles",method = RequestMethod.GET)//处理针对/spitter/spittles的get请求
    public String listSpittlesForSpitter(@RequestParam("spitter") String username, Model model){
        Spitter spitter = spitterService.getSpitter(username);
        model.addAttribute(spitter);//填充模型
        model.addAttribute(spitterService.getSpittlesForSpitter(username));
        return "spittles/list";
    }
    @RequestMapping(method = RequestMethod.GET, params = "new")//说明此请求的路径为http://localhost:8080/Spitter/spitter?new
    //http://localhost:8080/Spitter(Servlet上下文)/spitter(SpitterController来处理)?new("new"查询参数)
    //这个意味着这个方法只处理/spitter的HTTP GET 请求并要求请求中必须包含名为new的查询参数
    public String creatSpitterProfile(Model model) {
        model.addAttribute(new Spitter());
        return "spitters/edit";
    }

    @RequestMapping(method = RequestMethod.POST)
    //@Valid 表明在传入Spitter之前需要通过验证，如果效验出错，效验错误会会通过BindingResult传递给此方法
    //@RequestParam(value = "image",required = false)表示这个参数不是必须的，所以用户不提供头像图片也可以注册
    public String addSpitterFromForm(@Valid Spitter spitter, BindingResult bindingResult,
                                     @RequestParam(value = "image",required = false) MultipartFile image,
                                     HttpSession session){

        if(bindingResult.hasErrors()){//检查错误
            System.out.println("(bindingResult.hasErrors()");
//            bindingResult.getFieldError();获得验证失败字段的错误信息
            return "spitters/edit";//重新打开，注意路径写法
        }

        spitterService.saveSpitter(spitter);//保存Spitter

        //TODO 如何得到项目的根目录
        // session.getServletContext().getContextPath()得到的是诸如/Spitter,而并非实际的路径
        // 通过getRealPath(File.separator)得到项目根目录的路径,在target/project-name-version/ 很容易理解

        String webRootPath = session.getServletContext().getRealPath(File.separator);
        String imageStorePath = webRootPath + "/resources/";

        try{
            if (!image.isEmpty()){
                validateImage(image);//效验图片
                saveImage(imageStorePath + spitter.getId() + ".jpg",image);
            }else{
                return "spitters/edit";
            }
        }catch (ImageUploadException e){
            bindingResult.reject(e.getMessage());
            e.printStackTrace();
            return "spitters/edit";
        }
        return "redirect:/spitter/" + spitter.getUsername();//POST之后进行重定向
    }

    private void validateImage(MultipartFile image){
        if(!"image/jpeg".equals(image.getContentType())){
            throw new ImageUploadException("Only JPG images accepted");
        }
    }

    private void saveImage(String filePath,MultipartFile image){
        try {
            File file = new File(filePath);
            FileUtils.writeByteArrayToFile(file, image.getBytes());
        }catch (IOException e){
            throw new ImageUploadException("Unable to save image to local");
        }
    }

    //{username}占位符，@PathVariable String username会拿取{username}的值传入此方法
    @RequestMapping(method = RequestMethod.GET,value = "/{username}")
    public String showSpitterProfile(@PathVariable String username,Model model){
        // 加入的属性不能为空, IllegalArgumentException: Model object must not be null
        // 所以需要判断处理
        model.addAttribute((spitterService.getSpitter(username)== null) ? Spitter.FAKE_SPITTER : spitterService.getSpitter(username));
        return "spitters/view";
    }
}

