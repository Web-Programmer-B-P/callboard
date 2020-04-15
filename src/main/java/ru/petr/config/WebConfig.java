package ru.petr.config;

import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ru.petr.entity.Session;

@Configuration
@EnableWebMvc
@ComponentScan("ru.petr")
public class WebConfig implements WebMvcConfigurer {
    private static final String VIEW_PATH = "/WEB-INF/view/";
    private static final String EXTENSION = ".jsp";
    private static final String WEB_INF_CSS = "/WEB-INF/resources/css/";
    private static final String CSS_ALIAS = "/css/**";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(CSS_ALIAS).addResourceLocations(WEB_INF_CSS);
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix(VIEW_PATH);
        resolver.setSuffix(EXTENSION);
        resolver.setRequestContextAttribute("requestContext");
        return resolver;
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session session() {
        return new Session();
    }
}
