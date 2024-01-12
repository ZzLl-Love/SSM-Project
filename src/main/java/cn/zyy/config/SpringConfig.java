package cn.zyy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: Zz
 * @Date: 2023/11/16/17:15
 * @Description: 致敬
 */
@Configuration
@ComponentScan(value={"cn.zyy.service","cn.zyy.domain"})
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@Import({DbConfig.class, MybatisConfig.class})
public class SpringConfig {
}
