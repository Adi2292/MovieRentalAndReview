<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/27/2025
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.movierentalandreview.stack.MovieStack, org.example.movierentalandreview.model.Movie" %>
<%@ page session="true" %>
<html>
<head>
    <title>Recently Watched Movies</title>
</head>
<body>
<h2>Recently Watched Movies</h2>
<%
    MovieStack stack = (MovieStack) session.getAttribute("movieStack");

    if (stack != null && !stack.getAllRecentlyWatched().isEmpty()) {
        for (Movie movie : stack.getAllRecentlyWatched()) {
            out.println("<p>" + movie.getTitle() + " - " + movie.getRating() + "</p>");
        }
    } else {
        out.println("<p>No movies watched recently!</p>");
    }
%>
</body>
</html>
