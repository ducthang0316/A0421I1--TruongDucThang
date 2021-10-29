import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        Double price = Double.parseDouble(request.getParameter("price"));
        Double discount = Double.parseDouble(request.getParameter("percent"));

        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount ;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h2> Product name: " + product + "</h2>");
        writer.println("<h2> Original price: " + price + "</h2>");
        writer.println("<h2> Discount Amount: " + discountAmount + "</h2>");
        writer.println("<h2> Discount Price: " + discountPrice + "</h2>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
