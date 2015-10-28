package com.instio;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import javax.jws.soap.SOAPBinding;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, User> users = new HashMap();
        AbstractList<Message> messages = new ArrayList();

        addTestUsers(users);
        addTestMessages(messages);

        Spark.get(
                "/",
                ((request, respones) -> {
                    ArrayList<Message> threads = new ArrayList();
                    for (Message message : messages) {
                        if (message.replyId == -1) {
                            threads.add(message);
                        }
                    }
                    HashMap m = new HashMap();
                    return new ModelAndView(m, "threads.html");
                }),
                new MustacheTemplateEngine()
        );
    }
    static void addTestUsers(HashMap<String, User> users) {
        users.put("Alice", new User());
        users.put("Bob", new User());
        users.put("Charlie", new User());
    }
    static void addTestMessages(AbstractList<Message> messages) {
        messages.add(new Message(0, -1, "Alice", "This is a thread!"));
        messages.add(new Message(1, -1, "Bob", "This is a thread!"));
        messages.add(new Message(2, -0, "Charlie", "Cool thread Alice.")); //charlie reply to alice
        messages.add(new Message(3, -2, "Alice", "thanks"));
    }
}
