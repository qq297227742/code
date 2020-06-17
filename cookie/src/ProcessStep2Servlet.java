import domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProcessStep2Servlet")
public class ProcessStep2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数：name，address，card。cardType
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String card = request.getParameter("card");
        String cardType = request.getParameter("cardType");

        Customer customer=new Customer();
        customer.setAddress(address);
        customer.setName(name);
        customer.setCardType(cardType);
        customer.setCard(card);

        //2.把请求信息存入到HttpSession 中
        HttpSession session = request.getSession();
//        session.setAttribute("name", name);
//        session.setAttribute("address",address);
//        session.setAttribute("card",card);
//        session.setAttribute("cardType",cardType);

        session.setAttribute("customer",customer);


        //3重定向到 confirm.jsp
        response.sendRedirect(request.getContextPath()+"/shoppingcart/confirm.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
