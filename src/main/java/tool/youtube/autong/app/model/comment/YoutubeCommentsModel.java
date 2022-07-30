package tool.youtube.autong.app.model.comment;

import java.util.List;

import lombok.Data;

@Data
public class YoutubeCommentsModel {
    private String kind;
    private String etag;
    private int poolingIntervalMillis;
    private YoutubeCommentPageInfoModel pageInfo;
    private String nextPageToken;
    private List<YoutubeCommentItemModel> items;
}
