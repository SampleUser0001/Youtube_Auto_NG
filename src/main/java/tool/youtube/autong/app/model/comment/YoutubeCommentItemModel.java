package tool.youtube.autong.app.model.comment;

import lombok.Data;

@Data
public class YoutubeCommentItemModel {
    private String kind;
    private String etag;
    private String id;
    private YoutubeCommentSnippetModel snippet;
    private YoutubeCommentAuthorDetailsModel authorDetails;
}
