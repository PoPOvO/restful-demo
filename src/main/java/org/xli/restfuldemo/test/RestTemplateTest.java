package org.xli.restfuldemo.test;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.xli.restfuldemo.config.ResponseResult;
import org.xli.restfuldemo.pojo.entity.RestDTO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author xieli
 * @Description
 * @Date 创建于 2020/2/28 16:43
 */
public class RestTemplateTest {
    public static void main(String[] args) {
        // 参数
        Integer id = 456;
        String name = "张三";
        List<RestDTO> restDTOList = new LinkedList<>();
        restDTOList.add(new RestDTO("描述1", "版本1"));
        restDTOList.add(new RestDTO("描述2", "版本2"));
        restDTOList.add(new RestDTO("描述3", "版本3"));
        Map<String, Object> map = new HashMap<>();
        map.put("age", 456);
        map.put("name", "张三");
        map.put("restDTOList", restDTOList);

        String url = "http://localhost:8080/api/hello/rest";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(map, headers);

        ResponseEntity<ResponseResult> res = restTemplate.postForEntity(
                url + "?id=" + id + "&name=" + name, requestEntity, ResponseResult.class);
        System.out.println(res);
    }
}
