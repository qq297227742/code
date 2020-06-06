import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet extends MyGenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            if (servletResponse instanceof HttpServletResponse) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;

                service(request,response);
            }
        }

    }
    public void service(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws ServletException, IOException {

        //1.获取请求方式
        String method=httpServletRequest.getMethod();
        //2.根据请求再调用对应的处理方法
        if ("GET".equalsIgnoreCase(method)) {
            doGet(httpServletRequest, httpServletResponse);
        } else if ("POST".equalsIgnoreCase(method)) {
            doPost(httpServletRequest,httpServletResponse);
        }
    }

    private void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException  {

    }

    private void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException  {

    }
}
