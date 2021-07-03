package com.ccqstark.smallcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ccqstark.smallcloud.dto.OrderToPayInfo;
import com.ccqstark.smallcloud.model.OrderInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    String confirmOrder(int receiverId, int userId);

    OrderToPayInfo getOrderInfo(String orderId);

    List<OrderToPayInfo> getOrderList(int userId);

}
