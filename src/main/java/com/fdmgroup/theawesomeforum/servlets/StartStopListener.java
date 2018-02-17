package com.fdmgroup.theawesomeforum.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fdmgroup.theawesomeforum.utility.JPAConnectionManager;


@WebListener 
public class StartStopListener implements ServletContextListener {

	private JPAConnectionManager jPAConnectionManager; 
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		jPAConnectionManager = JPAConnectionManager.getJPAConnectionManager("theawesomeforum");

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		jPAConnectionManager.closeEntityManagerFactory();
	}
}

