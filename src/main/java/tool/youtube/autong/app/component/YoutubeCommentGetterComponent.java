package tool.youtube.autong.app.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tool.youtube.autong.app.service.GetYoutubeCommentService;

@Component
public class YoutubeCommentGetterComponent {

    private static final Logger log = LoggerFactory.getLogger(YoutubeCommentGetterComponent.class);

    @Autowired
    private Queue<String> sampleQueue;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private GetYoutubeCommentService commentService;
    
    @Scheduled(fixedDelay = 8000)
    public void printTime() {
        final String videoId = "RQH2UhyjWHo";
        commentService.addMessageToQueue(videoId);

        String now = dateFormat.format(new Date());

        log.info(now);
        sampleQueue.add(now);
    }

}
