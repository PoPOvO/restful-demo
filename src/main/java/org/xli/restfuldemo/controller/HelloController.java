package org.xli.restfuldemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xli.restfuldemo.config.ResponseResult;
import org.xli.restfuldemo.pojo.entity.RestBodyDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author xli
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping("")
    public ResponseEntity<ResponseResult> hello() {
        return new ResponseEntity<>(ResponseResult.success("Hello World!"), HttpStatus.OK);
    }

    @GetMapping("/jsonp")
    public String jsonpRequest(@RequestParam("callback") String callback, HttpServletRequest request) {
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + ":" + request.getParameter(name).toString());
        }

        return callback + "(" + "{\"msg\": \"Hello World\"}" + ")";
    }

    @PostMapping("/rest")
    public ResponseEntity<ResponseResult> restInvoke(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "name", required =  false) String name,
            @RequestBody RestBodyDTO restBodyDTO
            ) {
        System.out.println("SSSSSSSS");
        return new ResponseEntity<>(ResponseResult.success("OK"), HttpStatus.OK);
    }
}
