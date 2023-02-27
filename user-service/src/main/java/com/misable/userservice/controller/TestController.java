package com.misable.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: misable
 * @Package: com.misable.gateway.controller
 * @ClassName: TestController
 * @Author: wyc
 * @Description:
 * @Date: 2023/1/4 10:49
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class TestController {
    @RequestMapping(value = "/qryDkp", method = RequestMethod.GET)
    public String qryDkp(int num) {
        System.out.println("我接受到了"+num);
        return "Misable";
    }
}
