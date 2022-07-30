package tool.youtube.autong.app.enums;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public enum YoutubeApiEnum {
    YOUTUBE_API_KEY("youtube.api.key");

    private static Properties properties;
    private String key;
    private YoutubeApiEnum(String key){
        this.key = key;
    }

    public static void load(Path propertiesPath) throws IOException {
        properties = new Properties();
        properties.load(
            Files.newBufferedReader(propertiesPath, StandardCharsets.UTF_8)
        );
    }
    
    public String getValue() {
        return properties.getProperty(this.key);
    }
        
}
