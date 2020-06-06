import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForwardServlet")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ForwardServlet's doGet");

        //请求的转发
        //1.调用HttpServletRequest 的getRequestDispatcher 方法 获取RequestDispatcher 对象
        String path="testServlet";
        RequestDispatcher dispatcher = request.getRequestDispatcher("/" + path);
        //2.调用RequestDispatcher 的 forward 方法进行请求转发
        dispatcher.forward(request,response);
    }
}
