package com.instio;

/**
 * Created by BennettIronYard on 10/28/15.
 */
public class Message {
    int id;
    int replyId;
    String username;
    String text;

    public Message(int id, int replyId, String username, String text) {
        this.id = id;
        this.replyId = replyId;
        this.username = username;
        this.text = text;
    }
 }

