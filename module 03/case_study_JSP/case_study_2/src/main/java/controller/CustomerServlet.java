package controller;

import model.service.CustomerService;
import model.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FuramaServlet", urlPatterns = { "/customer"})
public class FuramaServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action= "";
        }

        switch (action){
            case "add":

                break;
            case "edit":

                break;
            case "delete":

                break;
            default:
                showCustomerList(request, response);
                break;
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", customerService.findAll());
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("view/customer/customerList.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
