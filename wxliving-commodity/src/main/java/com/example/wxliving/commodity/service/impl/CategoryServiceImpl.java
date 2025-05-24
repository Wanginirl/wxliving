package com.example.wxliving.commodity.service.impl;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.wxliving.commodity.dao.CategoryDao;
import com.example.wxliving.commodity.entity.CategoryEntity;
import com.example.wxliving.commodity.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public List<CategoryEntity> listTree() {
        List<CategoryEntity> entities = baseMapper.selectList(null);

        List<CategoryEntity> categoryTree = entities.stream()
                .filter(categoryEntity -> categoryEntity.getParentId() == 0)
                .map(category -> {category.setChildrenCategories(getChildrenCategories(entities, category));
                    return category;
                })
                .sorted((category1, category2) -> (category1.getSort() == null ? 0 : category1.getSort()) - (category2.getSort() == null ? 0 : category2.getSort()))
                .collect(Collectors.toList());
        return categoryTree;
    }

    private List<CategoryEntity> getChildrenCategories(List<CategoryEntity> all, CategoryEntity root) {
        List<CategoryEntity> children = all.stream().filter(category -> category.getParentId().equals(root.getId()))
                .map(category -> {
                    category.setChildrenCategories(getChildrenCategories(all, category));
                    return category;
                }).sorted((category1, category2) -> (category1.getSort() == null ? 0 : category1.getSort()) - (category2.getSort() == null ? 0 : category2.getSort()))
                .collect(Collectors.toList());

        return children;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

}