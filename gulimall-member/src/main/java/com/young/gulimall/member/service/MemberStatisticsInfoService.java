package com.young.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.common.utils.PageUtils;
import com.young.gulimall.member.entity.MemberStatisticsInfoEntity;

import java.util.Map;

/**
 * 会员统计信息
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:23:16
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

