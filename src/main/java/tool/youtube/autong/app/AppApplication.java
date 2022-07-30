package tool.youtube.autong.app;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import tool.youtube.autong.app.enums.YoutubeApiEnum;

@SpringBootApplication
@EnableScheduling
public class AppApplication {

    public static void main(String[] args) throws IOException {
        YoutubeApiEnum.load(AppApplication.getResourcePath("properties/youtube_api.properties"));
        SpringApplication.run(AppApplication.class, args);
    }

    private static Path getResourcePath(String path) {
        return Paths.get(
                Thread.currentThread()
                      .getContextClassLoader()
                      .getResource(path) // resources下のファイルパスを指定する。
                      .getPath()
        );
    }

}
