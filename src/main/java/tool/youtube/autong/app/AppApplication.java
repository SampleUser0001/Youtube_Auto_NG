package tool.youtube.autong.app;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AppApplication.class, args);
    }
}
