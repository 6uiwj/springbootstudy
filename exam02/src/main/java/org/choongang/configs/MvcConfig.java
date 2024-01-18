package org.choongang.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing //EntityListener 설정 활성화
public class MvcConfig implements WebMvcConfigurer { //MVC관련 설정?

}