package in.jobcounsel.platform.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import in.jobcounsel.platform.request.interceptor.AppRequestCustomInterceptor;

@Configuration
public class AppConfiguration implements WebMvcConfigurer{
	
	@Autowired
	private AppRequestCustomInterceptor requestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
	}
}
