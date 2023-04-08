package com.regi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.regi.dto.SetmealDto;
import com.regi.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    void saveSetmealWithCategory(SetmealDto setmealDto);

    SetmealDto getByIdWithSetmealDish(Long id);

    void updateSetmealAndDish(SetmealDto setmealDto);

    void removeWithDish(List<Long> ids);
}
