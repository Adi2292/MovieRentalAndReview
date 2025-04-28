package org.example.movierentalandreview.servlet;



import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        BufferedReader reader = new BufferedReader(new FileReader(getServletContext().getRealPath("/users.txt")));
        String line;
        boolean validUser = false;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(username) && parts[1].equals(password)) {
                validUser = true;
                break;
            }
        }
        reader.close();

        if (validUser) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("dashboard.jsp");
        } else {
            response.getWriter().println("Invalid login. Please try again.");
        }
    }
}
