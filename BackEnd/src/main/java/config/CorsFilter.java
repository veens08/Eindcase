package config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/resources/*")
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // niet nodig
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        httpResponse.addHeader("Access-Control-Allow-Headers", "*");
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST");
        filterChain.doFilter(servletRequest, httpResponse);    }

    @Override
    public void destroy() {

    }
}
