package client;

import client.ui.Console;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("client.config");
        Console ui = context.getBean(Console.class);
        ui.run();
        System.out.println("bye bye.");
    }
}
