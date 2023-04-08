package com.regi.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.regi.entity.Setmeal;
import com.regi.entity.SetmealDish;
import com.regi.mapper.SetmealDishMapper;
import com.regi.mapper.SetmealMapper;
import com.regi.service.SetmealDishService;
import com.regi.service.SetmealService;
import org.springframework.stereotype.Service;

@Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
