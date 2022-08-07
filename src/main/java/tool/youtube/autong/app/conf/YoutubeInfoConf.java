package tool.youtube.autong.app.conf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tool.youtube.autong.app.model.youtube.video.YoutubeVideoInfo;

@Configuration
public class YoutubeInfoConf {

    private static Map<String, YoutubeVideoInfo> youtubeVideoInfoMap = new HashMap<String, YoutubeVideoInfo>();
    @Bean
    public Map<String, YoutubeVideoInfo> getYoutubeVideoInfoMap() {
        return youtubeVideoInfoMap;
    }

    private static Map<String, Map<String, String>> commentParamMap = new HashMap<>();
    @Bean 
    public Map<String, Map<String,String>> getCommentParamMap() {
        return commentParamMap;
    }

}
