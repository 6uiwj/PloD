package ming.dCommunity.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//스프링 설정 클래스
//WebMvcConfigurer 상속 :  Spring MVC 설정을 추가적으로 수정
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    //메시지 리소스 사용 설정
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTF-8");
        ms.setBasenames("messages.errors");

        return ms;
    }
}
