package com.zerent.webpra;

import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@SpringBootTest
class WebpraApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test(){
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://test-eidapi-cyberport.azure-api.net/authentication/api/v1/auth/getToken");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("clientID", "edae2e2529ff46228af1e4d18c8405d1");
            request.setHeader("signatureMethod", "HmacSHA256");
            request.setHeader("timestamp", "1557048906183");
            request.setHeader("nonce", "e893647dc4204eb9b7b8eddd527b687c");
            request.setHeader("signature", "5X42Y1B7MEd8Mm%2BonwjiQz9VCZkkrntADskXsYntavU%3D");
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "1dc1db74452b4ba6906c6679aff1000d");


            // Request body
            StringEntity reqEntity = new StringEntity("{body}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null)
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
