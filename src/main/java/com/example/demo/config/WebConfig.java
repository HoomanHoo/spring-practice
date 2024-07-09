package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //cross-origin request를 허용할 URL 목록
                .allowedOriginPatterns("*") //요청을 허용할 출처 목록 - * 는 전체를 의미한다
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메서드 목록
                .allowedHeaders("Authorization", "Content-Type")  // 허용할 HTTP Request Header 목록
                .exposedHeaders("Custom-Header")                  // 허용할 HTTP Response Header 목록
                .allowCredentials(false)  // 쿠키와 같은 자격증명을 포함한 요청의 허용 여부 - true 설정 시 보안상의 이슈 발생 위험성 존재
                .maxAge(3600); // preflight 요청에 대한 응답을 브라우저에서 캐싱하는 시간
    }
}

