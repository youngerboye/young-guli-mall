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

import com.young.gulimall.member.entity.MemberCollectSubjectEntity;
import com.young.gulimall.member.service.MemberCollectSubjectService;
import com.young.common.utils.PageUtils;
import com.young.common.utils.ResponseResult;



/**
 * 会员收藏的专题活动
 *
 * @author young
 * @email shineyoung1991@gmail.com
 * @date 2020-08-05 15:23:17
 */
@RestController
@RequestMapping("member/membercollectsubject")
public class MemberCollectSubjectController {
    @Autowired
    private MemberCollectSubjectService memberCollectSubjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestParam Map<String, Object> params){
        PageUtils page = memberCollectSubjectService.queryPage(params);

        return ResponseResult.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public ResponseResult info(@PathVariable("id") Long id){
		MemberCollectSubjectEntity memberCollectSubject = memberCollectSubjectService.getById(id);

        return ResponseResult.ok().put("memberCollectSubject", memberCollectSubject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody MemberCollectSubjectEntity memberCollectSubject){
		memberCollectSubjectService.save(memberCollectSubject);

        return ResponseResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult update(@RequestBody MemberCollectSubjectEntity memberCollectSubject){
		memberCollectSubjectService.updateById(memberCollectSubject);

        return ResponseResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult delete(@RequestBody Long[] ids){
		memberCollectSubjectService.removeByIds(Arrays.asList(ids));

        return ResponseResult.ok();
    }

}
