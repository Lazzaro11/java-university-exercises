package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;

@WebServlet(name = "AddCustomerServlet", value = "/add-customer")
public class AddCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Elabora la richiesta
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TSW EXERCISE
        String nome = request.getParameter("firstName");

        String cognome = request.getParameter("lastName");

        Double balance = Double.parseDouble(request.getParameter("balance"));

        Customer c = new Customer();
        c.setFirstName(nome);
        c.setLastName(cognome);
        c.setBalance(balance);

        CustomerDAO dao = new CustomerDAO();
        dao.doSave(c);

        request.setAttribute("customer", c);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/results/success.jsp");

        dispatcher.forward(request, response);
    }
}
