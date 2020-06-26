package nl.sogyo.weerwolven.api;

import nl.sogyo.weerwolven.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@ServerEndpoint("/play")
public class WeerwolvenGame {

    HashMap<String, String> playernameList = new HashMap<String, String>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
    }

    @OnMessage
    public void onMessage(String txt, Session session) throws IOException {
        System.out.println("Message received: " + txt);
        JSONObject jMessage = new JSONObject(txt);
        if (txt.contains(playername) { playernameList.put(session.getId(), jMessage.getString("playername")) };

        //if message contains gameStart: create an array from the arraylist of names and send it to the domain

        for (Session sess : session.getOpenSessions()) {
            if (sess.isOpen()) {
                sess.getBasicRemote().sendText(txt.toUpperCase());
            }
        }
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
    }

}
