package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the  * and some desktop browsers.
 *
 */
@SpringBootApplication
@PWA(name = "auth-example", shortName = "auth-example")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);


//        String url = "jdbc:mysql://localhost:3307/ferienwohnungdb";
//        String user = "root";
//        String password = "";
        //ddddd
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//
//            System.out.println("Erfolgreich verbunden");
//
//            //ausgeben
//            // aufsteigend
//            String query = "SELECT * FROM fewo WHERE ort = \"Lübeck\"";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//
//
//            //überschriften
//            int columns = rs.getMetaData().getColumnCount();
//            for(int i = 1; i <= columns; i++){
//                System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));
//            }
//            System.out.println();
//            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
//
//            while (rs.next()){
//                for(int i = 1; i <= columns; i++){
//                    System.out.print(String.format("%-15s", rs.getString(i)));
//                }
//                System.out.println();
//
//            }
//            rs.close();
//            stmt.close();
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }


    }
}
