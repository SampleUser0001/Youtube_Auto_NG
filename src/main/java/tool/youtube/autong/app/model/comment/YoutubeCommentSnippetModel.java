package tool.youtube.autong.app.model.comment;

import lombok.Data;

@Data
public class YoutubeCommentSnippetModel {
    private String type;
    private String liveChatId;
    private String authorChannelId;
    private String publishedAt;
    private boolean hasDisplayContent;
    private String diplayMessage;
}
