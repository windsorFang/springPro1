package config;

import com.sun.deploy.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器不要放到component-scan的包下，这问题也只是在web项目，springboot不存在这个问题。
 */
public class MyInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        logger.info("url::" + url);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            logger.info(cookie.getName() + ":" + cookie.getValue());
        }
        return true;
    }
}
