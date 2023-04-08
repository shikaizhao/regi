package com.regi.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.regi.dto.DishDto;
import com.regi.entity.Category;
import com.regi.entity.Dish;
import com.regi.entity.DishFlavor;
import com.regi.mapper.CategoryMapper;
import com.regi.mapper.DishMapper;
import com.regi.service.CategoryService;
import com.regi.service.DishFlavorService;
import com.regi.service.DishService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;


    //新增菜品
    @Override
    @Transactional
    public void saveDishAndFlavor(DishDto dishDto) {
        this.save(dishDto);
        List<DishFlavor> flavors = dishDto.getFlavors();
        for (DishFlavor df : flavors) {
            df.setDishId(dishDto.getId());
        }
        dishFlavorService.saveBatch(flavors);
    }

    //查询菜品数据
    @Override
    public DishDto getByIdWithFlavor(Long id) {
        DishDto dishDto = new DishDto();
        Dish dish = this.getById(id);
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dish.getId());
        List<DishFlavor> dishFlavors = dishFlavorService.list(queryWrapper);
        BeanUtils.copyProperties(dish, dishDto);
        dishDto.setFlavors(dishFlavors);
        return dishDto;
    }

    //修改菜品数据
    @Override
    @Transactional
    public void updateDishAndFlavor(DishDto dishDto) {
        //更新dish表中数据
        this.updateById(dishDto);
        //删除当前口味表中数据
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId, dishDto.getId());
        dishFlavorService.remove(queryWrapper);
        //添加当前传过来的菜品口味数据
        List<DishFlavor> flavors = dishDto.getFlavors();
        for (DishFlavor df : flavors) {
            df.setDishId(dishDto.getId());
        }
        dishFlavorService.saveBatch(flavors);
    }

//    @Override
//    public void updateByIds(Dish dish, Long[] ids) {
//        LambdaQueryWrapper<Dish> lambdaQueryWrapper =new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.in(Dish::getId,ids);
//        this.updateById(dish);
//    }
}
