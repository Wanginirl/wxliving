package com.example.wxliving.commodity.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.wxliving.commodity.entity.CategoryEntity;
import com.example.wxliving.commodity.service.CategoryService;
//import com.example.common.utils.PageUtils;
//import com.example.common.utils.R;



/**
 * 商品分类表
 *
 * @author wx
 * @email xinwanglaowang@gmail.com
 * @date 2025-05-08 08:35:21
 */
@RestController
@RequestMapping("commodity/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("commodity:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 树形列表
     */
    @RequestMapping("/list/tree")
    public R listTree() {
        // 查询所有分类
        return R.ok().put("data", categoryService.listTree());
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//    @RequiresPermissions("commodity:category:info")
    public R info(@PathVariable("id") Long id){
		CategoryEntity category = categoryService.getById(id);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
//    @RequiresPermissions("commodity:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
//    @RequiresPermissions("commodity:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("commodity:category:delete")
    public R delete(@RequestBody Long[] ids){
		categoryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
