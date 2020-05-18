package org.xli.restfuldemo.pojo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author xieli
 * @Description
 * @Date 创建于 2020/3/8 23:50
 */
@Data
public class RestBodyDTO {
    private String name;

    private int age;

    private List<RestDTO> restDTOList;
}
