package com.lyf.web.controler;

import com.lyf.web.model.Hero;
import com.lyf.web.service.Functionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {
    @Autowired
    private Functionservice functionservice;//坑：忘了标注实现类@Service,一直报错

    @RequestMapping("/user")
    public String user(){
       return "user";
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest req, HttpServletResponse resp,Model  model) throws ServletException, IOException {
      if(req.getParameter("username").equals("root") && req.getParameter("password").equals("123456")){
          List<Hero> list = functionservice.findAll();
          model.addAttribute("list", list);
           return "allHero";
       }else{
          return "user";
       }
    }
    @RequestMapping("/allHero")
    public String allHero(Model  model) {
            List<Hero> list = functionservice.findAll();
            model.addAttribute("list", list);
            return "allHero";
    }

    @RequestMapping("/toUpdate")//点击修改后先跳转到修改页面updateHero.jsp

    public String toUpdate(Model model,int id) {
        Hero hero=functionservice.findById(id);
        model.addAttribute("hero",hero);
        return "updateHero";
    }

    @RequestMapping("/update")
    public String userUpdate(Model model,Hero hero) {
        functionservice.updateHero(hero);
        hero=functionservice.findById(hero.getId());
        model.addAttribute("hero",hero);
        return "redirect:/app/allHero";
    }
    @RequestMapping("/delete")
    public String delete(Model model,int id){
        functionservice.deleteById(id);
        return "redirect:/app/allHero";
    }

    @RequestMapping("toAddHero")
    //@ResponseBody:有这个注解的时候返回结果直接写入HTTP response body中，不会被解析为跳转路径
    public String toAddHero() {
        return "addHero";
    }
    @RequestMapping("addHero")
    public String userAdd(Hero hero) {//直接用对象来接收表单数据，前台将会把数据自动封装成对象，真妙啊
        functionservice.insertHero(hero);
        return "redirect:/app/allHero";
    }
}
