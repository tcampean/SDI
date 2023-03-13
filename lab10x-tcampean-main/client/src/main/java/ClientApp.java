import Service.ClientService;
import TCPClient.TcpClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.Console;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientApp {

    public static void main(String[] args) throws InterruptedException {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");
        Console console = context.getBean(Console.class);
        console.run();
        System.out.println("OUT");
    }
}
