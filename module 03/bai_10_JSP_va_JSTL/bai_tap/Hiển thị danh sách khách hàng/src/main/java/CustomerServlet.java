import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/list"})
public class CustomerServlet extends HttpServlet {
    List<Customer> list = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        list.add(new Customer(1,"Mai Van Hoan", "1983-08-20", "Ha Noi"));
        list.add(new Customer(2,"Nguyen Van Nam", "1983-08-21", "Da Nang"));
        list.add(new Customer(3, "Nguyem Thai Hoa", "1983-08-22", "Hai Phong"));
        list.add(new Customer(4, "Tran Dang Khoa", "1983-08-23", "Nam Dinh"));
        list.add(new Customer(5, "Nguyen Dinh Thi", "1983-08-24", "Hai Duong"));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");

        requestDispatcher.forward(request,response);
    }
}
