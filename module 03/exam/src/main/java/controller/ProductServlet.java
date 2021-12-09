package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action= "";
        }

        switch (action){
            case "add":
                createProduct(request, response);
                break;
            case "edit":

                break;
            case "delete":

                break;
            case "search":

                break;
            default:
                showProductList(request, response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color =request.getParameter("color");
        String description =request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));

        Product product = new Product(id, name, price, quantity, color, description, idCategory);
        boolean check= productService.save(product);
        if (check){
            request.setAttribute("mess", "Thêm mới thành công");
        }else {
            request.setAttribute("mess", "Thêm mới không thành công");
        }
        request.setAttribute("productList",productService.findAll());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("productList", productService.findAll());

        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("view/list.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
//                showEditForm(request,response);
                break;
            case "delete":
         deleteProduct(request, response);
                break;
            default:
                   showProductList(request, response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        if (productService.delete(id)){
            request.setAttribute("message", "delete successfully");
        }else {
            request.setAttribute("message", "delete failed");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list.jsp");
        request.setAttribute("productList",productService.findAll());
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        int id =Integer.parseInt(request.getParameter("id"));
//        Product customer = productService.findById(id);
//        request.setAttribute("customer", customer);
//        RequestDispatcher requestDispatcher =request.getRequestDispatcher("view/delete.jsp");
//        try {
//            requestDispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
