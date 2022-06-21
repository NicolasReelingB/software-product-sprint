package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet responsible for creating and storing messages.
@WebServlet("/new-message")
public class NewMessageServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String color = request.getParameter("favColor");
        String message = request.getParameter("message");
        long currentTime = System.currentTimeMillis();

        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Message");
        FullEntity messageEntity = Entity.newBuilder(keyFactory.newKey())
                .set("firstName", firstName)
                .set("lastName", lastName)
                .set("email", email)
                .set("color", color)
                .set("message", message)
                .set("currentTime", currentTime)
                .build();
        datastore.put(messageEntity);
        response.sendRedirect("https://nreeling-sps-summer22.uc.r.appspot.com/index.html");
    }
}