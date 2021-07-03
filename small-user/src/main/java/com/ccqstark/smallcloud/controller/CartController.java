package com.ccqstark.smallcloud.controller;

import com.ccqstark.smallcloud.common.CommonResult;
import com.ccqstark.smallcloud.common.ResultCode;
import com.ccqstark.smallcloud.dto.CartListUnit;
import com.ccqstark.smallcloud.model.Cart;
import com.ccqstark.smallcloud.model.User;
import com.ccqstark.smallcloud.service.impl.CartServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @ApiOperation("添加购物车")
    @PostMapping("/add")
    public CommonResult<String> addCart(int codId, int selected, HttpSession session) {

        // 未登录
        if (session.isNew() || session.getAttribute("user") == null) {
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }

        int userId = ((User) session.getAttribute("user")).getUserId();
        cartService.save(new Cart(0, userId, codId, 1, selected, 0));

        return CommonResult.success();
    }

    @ApiOperation("获取购物车列表")
    @GetMapping("/list")
    public CommonResult<Map<String, Object>> getList(HttpSession session) {

        // 未登录
        if (session.isNew() || session.getAttribute("user") == null) {
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }

        int userId = ((User) session.getAttribute("user")).getUserId();
        List<CartListUnit> cartListUnitList = cartService.getCartList(userId);

        // 计算总价
        BigDecimal sum = new BigDecimal(0);
        for (CartListUnit cartListUnit : cartListUnitList) {
            sum = sum.add(cartListUnit.getLittleSum());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("list", cartListUnitList);
        map.put("sum", sum);

        return CommonResult.success(map);
    }

    @ApiOperation("修改购物车中数量和单选状态")
    @PutMapping("/status/{cartId}")
    public CommonResult<String> modifyCart(@PathVariable("cartId") int cartId, int quantity, int selected) {
        Cart cart = cartService.getById(cartId);
        cart.setBuyNumber(quantity);
        cart.setSelected(selected);
        cartService.updateById(cart);
        return CommonResult.success();
    }

    @ApiOperation("删除购物车中的商品")
    @DeleteMapping("/{cartId}")
    public CommonResult<String> deleteCart(@PathVariable("cartId") int cartId) {
        cartService.removeById(cartId);
        return CommonResult.success();
    }

    @ApiOperation("获取购物车列表")
    @GetMapping("/list_selected")
    public CommonResult<Map<String, Object>> getSelectedList(HttpSession session) {

        // 未登录
        if (session.isNew() || session.getAttribute("user") == null) {
            return CommonResult.failed(ResultCode.UNAUTHORIZED);
        }

        int userId = ((User) session.getAttribute("user")).getUserId();
        List<CartListUnit> cartListUnitList = cartService.getCartSelectedList(userId);

        // 计算总价
        BigDecimal sum = new BigDecimal(0);
        for (CartListUnit cartListUnit : cartListUnitList) {
            sum = sum.add(cartListUnit.getLittleSum());
        }

        Map<String, Object> map = new HashMap<>();
        map.put("list", cartListUnitList);
        map.put("sum", sum);

        return CommonResult.success(map);
    }

}
