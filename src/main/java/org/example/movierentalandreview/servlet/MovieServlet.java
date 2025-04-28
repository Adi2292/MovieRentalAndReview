package org.example.movierentalandreview.servlet;


import org.example.movierentalandreview.model.Movie;
import org.example.movierentalandreview.stack.MovieStack;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/watchMovie")
public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        double rating = Double.parseDouble(request.getParameter("rating"));

        Movie movie = new Movie(title, rating);

        HttpSession session = request.getSession();
        MovieStack stack = (MovieStack) session.getAttribute("movieStack");

        if (stack == null) {
            stack = new MovieStack();
            session.setAttribute("movieStack", stack);
        }

        stack.watchMovie(movie);

        response.sendRedirect("recentlyWatched.jsp");
    }
}
