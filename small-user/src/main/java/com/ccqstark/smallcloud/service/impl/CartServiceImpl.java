package com.ccqstark.smallcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccqstark.smallcloud.dao.CartMapper;
import com.ccqstark.smallcloud.dto.CartListUnit;
import com.ccqstark.smallcloud.model.Cart;
import com.ccqstark.smallcloud.service.ICartService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Service
@DubboService
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    @Autowired
    private CartMapper cartMapper;

    /**
     * 获取用户的购物车列表
     */
    @Override
    public List<CartListUnit> getCartList(int userId) {

        List<CartListUnit> unitList = cartMapper.getCartList(userId);
        // 计算小计
        for (CartListUnit cartListUnit : unitList) {
            cartListUnit.setLittleSum(cartListUnit.getPrice().multiply(BigDecimal.valueOf(cartListUnit.getBuyNumber())));
        }

        return unitList;
    }

    /**
     * 获取用户选中的购物车列表
     */
    @Override
    public List<CartListUnit> getCartSelectedList(int userId) {

        List<CartListUnit> unitList = cartMapper.getCartSelectedList(userId);
        // 计算小计
        for (CartListUnit cartListUnit : unitList) {
            cartListUnit.setLittleSum(cartListUnit.getPrice().multiply(BigDecimal.valueOf(cartListUnit.getBuyNumber())));
        }

        return unitList;
    }

}
