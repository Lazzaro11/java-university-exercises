package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAll", value = "/ShowAll")
public class ShowAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TSW EXERCISE
        CustomerDAO dao = new CustomerDAO();
        List<Customer> customers = dao.doRetrieveAll();

        request.setAttribute("customers", customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/showall.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
