package ru.kpfu.voice_assistant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/save-page").setViewName("save-page");
        registry.addViewController("/save-domains").setViewName("save-domains");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/widget").setViewName("widget");
        registry.addViewController("/test-widget").setViewName("test-widget");
        registry.addViewController("/tokens").setViewName("tokens");
        registry.addViewController("/faq").setViewName("faq");
        registry.addViewController("/").setViewName("redirect:/home");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/save-filters").setViewName("save-filters");
    }
}