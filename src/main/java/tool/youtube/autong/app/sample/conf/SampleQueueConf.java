package tool.youtube.autong.app.sample.conf;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tool.youtube.autong.app.sample.model.zip.ZipResults;

@Configuration
public class SampleQueueConf {
    private Queue<String> sampleQueue = new LinkedBlockingQueue<String>();
    @Bean
    public Queue<String> getSampleQueue() {
        return sampleQueue;
    }
    
    private Queue<ZipResults> zipQueue = new LinkedBlockingQueue<ZipResults>();
    @Bean
    public Queue<ZipResults> getZipQueue() {
        return zipQueue;
    }
}
