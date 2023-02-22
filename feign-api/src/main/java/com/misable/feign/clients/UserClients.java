package com.misable.feign.clients;

import com.misable.feign.pojo.DkpUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName: webdkp
 * @Package: com.example.webdkp.Feign
 * @ClassName: UserClients
 * @Author: wyc
 * @Description:
 * @Date: 2022/12/26 14:20
 * @Version: 1.0
 */
@FeignClient("userService")
public interface UserClients {
    @GetMapping("/user/{id}")
    DkpUser findById(@PathVariable("id") Long id);
}
