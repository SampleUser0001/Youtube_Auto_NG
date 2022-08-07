package tool.youtube.autong.app.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tool.youtube.autong.app.model.youtube.video.YoutubeVideoInfo;
import tool.youtube.autong.app.service.properties.YoutubeApiProperties;

@Service
public class GetYoutubeInfoService {
    private static final String VIDEO_INFO_URL = "https://www.googleapis.com/youtube/v3/videos?key={key}&id={id}&part={part}";

    private static final Logger log = LoggerFactory.getLogger(GetYoutubeInfoService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private YoutubeApiProperties properties;

    @Autowired
    private Map<String, YoutubeVideoInfo> youtubeVideoInfoMap;

    public YoutubeVideoInfo getYoutubeVideoInfo(String videoId) {
        return youtubeVideoInfoMap.computeIfAbsent(videoId, key -> {
            Map<String, String> getChatIdParam = new HashMap<String, String>();
            getChatIdParam.put("key", properties.getApiKey());
            getChatIdParam.put("id", videoId);
            getChatIdParam.put("part","liveStreamingDetails");
            
            YoutubeVideoInfo videoInfo = restTemplate.getForObject(VIDEO_INFO_URL, YoutubeVideoInfo.class, getChatIdParam);
            log.info(videoInfo.toString());
            return videoInfo;
        });
    }

}
