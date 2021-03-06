package com.y3wegy.web.provider.controller.api.web.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.y3wegy.base.exception.ServiceException;
import com.y3wegy.base.tools.JackSonHelper;
import com.y3wegy.base.web.bean.user.SecurityUser;
import com.y3wegy.base.web.bean.user.UserRole;
import com.y3wegy.base.web.bean.web.ResponseJson;
import com.y3wegy.web.provider.service.web.UserService;

/**
 * @author y3wegy
 * @date 18-Mar-17
 * @RestController == @Controller + @ResponseBody  :only print content ,can't use for error link
 * @Controller for error link
 */
@RequestMapping("/api/user")
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    @RequestMapping(path = "/query", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseJson query(@RequestBody SecurityUser userInfo) throws JsonProcessingException, ServiceException {
        logger.info("enter query");
        /*String lastUser = (String) redisTemplate.opsForValue().get("UserName");
        logger.info(lastUser);
        redisTemplate.opsForValue().set("UserName",name);*/
        List<SecurityUser> userList = userService.queryUserByUserName(userInfo);
        /*ResponseJson responseJson = new ResponseJson().success(JackSonHelper.obj2JsonStr(userList));
        return JackSonHelper.getObjectMapper().writeValueAsString(responseJson);*/
        return new ResponseJson().success(JackSonHelper.obj2JsonStr(userList));
    }

    @RequestMapping(path = "/queryRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String queryRole(@RequestBody SecurityUser userInfo) throws JsonProcessingException, ServiceException {
        logger.info("enter queryRole");
        List<UserRole> userRoleList = userService.queryUserRolesByUserName(userInfo);
        ResponseJson responseJson = new ResponseJson().success(JackSonHelper.obj2JsonStr(userRoleList));
        return JackSonHelper.getObjectMapper().writeValueAsString(responseJson);
    }
}
