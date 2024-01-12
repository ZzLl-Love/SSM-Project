package cn.zyy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * @Author: Zz
 * @Date: 2023/11/16/17:33
 * @Description:
 *
 * springmvc 配置类
 */
@Configuration
@ComponentScan(value = {"cn.zyy.controller","cn.zyy.config","cn.zyy.exception"})
@EnableWebMvc
public class SpringMvcConfig {

}
