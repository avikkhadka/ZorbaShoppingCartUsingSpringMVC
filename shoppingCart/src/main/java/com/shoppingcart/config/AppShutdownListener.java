package com.shoppingcart.config;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class AppShutdownListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Nothing needed on startup
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutting down web application... cleaning up JDBC resources.");


        AbandonedConnectionCleanupThread.checkedShutdown();
        System.out.println("MySQL abandoned cleanup thread stopped.");


        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("Deregistered JDBC driver: " + driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
