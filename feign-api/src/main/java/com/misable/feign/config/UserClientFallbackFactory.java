package com.misable.feign.config;

import com.misable.feign.clients.UserClients;
import com.misable.feign.pojo.DkpUser;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @ProjectName: misable
 * @Package: com.misable.feign.config
 * @ClassName: UserClientFallbackFactory
 * @Author: wyc
 * @Description: 实现FallbackFactory
 * @Date: 2023/2/22 14:51
 * @Version: 1.0
 */
@Slf4j
public class UserClientFallbackFactory implements FallbackFactory<UserClients> {
    @Override
    public UserClients create(Throwable throwable) {
        //创建UserClient接口实现类,实现其中的方法,编写失败降级的处理逻辑
        return new UserClients() {
            @Override
            public DkpUser findById(Long id) {
                log.error("查询用户失败",throwable);
                return new DkpUser();
            }
        };
    }
}
