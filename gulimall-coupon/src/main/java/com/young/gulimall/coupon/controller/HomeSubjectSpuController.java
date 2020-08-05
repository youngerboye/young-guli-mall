package com.young.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.young.common.utils.ResponseResult;

import com.young.gulimall.coupon.entity.HomeSubjectSpuEntity;
import com.young.gulimall.coupon.service.HomeSubjectSpuService;
import com.young.common.utils.PageUtils;


/**
 * 专题商品
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 14:03:18
 */
@RestController
@RequestMapping("coupon/homesubjectspu")
public class HomeSubjectSpuController {
    @Autowired
    private HomeSubjectSpuService homeSubjectSpuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = homeSubjectSpuService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		HomeSubjectSpuEntity homeSubjectSpu = homeSubjectSpuService.getById(id);

        return ResponseResult.ok().put("homeSubjectSpu", homeSubjectSpu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody HomeSubjectSpuEntity homeSubjectSpu){
		homeSubjectSpuService.save(homeSubjectSpu);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody HomeSubjectSpuEntity homeSubjectSpu){
		homeSubjectSpuService.updateById(homeSubjectSpu);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		homeSubjectSpuService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
