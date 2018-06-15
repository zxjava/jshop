package com.jshop.jshop.application;

import tk.mybatis.mapper.common.MySqlMapper;

public interface JshopMapper<T> extends tk.mybatis.mapper.common.Mapper<T>, MySqlMapper<T> {
}
