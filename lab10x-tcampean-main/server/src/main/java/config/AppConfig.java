package config;


import Service.ServerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.ArtistRepository;
import repository.PerformanceRepository;
import repository.SceneRepository;
import repository.ScheduleDayRepository;
import tcp.TCPServer;
import utils.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Configuration
public class AppConfig {

    @Bean
    ArtistRepository artistRepository() {
        return new ArtistRepository();
    }

    @Bean
    SceneRepository sceneRepository()
    {
        return new SceneRepository();
    }

    @Bean
    ScheduleDayRepository scheduleDayRepository() {
        return new ScheduleDayRepository();
    }

    @Bean
    PerformanceRepository performanceRepository()
    {
        return new PerformanceRepository();
    }

    @Bean
    ExecutorService executorService() { ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());
            return executorService;
    }

    @Bean
    TCPServer tcpServer() {
        return new TCPServer(executorService(), Service.PORT);
    }

    @Bean
    ServerService serverService()
    {
        return new ServerService(artistRepository(),performanceRepository(),sceneRepository(),scheduleDayRepository(),executorService());
    }


}