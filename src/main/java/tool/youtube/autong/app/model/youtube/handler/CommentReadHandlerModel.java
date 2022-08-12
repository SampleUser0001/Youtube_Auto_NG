package tool.youtube.autong.app.model.youtube.handler;

import lombok.Data;

@Data
public class CommentReadHandlerModel {
    private long waitTime;
    private boolean isStreaming;
    private String videoId;
}
