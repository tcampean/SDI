package config;
import Service.ClientService;
import TCPClient.TcpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ui.Console;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AppConfig {


    @Bean
    ExecutorService executorService() { ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());
        return executorService;
    }

    @Bean
    TcpClient tcpClient()
    {
        return new TcpClient(executorService());
    }

    @Bean
    ClientService clientService()
    {
        return new ClientService(executorService(),tcpClient());
    }

    @Bean
    Console console()
    {
        return new Console(clientService());
    }

}
