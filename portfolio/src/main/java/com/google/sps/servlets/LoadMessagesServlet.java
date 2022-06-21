package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import data.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for listing tasks. */
@WebServlet("/load-messages")
public class LoadMessagesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("Message").setOrderBy(OrderBy.desc("currentTime"))
                .build();
        QueryResults<Entity> results = datastore.run(query);
        List<Message> messages = new ArrayList<>();
        while (results.hasNext()) {
            Entity entity = results.next();
            long id = entity.getKey().getId();
            String firstName = entity.getString("firstName");
            String lastName = entity.getString("lastName");
            String email = entity.getString("email");
            String message = entity.getString("message");
            String color = entity.getString("color");
            long timestamp = entity.getLong("currentTime");

            Message newMessage = new Message(id, firstName, lastName, email, color, message, timestamp);
            messages.add(newMessage);
        }

        Gson gson = new Gson();
        response.setContentType("application/json");
        response.getWriter().println(gson.toJson(messages));
    }
}