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
    public Object userGet() throws Exception {
        int random = (int) (Math.random() * 10) + 1;

        if (random % 3 == 0) {
            throw new Exception("test exception");
        }

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

    private Object slowQueryFallback() {
        System.out.println("slowQueryFallback");
        return "slowQueryFallback";
    }
}
