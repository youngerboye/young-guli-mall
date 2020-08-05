package com.young.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.young.common.utils.ResponseResult;

import com.young.gulimall.member.entity.IntegrationChangeHistoryEntity;
import com.young.gulimall.member.service.IntegrationChangeHistoryService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 积分变化历史记录
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:23:16
 */
@RestController
@RequestMapping("member/integrationchangehistory")
public class IntegrationChangeHistoryController {
    @Autowired
    private IntegrationChangeHistoryService integrationChangeHistoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = integrationChangeHistoryService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		IntegrationChangeHistoryEntity integrationChangeHistory = integrationChangeHistoryService.getById(id);

        return ResponseResult.ok().put("integrationChangeHistory", integrationChangeHistory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory){
		integrationChangeHistoryService.save(integrationChangeHistory);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody IntegrationChangeHistoryEntity integrationChangeHistory){
		integrationChangeHistoryService.updateById(integrationChangeHistory);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		integrationChangeHistoryService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
