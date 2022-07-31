package tool.youtube.autong.app.sample.service;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tool.youtube.autong.app.sample.model.zip.ZipResults;

@Service
public class ZipService {
    private static final String URL = "http://zipcloud.ibsnet.co.jp/api/search?zipcode={zipcode}";

    @Autowired
    private RestTemplate restTemplate;

    public ZipResults getZipResults(String zipcode){
        Map<String, String> param = new HashMap<String, String>();
        param.put("zipcode",zipcode);
        
        // zipcodeは「Content-Type: text/plain;charset=utf-8」を返してくるが、デフォルトのままでは処理できない。
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(new MediaType(MediaType.TEXT_PLAIN, Charset.forName("utf-8"))));
        restTemplate.setMessageConverters(Arrays.asList(converter));

        return restTemplate.getForObject(URL, ZipResults.class, param);        
    }
}
