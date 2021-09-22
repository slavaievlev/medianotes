package medianotes.config;

import medianotes.service.WorldService;
import medianotes.service.impl.WorldServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCore {

    @Bean
    public WorldService worldService() {
        return new WorldServiceImpl();
    }
}
