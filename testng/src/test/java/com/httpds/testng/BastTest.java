package com.httpds.testng;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.bson.json.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BastTest {
    @Test
    public void test() {
        Assert.assertEquals(1, 1);
    }
    
    @Test
    public void autoTest() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8084/hello/get");
        // 准备请求参数和期望值(实际情况从数据库中获取)
        // 期望值
        Map<String, Object> expectMap = new HashMap<>();
        expectMap.put("status", 0);
        expectMap.put("result", "success");
        // 请求参数
        List<NameValuePair> kvList = new ArrayList<>();
        kvList.add(new BasicNameValuePair("id", "123"));
        StringEntity entity = new UrlEncodedFormEntity(kvList, "utf-8");

        // 设置参数
        post.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(post);
        String string = EntityUtils.toString(response.getEntity());
        
        Map<String, Object> map;
        map = JSONObject.parseObject(string, Map.class);
        System.out.println(map);
        Assert.assertEquals(map.get("status"), expectMap.get("status"));
        Assert.assertEquals(map.get("result"), expectMap.get("result"));
        response.close();
        httpClient.close();
    }
}
