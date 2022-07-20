package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyPostMethod
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/14 19:32
 */

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/yangfan")
public class MyPostMethod {

    //这个变量是用来装我们cookies信息的
    private static Cookie cookie;

    //用户登录成功后获取到cookies，再访问其他接口获取到列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "用户名",required = true) String userName,
                        @RequestParam(value = "密码",required = true) String passworld)
    {
  if(userName.equals("zhangsan") && passworld.equals("123456")){
      cookie = new Cookie("login","true");
      response.addCookie(cookie);
      return "恭喜你登录成功了";
  }
  return "用户名或密码错误";
    }

}
