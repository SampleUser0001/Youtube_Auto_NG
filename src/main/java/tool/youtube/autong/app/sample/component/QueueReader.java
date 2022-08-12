package tool.youtube.autong.app.sample.component;

import java.util.Map;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tool.youtube.autong.app.model.youtube.comment.YoutubeCommentItemModel;
import tool.youtube.autong.app.model.youtube.comment.YoutubeCommentsModel;
import tool.youtube.autong.app.sample.model.Greeting;
import tool.youtube.autong.app.sample.model.zip.ZipResults;

@Component
public class QueueReader {

    private static final Logger log = LoggerFactory.getLogger(QueueReader.class);

    private static final String DESTINATION = "/topic/greetings";

    @Autowired
    private Queue<String> sampleQueue;
    @Autowired
    private Queue<ZipResults> zipQueue;

    @Autowired
    private SimpMessagingTemplate simpMessageTemplate;

    @Scheduled(fixedDelay = 1)
    public void greeting() throws Exception {
        String message = sampleQueue.poll();
        if(message != null) {
            log.info(message);
            Greeting notice = new Greeting(message);
            simpMessageTemplate.convertAndSend(DESTINATION, notice);
        }
    }

    @Scheduled(fixedDelay = 1)
    public void sendZipResults() throws Exception {
        ZipResults zipResults = zipQueue.poll();
        if(zipResults != null) {
            log.info(zipResults.toString());
            simpMessageTemplate.convertAndSend(DESTINATION, new Greeting(zipResults.toString()));
        }
    }

    @Autowired
    private Queue<YoutubeCommentsModel> youtubeCommentQueue;
    @Autowired
    private Map<String, YoutubeCommentItemModel> youtubeCommentMap;
    @Scheduled(fixedDelay = 1)
    public void sendYoutubeComments() throws Exception {
        YoutubeCommentsModel comments = youtubeCommentQueue.poll();
        if(comments != null) {
            comments.getItems()
                    .stream()
                    .distinct()
                    .forEach(comment -> {
                        if(!youtubeCommentMap.containsKey(comment.getId())) {
                            youtubeCommentMap.put(comment.getId(), comment);
                            // TODO 他のModelを送信できるようにする
                            simpMessageTemplate.convertAndSend(DESTINATION, comment);
                        }
                    });
            
        }
    }

}
