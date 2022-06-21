package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String color = request.getParameter("favColor");
    String message = request.getParameter("message");

    // Print the value so you can see it in the server logs.
    System.out.println("Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email + "\nFavorite color:" + color + "\nMessage left: " + message);

    // Write the value to the response so the user can see it.
    response.getWriter().println("Message sent!" + "\nName: " + firstName + "\n Last Name: " + lastName + "\n Email: " + email + "\nFavorite color:" + color + "\n Message left: " + message);
    response.sendRedirect("https://nreeling-sps-summer22.uc.r.appspot.com/contact.html");
    }
}
