package tool.youtube.autong.app.sample.model.zip;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ZipInfo {
    private String address1;
    private String address2;
    private String address3;
    private String kana1;
    private String kana2;
    private String kana3;
    private String prefcode;
    private String zipcode;
}
