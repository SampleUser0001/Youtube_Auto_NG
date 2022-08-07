package tool.youtube.autong.app.service.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class YoutubeApiProperties {
    @Value("${youtube.api.key}")
    private String apiKey;
}
