package in.jobcounsel.platform.request.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

@Configuration
public class AppRequestCustomInterceptor implements AsyncHandlerInterceptor {

	private static Map<String, Integer> requestIPMap = new HashMap<>();

	@Value("${application.interceptor.ipwrite.totalcount:500}")
	private Integer interceptorIPAddressWriteCount;

	@Value("${application.interceptor.ipwrite.filename}")
	private String interceptorIPAddressWriteFile;

	Logger logger = LoggerFactory.getLogger(AppRequestCustomInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ipAddress = request.getRemoteAddr();
		String requestName = request.getDispatcherType().name();
		if (requestName != null && !requestName.equalsIgnoreCase("ASYNC")) { // ASYNC is Skipped since we use
																				// DeferredResult in Which Case the
																				// request is split into REQUEST and
																				// ASYNC
			if (requestIPMap.containsKey(ipAddress)) {
				Integer totalCount = requestIPMap.get(ipAddress);
				requestIPMap.put(ipAddress, ++totalCount);
				if (totalCount > 10000)
					logger.error("Warning System Likely attacked with DOS Attack IP Address : {} ", ipAddress);
			} else {
				if (requestIPMap.size() > interceptorIPAddressWriteCount) {
					synchronized (AppRequestCustomInterceptor.class) {
						boolean result = AppInterceptorUtility.writeIPAddressToFile(interceptorIPAddressWriteFile,
								requestIPMap);
						if (result) {
							requestIPMap.clear();
							requestIPMap.put(ipAddress, 1);
						} else
							logger.error("Unable To Write To File IPAddress Of System Accessing Site");
					}
				} else {
					requestIPMap.put(ipAddress, 1);
				}
			}
		}
		return true;
	}
}
