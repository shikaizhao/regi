package com.regi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.regi.dto.DishDto;
import com.regi.entity.Category;
import com.regi.entity.Dish;

public interface DishService extends IService<Dish> {
    public void saveDishAndFlavor(DishDto dishDto);
    public DishDto getByIdWithFlavor(Long id);

    public void updateDishAndFlavor(DishDto dishDto);

//    void updateByIds(Dish dish,Long ids[]);
}
