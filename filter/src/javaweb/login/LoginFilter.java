package javaweb.login;

import javaweb.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginFilter extends HttpFilter {
    //1.从web.xml 文件中获取 sessionKey，redirectUrl，uncheckedUrls
    private String sessionKey;
    private String redirectUrl;
    private String uncheckedUrls;
    @Override
    protected void ini() {

        sessionKey = getFilterConfig().getServletContext().getInitParameter("userSessionKey");
        redirectUrl = getFilterConfig().getServletContext().getInitParameter("redirectPage");
        uncheckedUrls = getFilterConfig().getServletContext().getInitParameter("uncheckedUrls");

    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {


        //1.获取请求的URL
        //requestUrl:http://localhost:8080/filter_war_exploded/login/list.jsp
        String requestUrl = request.getRequestURL().toString();
        //requestUri:/filter_war_exploded/login/list.jsp
        String requestUri=request.getRequestURI();
        //servletPath:/login/list.jsp
        String servletPath=request.getServletPath();


        System.out.println("requestUri:"+requestUri);
        System.out.println("requestUrl:"+requestUrl);
        System.out.println("servletPath:"+servletPath);

        //2.检查1 中 获取的servletPath 是否为不需要检查的 URL 中的一个，若是 则直接放行，方法结束
        List<String> urls = Arrays.asList(uncheckedUrls.split(","));
        if (urls.contains(servletPath)) {
            filterChain.doFilter(request,response);
        }else {

            //3.从session 中获取 sessionKey 对应的值，若不存在，则重定向到 redirectUrl
            HttpSession session = request.getSession();
            String name= (String) session.getAttribute(sessionKey);
            if (name!=null){
                filterChain.doFilter(request,response);
            }else {
                System.out.println(requestUri);
                response.sendRedirect(request.getContextPath()+redirectUrl);
            }

        }
        //4.若存在 则放行，允许访问
    }
}
