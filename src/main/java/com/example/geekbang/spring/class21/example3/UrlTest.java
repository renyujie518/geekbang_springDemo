package com.example.geekbang.spring.class21.example3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @program: geekbang_springDemo
 * @description:  小心多次 URL Encoder
 * @author: gao wei
 * @create: 2022-02-09 17:54
 */
public class UrlTest {
    public static void main(String[] args) {


        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/hi");
        builder.queryParam("para1", "开发测试 001");
        //错误  toUriString执行了 URL Encode   getForEntity把 URL 转化成 String又执行了Encode
        //String url = builder.toUriString();
        URI url = builder.encode().build().toUri();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity.getBody());
    }
}
