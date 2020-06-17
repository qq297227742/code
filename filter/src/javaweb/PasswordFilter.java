package javaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "PasswordFilter")
public class PasswordFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        String initpwd = filterConfig.getServletContext().getInitParameter("password");
        String password = req.getParameter("password");
        if (initpwd.equals(password)) {
            chain.doFilter(req, resp);
        } else {
            req.setAttribute("msg","密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig=config;
    }

}
