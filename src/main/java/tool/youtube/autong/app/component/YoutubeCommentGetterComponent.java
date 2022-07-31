package tool.youtube.autong.app.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tool.youtube.autong.app.sample.model.zip.ZipResults;
import tool.youtube.autong.app.sample.service.ZipService;

@Component
public class YoutubeCommentGetterComponent {

    private static final Logger log = LoggerFactory.getLogger(YoutubeCommentGetterComponent.class);

    @Autowired
    private Queue<String> sampleQueue;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    @Scheduled(fixedDelay = 5000)
    public void printTime() {
        String now = dateFormat.format(new Date());

        log.info(now);
        sampleQueue.add(now);
    }

    @Autowired
    ZipService zipService;

    @Autowired
    Queue<ZipResults> zipQueue;

    @Scheduled(fixedDelay = 10000)
    public void putZipCode() {
        ZipResults results =zipService.getZipResults("2500011");
        zipQueue.add(results);
    }

}
