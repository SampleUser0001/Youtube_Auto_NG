package tool.youtube.autong.app.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * youtube_api.propertiesを読み込む。
 */
@Configuration
@PropertySource(value = "classpath:properties/youtube_api.properties")
public class YoutubeApiConf {
    @Bean
    public static PropertySourcesPlaceholderConfigurer sampleProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
