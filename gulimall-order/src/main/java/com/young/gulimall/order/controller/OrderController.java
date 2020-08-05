package com.young.gulimall.order.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.young.gulimall.order.entity.OrderEntity;
import com.young.gulimall.order.service.OrderService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 订单
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:40:14
 */
@RestController
@RequestMapping("order/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		OrderEntity order = orderService.getById(id);

        return ResponseResult.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody OrderEntity order){
		orderService.save(order);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody OrderEntity order){
		orderService.updateById(order);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		orderService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
