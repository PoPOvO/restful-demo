package org.xli.restfuldemo.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/1/29 10:14
 */
public class StudentControllerTest extends MockMvcTest {
    private static String urlRoot = "/students";

    @Test
    public void testGetStudent() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get(urlRoot + "/06153001"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("{\n" +
                            "    \"code\": 1,\n" +
                            "    \"message\": \"成功\",\n" +
                            "    \"data\": {\n" +
                            "        \"id\": \"06153001\",\n" +
                            "        \"name\": \"Bob\",\n" +
                            "        \"sex\": rue,\n" +
                            "        \"age\": 18,\n" +
                            "        \"createTime\": 1548409635000,\n" +
                            "        \"updateTime\": 1548409638000\n" +
                            "    }\n" +
                            "}"));
    }

    @Test
    public void testAddStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(urlRoot)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"age\": \"25\",\n" +
                        "  \"createTime\": \"2019-01-30T09:54:53.177Z\",\n" +
                        "  \"id\": \"06153006\",\n" +
                        "  \"name\": \"Xli\",\n" +
                        "  \"sex\": true,\n" +
                        "  \"updateTime\": \"2019-01-30T09:54:53.177Z\"\n" +
                        "}"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().json("{\n" +
                            "    \"code\": 1,\n" +
                            "    \"message\": \"成功\",\n" +
                            "    \"data\": \"\"\n" +
                            "}"));

    }

    @Test
    public void testUpdateStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(urlRoot + "/06153006")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"age\": \"25\",\n" +
                        "  \"createTime\": \"2019-01-30T09:54:53.177Z\",\n" +
                        "  \"id\": \"06153006\",\n" +
                        "  \"name\": \"BBKD\",\n" +
                        "  \"sex\": true,\n" +
                        "  \"updateTime\": \"2019-01-30T09:54:53.177Z\"\n" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "    \"code\": 1,\n" +
                        "    \"message\": \"成功\",\n" +
                        "    \"data\": \"\"\n" +
                        "}"));

    }

    @Test
    public void testDeleteStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(urlRoot + "/06153006"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "    \"code\": 1,\n" +
                        "    \"message\": \"成功\",\n" +
                        "    \"data\": \"\"\n" +
                        "}"));

    }

    @Test
    public void testGetStudentNotExist() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get(urlRoot + "/06153001"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "  \"code\": 0,\n" +
                        "  \"message\": \"失败\",\n" +
                        "  \"data\": {\n" +
                        "    \"errorCode\": 1000,\n" +
                        "    \"errorMsg\": \"资源不存在\"\n" +
                        "  }\n" +
                        "}"));
    }

    @Test
    public void testAddStudentAlreadyExist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(urlRoot)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"age\": \"25\",\n" +
                        "  \"createTime\": \"2019-01-30T09:54:53.177Z\",\n" +
                        "  \"id\": \"06153001\",\n" +
                        "  \"name\": \"Xli\",\n" +
                        "  \"sex\": true,\n" +
                        "  \"updateTime\": \"2019-01-30T09:54:53.177Z\"\n" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "  \"code\": 0,\n" +
                        "  \"message\": \"失败\",\n" +
                        "  \"data\": {\n" +
                        "    \"errorCode\": 1001,\n" +
                        "    \"errorMsg\": \"资源已经存在\"\n" +
                        "  }\n" +
                        "}"));

    }

    @Test
    public void testUpdateStudentNotExist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(urlRoot + "/06153006")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"age\": \"25\",\n" +
                        "  \"createTime\": \"2019-01-30T09:54:53.177Z\",\n" +
                        "  \"id\": \"06153009\",\n" +
                        "  \"name\": \"BBKD\",\n" +
                        "  \"sex\": true,\n" +
                        "  \"updateTime\": \"2019-01-30T09:54:53.177Z\"\n" +
                        "}"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "  \"code\": 0,\n" +
                        "  \"message\": \"失败\",\n" +
                        "  \"data\": {\n" +
                        "    \"errorCode\": 1000,\n" +
                        "    \"errorMsg\": \"资源不存在\"\n" +
                        "  }\n" +
                        "}"));

    }

    @Test
    public void testDeleteStudentNotExist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(urlRoot + "/06153008"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "  \"code\": 0,\n" +
                        "  \"message\": \"失败\",\n" +
                        "  \"data\": {\n" +
                        "    \"errorCode\": 1000,\n" +
                        "    \"errorMsg\": \"资源不存在\"\n" +
                        "  }\n" +
                        "}}"));

    }
}
