//package config;
//
//import Service.Service;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import repository.ArtistRepository;
//import repository.PerformanceRepository;
//import repository.SceneRepository;
//import repository.ScheduleDayRepository;
//import ui.SceneView;
//
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    ArtistRepository artistRepository() {
//        return new ArtistRepository();
//    }
//
//    @Bean
//    SceneRepository sceneRepository()
//    {
//        return new SceneRepository();
//    }
//
//    @Bean
//    ScheduleDayRepository scheduleDayRepository() {
//        return new ScheduleDayRepository();
//    }
//
//    @Bean
//    PerformanceRepository performanceRepository()
//    {
//        return new PerformanceRepository();
//    }
//
//    @Bean
//    Service service()
//    {
//        return new Service(artistRepository(),performanceRepository(),sceneRepository(),scheduleDayRepository());
//    }
//
//    @Bean
//    SceneView sceneView()
//    {
//        return new SceneView(service());
//    }
//}