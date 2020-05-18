package org.xli.restfuldemo.test;

import org.xli.restfuldemo.controller.OrderType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author xieli
 * @Description
 * @Date 创建于 2020/1/17 16:56
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(List.class.isAssignableFrom(ArrayList.class));
//        System.out.println(List.class.isInstance(new ArrayList<String>()));
        Optional<OrderType> orderType = Stream.of(OrderType.values())
                .filter(v -> v.getLabel().equals("专项"))
                .findAny();
    }
}
