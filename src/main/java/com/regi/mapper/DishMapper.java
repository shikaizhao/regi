package com.regi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.regi.entity.Category;
import com.regi.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}
