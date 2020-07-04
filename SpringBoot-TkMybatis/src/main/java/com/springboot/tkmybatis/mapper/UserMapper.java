package com.springboot.tkmybatis.mapper;

import com.springboot.tkmybatis.domain.User;
import tk.mybatis.mapper.common.*;



public interface UserMapper extends Mapper<User>, MySqlMapper<User>, IdsMapper<User>, ConditionMapper<User> {

}
