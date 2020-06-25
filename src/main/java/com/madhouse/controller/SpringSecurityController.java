package com.madhouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-11 14:43
 */
@RestController
public class SpringSecurityController {

    @RequestMapping(value = "api/springboot/hello")
    public String hello() {
        return "hello,springboot test security!";
    }

    @RequestMapping(value = "api/springboot/user")
    public String user() {
        return "hello,我是用户角色!";
    }

    @RequestMapping(value = "api/springboot/admin")
    public String admin() {
        return "hello,我是管理员角色!";
    }
    
}
