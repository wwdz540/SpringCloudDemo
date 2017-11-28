package cn.zhipingok.skatch.configservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
//@Todo 过滤器
@Component
@ServletComponentScan
@WebFilter(filterName = "myFilter",urlPatterns = "/*")
public class MyFilter implements Filter {
   private static final Logger LOG = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest sRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) sRequest;
        System.out.println("filter===="+request.getRequestURI());
        LOG.info("===filter ==");

           Map<String,String[]> map = request.getParameterMap();

           for(Map.Entry<String,String[]> entry:map.entrySet()){
               LOG.info(entry.getKey());
               LOG.info(entry.getValue()[0]);

           }

           filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
