package tool.youtube.autong.app.model.youtube.comment;

import lombok.Data;

@Data
public class YoutubeCommentAuthorDetailsModel {
    private String channelId;
    private String channelUrl;
    private String displayName;
    private String profileImageUrl;
    private boolean isVerified;
    private boolean isChatOwner;
    private boolean isChatSponsor;
    private boolean isChatModerator;
}
