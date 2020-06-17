package javaweb;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义的HttpFilter，实现自 Filter 接口
 * @author weiwei
 */
public abstract class HttpFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        ini();
    }

    protected abstract void ini();

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        doFilter(request, response,filterChain);
    }

    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response,FilterChain filterChain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}
