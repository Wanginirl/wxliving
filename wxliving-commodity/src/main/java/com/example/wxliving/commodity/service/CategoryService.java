package com.example.wxliving.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.wxliving.commodity.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品分类表
 *
 * @author wx
 * @email xinwanglaowang@gmail.com
 * @date 2025-05-08 08:35:21
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

