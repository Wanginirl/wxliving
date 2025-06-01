package com.example.wxliving.commodity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.utils.PageUtils;
import com.example.wxliving.commodity.entity.BrandEntity;

import java.util.Map;

/**
 * 家居品牌
 *
 * @author wx
 * @email xinwanglaowang@gmail.com
 * @date 2025-05-31 16:10:12
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

