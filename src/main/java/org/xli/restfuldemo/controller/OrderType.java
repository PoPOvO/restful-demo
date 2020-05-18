package org.xli.restfuldemo.controller;

/**
 * @author xieli
 * @Description
 * @Date 创建于 2020/2/25 17:47
 */
public enum OrderType {
    FIRST_SAMPLE("首样", 1),
    SPECIAL("专项", 2);

    private String label;
    private Integer value;

    OrderType(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public Integer getValue() {
        return value;
    }
}
