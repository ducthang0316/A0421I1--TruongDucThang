package controller;

import model.bean.Customer;
import model.service.CustomerService;
import model.service.CustomerTypeService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = { "/customer"})
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService= new CustomerTypeServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null){
            action= "";
        }

        switch (action){
            case "add":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                search(request, response);
                break;
            default:
                showCustomerList(request, response);
                break;
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action= "";
        }

        switch (action){
            case "add":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                showCustomerList(request, response);
                break;
        }
    }



    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("customerList", customerService.findAll());
        request.setAttribute("typeList", customerTypeService.findAll());
        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("view/customer/customerList.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    create new customer
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/customer/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void  createCustomer(HttpServletRequest request, HttpServletResponse response){
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerType, name, birthday, gender , idCard, phone, email, address);

        // validate
        Map<String, String> map = customerService.saveWithValidate(customer);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/customer/customerList.jsp");
        RequestDispatcher requestDispatcher1 =request.getRequestDispatcher("view/customer/create.jsp");
        if (map.isEmpty()){
            try {
            request.setAttribute("customerList",customerService.findAll());
            request.setAttribute("message", "New customer was successfully added");
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.setAttribute("emailMess",map.get("emailMess"));
                request.setAttribute("birthdayMess",map.get("birthdayMess"));
                request.setAttribute("phoneMess",map.get("phoneMess"));
                request.setAttribute("idCardMess",map.get("idCardMess"));
                request.setAttribute("oldCustomerData", customer);
                requestDispatcher1.forward(request, response);
            }catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        try {
//            requestDispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    // edit customer

    private  void  showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id =Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.setAttribute("typeList", customerTypeService.findAll());
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/customer/edit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerType, name, birthday, gender , idCard, phone, email, address);

        request.setAttribute("typeList", customerTypeService.findAll());
        boolean check= customerService.update( id,customer);
        if (check){
            request.setAttribute("message", " Customer was successfully updated");
        }else {
            request.setAttribute("message", "Update new customer failed. Try again");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
        request.setAttribute("customerList",customerService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // delete customer

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        if (customerService.delete(id)){
            request.setAttribute("message", "delete successfully");
        }else {
            request.setAttribute("message", "delete failed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
        request.setAttribute("customerList",customerService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id =Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/customer/delete.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // search
    private void search(HttpServletRequest request, HttpServletResponse response){
        List<Customer> customerList = new ArrayList<>();
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String type = request.getParameter("customerType");
        customerList = customerService.search(name, address, type);
        request.setAttribute("typeList", customerTypeService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/customerList.jsp");
        if (customerList.size()!=0){
            request.setAttribute("customerList", customerList);
        } else {
            request.setAttribute("message", "No result matched");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
