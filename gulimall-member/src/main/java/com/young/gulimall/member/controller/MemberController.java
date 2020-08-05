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

import com.young.gulimall.member.entity.MemberEntity;
import com.young.gulimall.member.service.MemberService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 会员
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:23:16
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return ResponseResult.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody MemberEntity member){
		memberService.save(member);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
