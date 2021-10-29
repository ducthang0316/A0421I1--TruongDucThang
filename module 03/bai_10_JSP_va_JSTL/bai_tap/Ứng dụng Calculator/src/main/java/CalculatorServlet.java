import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOp = Integer.parseInt(request.getParameter("firstOperator"));
        float secondOp = Integer.parseInt(request.getParameter("secondOperator"));
        String operator = request.getParameter("operator");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try{

            float results = 0;
            switch (operator){
                case "+":
                    results = firstOp + secondOp;
                    break;
                case "-":
                    results = firstOp - secondOp;
                    break;
                case "*":
                    results = firstOp * secondOp;
                    break;
                case "/":
                    if (secondOp == 0 ){
                        throw new RuntimeException("Can divide by 0");
                    } else {
                        results = firstOp / secondOp;
                    }
                    break;
                default:   throw new RuntimeException("Invalid operation");
            }
            writer.println(firstOp + " " + operator + " " + secondOp + " = " + results);
        }catch (Exception e){
            writer.println("Error: " + e.getMessage());
        }
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
