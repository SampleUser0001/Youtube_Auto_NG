package tool.youtube.autong.app.conf;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tool.youtube.autong.app.model.comment.YoutubeCommentsModel;

@Configuration
public class MessageQueueConf {

    private Queue<YoutubeCommentsModel> messageQueue = new LinkedBlockingQueue<YoutubeCommentsModel>();

    @Bean
    public Queue<YoutubeCommentsModel> getMessageQueue() {
        return messageQueue;
    }
}
