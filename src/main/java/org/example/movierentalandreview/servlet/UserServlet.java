package org.example.movierentalandreview.servlet;


import org.example.movierentalandreview.model.User;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        // Save to file
        FileWriter fw = new FileWriter(getServletContext().getRealPath("/users.txt"), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(username + "," + password + "," + email);
        bw.newLine();
        bw.close();

        response.sendRedirect("login.jsp");
    }
}

