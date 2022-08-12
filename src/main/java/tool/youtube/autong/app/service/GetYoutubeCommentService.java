package tool.youtube.autong.app.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tool.youtube.autong.app.model.youtube.comment.YoutubeCommentsModel;
import tool.youtube.autong.app.model.youtube.video.YoutubeVideoInfo;
import tool.youtube.autong.app.service.properties.YoutubeApiProperties;

@Service
public class GetYoutubeCommentService {

    private static final Logger log = LoggerFactory.getLogger(GetYoutubeCommentService.class);

    private static final String LIVE_CHAT_MESSAGE = "https://www.googleapis.com/youtube/v3/liveChat/messages?key={key}&liveChatId={liveChatId}&part={part}";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private YoutubeApiProperties properties;

    @Autowired
    private Map<String, Map<String, String>> commentParamMap;

    @Autowired
    private GetYoutubeInfoService youtubeInfoService;

    public YoutubeCommentsModel getMessage(String videoId) {
        Map<String, String> commentParam = commentParamMap.computeIfAbsent(videoId, key -> {
            YoutubeVideoInfo videoInfo = youtubeInfoService.getYoutubeVideoInfo(videoId);

            Map<String, String> returnCommentParam = new HashMap<>();
            returnCommentParam.put("key", properties.getApiKey());
            returnCommentParam.put("liveChatId", videoInfo.getItems().get(0).getLiveStreamingDetails().getActiveLiveChatId());
            returnCommentParam.put("part", "id,snippet,authorDetails");

            return returnCommentParam;
        });

        YoutubeCommentsModel comments = restTemplate.getForObject(LIVE_CHAT_MESSAGE, YoutubeCommentsModel.class, commentParam);
        log.info(comments.toString());
        return comments;
    }
}
