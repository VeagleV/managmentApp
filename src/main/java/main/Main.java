package main;

import org.hibernate.Session;
import modules.DataBaseProcessor.DataBaseConnectionManager.DatabaseConnectionManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


@SpringBootApplication
public class Main {

    static Session session = DatabaseConnectionManager.getSessionFactory().openSession();


    public static void main(String[] args) {

//            ConsoleService menu = new ConsoleService();
//            menu.start();
//
//            session.close();
//            DatabaseConnectionManager.shutdown();

        SpringApplication.run(Main.class, args);


    }
}