package fr.formation.config;

import java.util.*;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.*;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.*;
import org.springframework.web.servlet.view.*;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;

@Configuration
@Import(value = { AppConfig.class, SecurityConfig.class })
@EnableWebMvc
@ComponentScan(basePackages = { "fr.formation.controllers",
	"fr.formation.restcontrollers" })
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/static/**")
		.addResourceLocations("/static/");
    }

    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setViewClass(JstlView.class);
	viewResolver.setPrefix("/WEB-INF/jspf/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
	ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
	source.setBasename("classpath:messages");
	return source;
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
	CookieLocaleResolver resolver = new CookieLocaleResolver();
	resolver.setCookieName("lang");
	resolver.setDefaultLocale(Locale.FRANCE);
	return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	interceptor.setParamName("lang");
	registry.addInterceptor(interceptor);
    }

    @Bean
    public ReloadableResourceBundleMessageSource validationMessageSource() {
	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	messageSource.setBasename("classpath:errors");
	return messageSource;
    }

    @Override
    public Validator getValidator() {
	LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
	validator.setValidationMessageSource(validationMessageSource());
	return validator;
    }

    @Override
    public void configureMessageConverters(
	    List<HttpMessageConverter<?>> converters) {
	Hibernate5Module module = new Hibernate5Module();
	module.disable(Feature.USE_TRANSIENT_ANNOTATION);
	module.enable(Feature.FORCE_LAZY_LOADING);
	Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	builder.modulesToInstall(module);
	converters
		.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }
}