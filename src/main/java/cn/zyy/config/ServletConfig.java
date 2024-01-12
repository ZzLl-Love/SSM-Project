package cn.zyy.config;

import cn.zyy.filter.CharacterEncodingFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;


/**
 * @Author: Zz
 * @Date: 2023/11/16/17:35
 * @Description: 致敬
 */
@Configuration
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置spring交给web管理
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 配置springMvc交给web管理
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


}
