package mvcapp.servlet;

import mvcapp.dao.CriteriaCustomer;
import mvcapp.dao.CustomerDAO;
import mvcapp.dao.impl.CustomerDAOJdbcImpl;
import mvcapp.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private CustomerDAO customerDAO=new CustomerDAOJdbcImpl();
/*    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method) {
            case "add":
                add(request, response);
                break;
            case "query":
                query(request,response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                response.sendRedirect("/index.jsp");
        }
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        System.out.println(servletPath);

        String name=servletPath.substring(1);
        name=name.substring(0, name.length() - 3);

        try {
            //利用反射获取 name 对应的方法
            System.out.println();
            Method method = getClass().getDeclaredMethod(name, HttpServletRequest.class, HttpServletResponse.class);
            //利用反射调用对应的方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
           e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name=request.getParameter("name");
        String oldName = request.getParameter("oldName");
        int id= Integer.parseInt(request.getParameter("id"));
        String address=request.getParameter("address");
        String phone = request.getParameter("phone");


        if (!oldName.equals(name)) {
            long count = customerDAO.getCountWithName(name);
            if (count > 0) {
                request.setAttribute("msg","用户名"+name+"已被占用，请重新选择");
                request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
            }
        }
        Customer customer=new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);

        customerDAO.update(customer);

        response.sendRedirect("query.do");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idStr = request.getParameter("id");
        try {
            int id = Integer.parseInt(idStr);
            customerDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("query.do");
    }

    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        CriteriaCustomer cc = new CriteriaCustomer(name, phone, address);



        //1.调用 CustomerDAO 的 getALL 方法
        List<Customer> list = customerDAO.getForListWithCriteriaCustomer(cc);

        //2。把Customer 的集合 放入 request 中
        request.setAttribute("customers", list);

        //3.转发页面到 index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("edit");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDAO.get(id);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("/updatecustomer.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("add");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);

        long flag = customerDAO.getCountWithName(name);

        if (flag > 0) {

            String msg = "此用户已存在";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);

        } else {
            customerDAO.save(customer);
            response.sendRedirect("success.jsp");
        }
    }
}
