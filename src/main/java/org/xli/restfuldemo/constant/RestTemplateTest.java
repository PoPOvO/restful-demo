package org.xli.restfuldemo.constant;

import java.io.*;

/**
 * @author xli
 * @Description 测试RestTemplate
 * @Date 创建于 2019/2/1 13:27
 */
public class RestTemplateTest {
    public static void main(String[] args) throws IOException {
//        get调用
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity student1 = restTemplate.getForEntity("http://localhost:8080/students/06153001", ResponseResult.class);
//        System.out.println(student1);
//
//        ResponseResult student2 = restTemplate.getForObject("http://localhost:8080/students/06153001", ResponseResult.class);
//        System.out.println(student2);

//        put调用
//        RestTemplate restTemplate = new RestTemplate();
//        Student student = new Student();
//        student.setName("Dog");
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);
//        restTemplate.put("http://localhost:8080/students/06153001", httpEntity);

//        post调用
//        RestTemplate restTemplate = new RestTemplate();
//        Student student = new Student("06153000", "Pig", true, (byte)20, new Date(), new Date());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        HttpEntity<Student> httpEntity = new HttpEntity<>(student, httpHeaders);
//        ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8080/students", httpEntity, ResponseResult.class);
//        System.out.println(responseEntity);

//        delete调用
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.delete("http://localhost:8080/students/06153000");
    }
}
