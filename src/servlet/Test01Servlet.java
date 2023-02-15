package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("*.do")
public class Test01Servlet extends BaseServlet {


    public  void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("运行了add()");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
