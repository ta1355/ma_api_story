package ma_api_story.ma_api_story.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class APIKeyConfig {

    private final String apiKey;

    public APIKeyConfig(String apiKey) {
        this.apiKey = apiKey;
    }

    public APIKeyConfig() {
        this.apiKey = Dotenv.load().get("NEXON_API_KEY");
    }

}
