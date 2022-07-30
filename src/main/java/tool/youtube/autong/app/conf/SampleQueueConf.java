package tool.youtube.autong.app.conf;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleQueueConf {
    private Queue<String> sampleQueue = new LinkedBlockingQueue<String>();

    @Bean
    public Queue<String> getSampleQueue() {
        return sampleQueue;
    }
    
}
