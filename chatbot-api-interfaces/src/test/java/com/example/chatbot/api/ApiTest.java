package com.example.chatbot.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class ApiTest {

    @Test
    public void querry_unanswered_questions() throws IOException {
        CloseableHttpClient build = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        httpGet.addHeader("cookie","zsxq_access_token=8F2B0A8C-4FFB-D61C-19A7-E80687F9F277_B9DC670EF1B1DD84; abtest_env=product; zsxqsessionid=fae66958451780b194d30b0dcd189872; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross={\"distinct_id\":\"585215581844514\",\"first_id\":\"18709bb1bd9349-032f44563f11c4e-7a545470-1106178-18709bb1bdaa8e\",\"props\":{},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3MDliYjFiZDkzNDktMDMyZjQ0NTYzZjExYzRlLTdhNTQ1NDcwLTExMDYxNzgtMTg3MDliYjFiZGFhOGUiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODUyMTU1ODE4NDQ1MTQifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"585215581844514\"},\"$device_id\":\"18709bb1bd9349-032f44563f11c4e-7a545470-1106178-18709bb1bdaa8e\"}");

        httpGet.addHeader("Content-Type","application/json, text/plain, */*");

        CloseableHttpResponse response = build.execute(httpGet);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    /*
    * 回复
    * */
    @Test
    public void comment() throws IOException {
        CloseableHttpClient build = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/814251514842452/comments");

        post.addHeader("cookie","zsxq_access_token=8F2B0A8C-4FFB-D61C-19A7-E80687F9F277_B9DC670EF1B1DD84; abtest_env=product; zsxqsessionid=fae66958451780b194d30b0dcd189872; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross={\"distinct_id\":\"585215581844514\",\"first_id\":\"18709bb1bd9349-032f44563f11c4e-7a545470-1106178-18709bb1bdaa8e\",\"props\":{},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3MDliYjFiZDkzNDktMDMyZjQ0NTYzZjExYzRlLTdhNTQ1NDcwLTExMDYxNzgtMTg3MDliYjFiZGFhOGUiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI1ODUyMTU1ODE4NDQ1MTQifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"585215581844514\"},\"$device_id\":\"18709bb1bd9349-032f44563f11c4e-7a545470-1106178-18709bb1bdaa8e\"}");

        post.addHeader("Content-Type","application/json, text/plain, */*");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"[敲打]\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf-8"));

        post.setEntity(stringEntity);
        CloseableHttpResponse response = build.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            System.out.println(EntityUtils.toString(response.getEntity()));
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
