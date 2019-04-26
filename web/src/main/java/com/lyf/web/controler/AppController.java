package com.lyf.web.controler;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("app")
public class AppController {

    @HystrixCommand(fallbackMethod = "slowQueryFallback")
    @RequestMapping(path = "user", method = RequestMethod.GET)
    @ResponseBody
    public Object userGet() {
        return "GET";
    }

    @RequestMapping(path = "user", method = RequestMethod.PUT)
    @ResponseBody
    public Object userUpdate() {
        return "PUT";
    }

    @RequestMapping(path = "user", method = RequestMethod.POST)
    @ResponseBody
    public Object userAdd() {
        return "POST";
    }
}
