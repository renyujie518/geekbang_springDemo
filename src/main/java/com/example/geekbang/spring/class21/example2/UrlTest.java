package com.example.geekbang.spring.class21.example2;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @program: geekbang_springDemo
 * @description:   当 URL 中含有特殊字符  一定要注意 URL 的组装方式
 * @author: gao wei
 * @create: 2022-02-09 17:54
 */
public class UrlTest {
    public static void main(String[] args) {

        String url = "http://localhost:8080/hi?para1=1#2";
        /*
         *错误 服务器并不认为 #2 是 para1 的内容
         * 原因 url定义中   # 开始，字符串，用于指定网络资源中的片断
         */

        //       HttpEntity<?> entity = new HttpEntity<>(null);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = builder.build().encode().toUri();
        HttpEntity entity = new HttpEntity<>(null);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
    }
}
