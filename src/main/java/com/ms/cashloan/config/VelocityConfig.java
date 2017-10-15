package com.ms.cashloan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 * 视图模板velocity的配置
 * 
 * @author wuketao
 *
 */
@Configuration
public class VelocityConfig {

	@Bean
	public VelocityViewResolver getVelocityViewResolver() {
		VelocityLayoutViewResolver resolver = new VelocityLayoutViewResolver();
		resolver.setSuffix(".vm");
		resolver.setContentType("text/html;charset=utf-8");
		resolver.setExposeRequestAttributes(true);
		resolver.setExposeSessionAttributes(true);
//    resolver.setRequestContextAttribute(REQUEST_CONTEXT_ATTRIBUTE)
//    resolver.setToolboxConfigLocation(getToolboxConfigLocation)
		resolver.setLayoutUrl("layout/layout.vm");
		resolver.setOrder(0);
		return resolver;
	}
}
