package tool.youtube.autong.app.model.youtube.video;

import java.util.List;

import lombok.Data;

@Data
public class YoutubeVideoInfo {
    private String kind;
    private String etag;
    private List<YoutubeVideoItem> items;
    private YoutubeVideoPageInfo pageInfo;
}
