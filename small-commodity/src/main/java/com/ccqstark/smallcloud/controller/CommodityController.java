package com.ccqstark.smallcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccqstark.smallcloud.common.CommonResult;
import com.ccqstark.smallcloud.model.Commodity;
import com.ccqstark.smallcloud.service.impl.CommodityServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cod")
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityService;

    @ApiOperation("首页展示商品")
    @GetMapping("/index")
    public CommonResult<List<Commodity>> getIndexCommodity(){
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("limit 14");
        return CommonResult.success(commodityService.list(queryWrapper));
    }

    @ApiOperation("新建商品")
    @PostMapping("/new")
    public CommonResult<String> postCommonResult(@RequestBody Commodity commodity){
        commodityService.save(commodity);
        return CommonResult.success();
    }

    @ApiOperation("获得一件商品的信息")
    @GetMapping("/one/{codId}")
    public CommonResult<Commodity> getOneCommodity(@PathVariable("codId") int codId){
        return CommonResult.success(commodityService.getById(codId));
    }

}
