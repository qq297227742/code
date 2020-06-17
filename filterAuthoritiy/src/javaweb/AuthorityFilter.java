package javaweb;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "AuthorityFilter")
public class AuthorityFilter extends HttpFilter {


    @Override
    protected void ini() {

    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String servletPath = request.getServletPath();

        List<String> uncheckedUrls= Arrays.asList("/403.jsp","/login.jsp","/logout.jsp","/articles.jsp","/authority-manager.jsp");
        if (uncheckedUrls.contains(servletPath)) {
            filterChain.doFilter(request, response);
            return;
        }
            User user = (User) request.getSession().getAttribute("user");
            if(user==null){
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        List<Authority> authorities = user.getAuthorities();
        Authority authority = new Authority(null, servletPath);
        if (authorities.contains(authority)) {
            filterChain.doFilter(request, response);
            return;
        }
        response.sendRedirect(request.getContextPath() + "/403.jsp");
    }
}
