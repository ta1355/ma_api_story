package ma_api_story.ma_api_story.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebclientConfig {

    private final APIKeyConfig apiKeyConfig;

    @Bean
    public WebClient nexonWebClient() {
        return WebClient.builder()
                .baseUrl("https://open.api.nexon.com/maplestory")
                .defaultHeader("accept", "application/json")
                .defaultHeader("x-nxopen-api-key", apiKeyConfig.getApiKey())
                .build();
    }
}
