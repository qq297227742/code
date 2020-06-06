import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
        String user = servletConfig.getInitParameter("user");
        System.out.println(user);

        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String element = names.nextElement();
            System.out.println(element);
        }

//        获取ServletContext对象
        ServletContext servletContext = servletConfig.getServletContext();

        String driver = servletContext.getInitParameter("driver");
        System.out.println("driver:"+driver);

        Enumeration<String> names1 = servletContext.getInitParameterNames();
        while (names1.hasMoreElements()) {
            String name = names1.nextElement();
            System.out.println(name);
        }

        String realPath = servletContext.getRealPath("idnex.jsp");
        System.out.println(realPath);

        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream("index.jsp");
        System.out.println("1:" + is);

        InputStream is2 = servletContext.getResourceAsStream("index.jsp");
        System.out.println("2:"+is2);
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    public HelloServlet() {
        System.out.println("HelloServlet's constructor");
    }
}
