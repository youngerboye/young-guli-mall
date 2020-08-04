package com.young.gulimall.product.service.impl;

import com.young.gulimall.gulimallcommon.utils.PageUtils;
import com.young.gulimall.gulimallcommon.utils.Query;
import com.young.gulimall.product.dao.AttrAttrgroupRelationDao;
import com.young.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.young.gulimall.product.service.AttrAttrgroupRelationService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("attrAttrgroupRelationService")
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationDao, AttrAttrgroupRelationEntity> implements AttrAttrgroupRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrAttrgroupRelationEntity> page = this.page(
                new Query<AttrAttrgroupRelationEntity>().getPage(params),
                new QueryWrapper<AttrAttrgroupRelationEntity>()
        );

        return new PageUtils(page);
    }

}