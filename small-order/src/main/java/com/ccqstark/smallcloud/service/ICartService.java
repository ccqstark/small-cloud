package com.ccqstark.smallcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccqstark.smallcloud.dto.CartListUnit;
import com.ccqstark.smallcloud.model.Cart;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
public interface ICartService extends IService<Cart> {

    List<CartListUnit> getCartList(int userId);

    List<CartListUnit> getCartSelectedList(int userId);

}
