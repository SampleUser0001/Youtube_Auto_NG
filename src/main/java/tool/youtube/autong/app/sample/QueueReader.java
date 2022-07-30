package tool.youtube.autong.app.sample;

import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QueueReader {

    private static final Logger log = LoggerFactory.getLogger(QueueReader.class);

    @Autowired
    private Queue<String> sampleQueue;

    @Autowired
    private SimpMessagingTemplate simpMessageTemplate;

    @Scheduled(fixedDelay = 1)
    public void greeting() throws Exception {
        String message = sampleQueue.poll();
        if(message != null) {
            log.info(message);
            Greeting notice = new Greeting(message);
            simpMessageTemplate.convertAndSend("/topic/greetings", notice);        }

    }
}
