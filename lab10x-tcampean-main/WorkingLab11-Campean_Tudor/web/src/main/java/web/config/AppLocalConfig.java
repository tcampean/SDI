package web.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import core.config.JPAConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import({JPAConfig.class})
@ComponentScan({"web.config"})
@PropertySources({@PropertySource(value = "classpath:local/db.properties"),})
public class AppLocalConfig {
    /**
     * Enables placeholders usage with SpEL expressions.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Module jsonDeserializer() {
        // module.addDeserializer(String.class, new WhiteSpaceRemovalDeserializer());
        return new SimpleModule();
    }
}