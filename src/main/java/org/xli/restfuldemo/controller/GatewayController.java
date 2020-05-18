package org.xli.restfuldemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xli.restfuldemo.config.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xieli
 * @Description
 * @Date 创建于 2020/2/19 23:04
 */
@RestController
//@RequestMapping(path = "/gateway")
@RequestMapping
public class GatewayController {
    /**
     * client => gateway
     *  => service =>
     * gateway => client
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseResult> get(HttpServletRequest httpServletRequest) {
        Enumeration<String> names = httpServletRequest.getHeaderNames();
        Map<String, String> headers = new HashMap<>();

        while (names.hasMoreElements()) {
            String name = names.nextElement();
            headers.put(name, httpServletRequest.getHeader(name));
        }
        Map<String, Object> res = new HashMap<>();
        res.put("Client请求首部", headers);
        res.put("Service响应主体", "这是一段最初的文字");
        return new ResponseEntity<>(ResponseResult.success(res), HttpStatus.OK);
    }
}
