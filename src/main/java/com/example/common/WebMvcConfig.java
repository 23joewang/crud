package com.example.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//設定跨域訪問
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//可以被跨域的路徑，”/**”表示無限制。
                .allowedHeaders("Content-Type","X-Requested-With","accept,Origin","Access-Control-Request-Method","Access-Control-Request-Headers","token")
                .allowedMethods("*")//允許跨域訪問資源伺服器的請求方式，如：POST、GET、PUT、DELETE等，“*”表示無限制。
                .allowedOrigins("*")//”*”允許所有的請求域名訪問跨域資源，當設定具體URL時只有被設定的url可以跨域訪問。例如：allowedOrigins(“https://www.baidu.com”),則只有https://www.baidu.com能訪問跨域資源。
                .allowCredentials(false);
    }
}
