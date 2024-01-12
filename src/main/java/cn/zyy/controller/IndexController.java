package cn.zyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Zz
 * @Date: 2023/11/16/18:50
 * @Description: 致敬
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "/pages/items.html";
    }
}
