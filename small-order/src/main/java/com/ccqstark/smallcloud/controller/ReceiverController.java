package com.ccqstark.smallcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ccqstark.smallcloud.common.CommonResult;
import com.ccqstark.smallcloud.common.ResultCode;
import com.ccqstark.smallcloud.model.Receiver;
import com.ccqstark.smallcloud.model.User;
import com.ccqstark.smallcloud.service.impl.ReceiverServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/receiver")
public class ReceiverController {

    @Autowired
    private ReceiverServiceImpl receiverService;

    @ApiOperation("列出所有收货地址")
    @GetMapping("/list")
    public CommonResult<List<Receiver>> listReceiver(HttpSession session) {
        // 未登录
        if (session.isNew() || session.getAttribute("user") == null) {
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }
        int userId = ((User) session.getAttribute("user")).getUserId();
        QueryWrapper<Receiver> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);

        return CommonResult.success(receiverService.list(queryWrapper));
    }

    @ApiOperation("新增收货地址")
    @PostMapping("/add")
    public CommonResult<String> addReceiver(@RequestBody Receiver receiver, HttpSession session) {

        // 未登录
        if (session.isNew() || session.getAttribute("user") == null) {
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }
        int userId = ((User) session.getAttribute("user")).getUserId();

        receiver.setUserId(userId);
        receiverService.save(receiver);

        return CommonResult.success();
    }

    @ApiOperation("修改收货地址")
    @PutMapping("/{receiverId}")
    public CommonResult<String> modifyReceiver(@PathVariable("receiverId") int receiverId, @RequestBody Receiver receiver) {
        receiver.setReceiverId(receiverId);
        receiverService.updateById(receiver);
        return CommonResult.success();
    }

    @ApiOperation("删除收货地址")
    @DeleteMapping("/{receiverId}")
    public CommonResult<String> deleteReceiver(@PathVariable("receiverId") int receiverId) {
        receiverService.removeById(receiverId);
        return CommonResult.success();
    }


}
