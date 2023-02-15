package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        int lastIndexOf = uri.lastIndexOf("/");
        if (uri.endsWith(".do")) {
            String methodName = uri.substring(lastIndexOf + 1, uri.lastIndexOf(".do"));
            System.out.println(methodName);
            Class<? extends BaseServlet> aClass = this.getClass();

            try {
                Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                method.invoke(this, req, resp);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            req.getRequestDispatcher(uri).forward(req, resp);
        }


    }
}
