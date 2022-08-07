package tool.youtube.autong.app.model.youtube.video;

import lombok.Data;

@Data
public class YoutubeVideoItem {
    private String kind;
    private String etag;
    private String id;
    private YoutubeLiveStreamingDetails liveStreamingDetails;
}
