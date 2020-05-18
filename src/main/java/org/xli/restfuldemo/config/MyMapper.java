package org.xli.restfuldemo.config;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author xli
 * @Description
 * @Date 创建于 2019/2/11 11:55
 */
public interface MyMapper<T, PK> extends BaseMapper<T>, IdListMapper<T, PK> {
}
