package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns an array of strings. */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      // Add strings to arraylist
      String[] strings = {
        "This is the first string.", 
        "Lorem Ipsum Dolorem.",
        "I love cooking."
      };

      // Return json
      response.setContentType("application/json;");
      Gson gson = new Gson();
      String json = gson.toJson(strings);
      response.getWriter().println(json);
  }
}