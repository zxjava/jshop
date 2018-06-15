package com.jshop.jshop.application;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface JshopMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
