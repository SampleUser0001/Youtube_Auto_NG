package tool.youtube.autong.app.model.youtube.video;

import java.util.Date;

import lombok.Data;

@Data
public class YoutubeLiveStreamingDetails {
    private Date actualStartTime;
    private String concurrentViews;
    private String activeLiveChatId;
}
