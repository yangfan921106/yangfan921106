package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName MyGetMethod
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/14 12:30
 */

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {

        //HttpServerletRequest   装请求信息的类
        //HttpServerletResponse   装响应信息的类
        Cookie cookie = new Cookie("YANGFAN","TEST");
        response.addCookie(cookie);

        return "恭喜你获取cookie成功";
    }


    /*
    需要携带cookies才能访问的get请求
     */
    @RequestMapping(value = "/GetWithCookie",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();

        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜你访问成功！！";
            }
        }
        return "你必须携带cookies信息来";
    }

    /*
    开发一个需要携带参数才能访问的get请求
    第一种实现方式：url：key=value&key=value
    我们来模拟获取商品列表
    访问路径：
    http://localhost:8888//get/with/param?start=10&end=20
     */

    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求方法一",httpMethod = "GET")
    public Map<String,Integer> getlist(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> mylist = new HashMap<>();
        mylist.put("粉底液",248);
        mylist.put("飞哥",99999999);
        mylist.put("方便面",1);

        return mylist;

    }

    /*
    第二种需要携带参数访问的get请求
    不同的是路径不一样
    url:ip:port/get/with/param/10/20
    访问路径：
    http://localhost:8888//get/with/param/10/20
     */


    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数才能访问的get请求方法二",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> mylist = new HashMap<>();
        mylist.put("粉底液",248);
        mylist.put("飞哥",99999999);
        mylist.put("方便面",1);

        return mylist;
    }



}
