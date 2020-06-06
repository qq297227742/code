import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

public class LoginServlet extends MyGenericServlet  {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("请求来了...");

        String user = servletRequest.getParameter("user");
        String password = servletRequest.getParameter("password");
        System.out.println(user+":"+password);

        String[] interestings = servletRequest.getParameterValues("interesting");
        for (String interesting:interestings){
            System.out.println("interesting:"+interesting);
        }

        Enumeration<String> names = servletRequest.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }

        System.out.println("##########################");
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey());
            for (String value : entry.getValue()) {
                System.out.println(entry.getKey()+":"+value);
            }
        }

        //设置响应类型
        servletResponse.setContentType("applicaton/msword");

        PrintWriter writer = servletResponse.getWriter();
        writer.println("HelloWorld...");

    }

}
