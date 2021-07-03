package com.ccqstark.smallcloud.controller;

import com.ccqstark.smallcloud.common.CommonResult;
import com.ccqstark.smallcloud.common.ResultCode;
import com.ccqstark.smallcloud.dto.OrderToPayInfo;
import com.ccqstark.smallcloud.model.User;
import com.ccqstark.smallcloud.service.impl.OrderInfoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderInfoServiceImpl orderInfoService;

    @ApiOperation("订单确认")
    @PostMapping("/confirm/{receiverId}")
    @Transactional
    public CommonResult<Map<String, Object>> orderConfirm(@PathVariable("receiverId") int receiverId, HttpSession session) {

        // 未登录
        if (session.isNew() || session.getAttribute("user") == null) {
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }
        int userId = ((User) session.getAttribute("user")).getUserId();

        String orderId = orderInfoService.confirmOrder(receiverId, userId);
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", orderId);

        return CommonResult.success(map);
    }

    @ApiOperation("获得订单详情")
    @GetMapping("/info/{orderId}")
    public CommonResult<OrderToPayInfo> getOrderInfo(@PathVariable("orderId") String orderId) {
        return CommonResult.success(orderInfoService.getOrderInfo(orderId));
    }

    @ApiOperation("订单列表")
    @GetMapping("/list")
    public CommonResult<List<OrderToPayInfo>> getOrderList(HttpSession session){

        // 未登录
        if (session.isNew() || session.getAttribute("user") == null) {
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }
        int userId = ((User) session.getAttribute("user")).getUserId();

        return  CommonResult.success(orderInfoService.getOrderList(userId));
    }

}
