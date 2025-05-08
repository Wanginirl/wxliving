package com.example.wxliving.commodity.dao;

import com.example.wxliving.commodity.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品分类表
 * 
 * @author wx
 * @email xinwanglaowang@gmail.com
 * @date 2025-05-08 08:35:21
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
