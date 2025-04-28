package org.example.movierentalandreview.servlet;

import org.example.movierentalandreview.model.Movie;
import org.example.movierentalandreview.stack.MovieStack;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/recentlyWatched")
public class RecentlyWatchedServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        MovieStack stack = (MovieStack) session.getAttribute("movieStack");

        List<Movie> recentlyWatched;
        if (stack != null) {
            recentlyWatched = stack.getAllRecentlyWatched();
        } else {
            recentlyWatched = List.of(); // Empty list if no movies watched yet
        }

        request.setAttribute("recentlyWatched", recentlyWatched);
        RequestDispatcher dispatcher = request.getRequestDispatcher("recentlyWatched.jsp");
        dispatcher.forward(request, response);
    }
}
