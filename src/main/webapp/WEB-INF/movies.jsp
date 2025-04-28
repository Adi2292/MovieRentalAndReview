<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/27/2025
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*, org.example.movierentalandreview.model.Movie, org.example.movierentalandreview.sort.BubbleSort" %>
<html>
<head><title>Movie List</title></head>
<body>
<h1>Movie List (Sorted by Rating)</h1>
<%
    BufferedReader reader = new BufferedReader(new FileReader(application.getRealPath("movies.txt")));
    String line;
    Movie[] movies = new Movie[10];
    int count = 0;

    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        movies[count++] = new Movie(parts[0], Double.parseDouble(parts[1]));
    }
    reader.close();

    BubbleSort.sortMoviesByRating(movies);

    for (int i = 0; i < count; i++) {
%>
<form action="watchMovie" method="post">
    <input type="hidden" name="title" value="<%= movies[i].getTitle() %>">
    <input type="hidden" name="rating" value="<%= movies[i].getRating() %>">
    <p><%= movies[i].getTitle() %> - Rating: <%= movies[i].getRating() %>
        <input type="submit" value="Watch"></p>
</form>
<%
    }
%>
</body>
</html>

