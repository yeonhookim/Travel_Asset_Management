package org.scoula.backend.config;

// Spring MVC 설정 클래스
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 로그인 체크 인터셉터 등록
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/trip/**", "/member/**", "/board/**", "/budget/**")
                .excludePathPatterns("/login", "/signup", "/css/**", "/js/**"); // 로그인/회원가입 등은 예외
    }
}
