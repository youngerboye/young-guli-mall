package com.young.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.young.common.utils.PageUtils;
import com.young.common.utils.Query;

import com.young.gulimall.product.dao.PmsCategoryDao;
import com.young.gulimall.product.entity.PmsCategoryEntity;
import com.young.gulimall.product.service.PmsCategoryService;


@Service("pmsCategoryService")
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryDao, PmsCategoryEntity> implements PmsCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsCategoryEntity> page = this.page(
                new Query<PmsCategoryEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<PmsCategoryEntity> listTree() {
        List<PmsCategoryEntity> entities = this.baseMapper.selectList(null);
        List<PmsCategoryEntity> parentList = entities.stream()
                .filter(e -> e.getParentCid() == 0)
                .map(e -> {
                    e.setChildren(getChild(e, entities));
                    return e;
                }).collect(Collectors.toList());
        return parentList;
    }

    @Override
    public void removeByTreeIds(List<Long> asList) {
        //todo 检查idList是否有需要检查的地方
        this.baseMapper.deleteBatchIds(asList);
    }

    private List<PmsCategoryEntity> getChild(PmsCategoryEntity root, List<PmsCategoryEntity> parentList) {
        List<PmsCategoryEntity> child = parentList.stream().filter(e ->
                e.getParentCid().equals(root.getCatId())).map(e -> {
            //找到子菜单
            e.setChildren(getChild(e, parentList));
            return e;
        }).collect(Collectors.toList());
        return child;
    }
}