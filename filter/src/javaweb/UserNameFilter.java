package javaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "UserNameFilter")
public class UserNameFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        String initName = filterConfig.getInitParameter("name");
        String username = req.getParameter("username");
        if (initName.equals(username)) {
            chain.doFilter(req, resp);
        } else {
            req.setAttribute("msg","用户名错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
      this.filterConfig=config;
    }

}
