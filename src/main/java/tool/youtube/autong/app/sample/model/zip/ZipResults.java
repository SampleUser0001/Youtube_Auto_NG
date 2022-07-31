package tool.youtube.autong.app.sample.model.zip;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ZipResults {
    private List<ZipInfo> results;
}
