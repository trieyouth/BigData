package com.zero.BI.servlet;
import java.util.HashSet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
	
    public void sessionCreated(HttpSessionEvent event) {
           HttpSession session = event.getSession();
           ServletContext application = session.getServletContext();
           HashSet sessions = (HashSet) application.getAttribute("username");
           if (sessions == null) {
                  sessions = new HashSet();
                  application.setAttribute("username", sessions);
           }
           sessions.add(session);
    }
    public void sessionDestroyed(HttpSessionEvent event) {
           HttpSession session = event.getSession();
           ServletContext application = session.getServletContext();
           HashSet sessions = (HashSet) application.getAttribute("username");
           sessions.remove(session);
    }
}