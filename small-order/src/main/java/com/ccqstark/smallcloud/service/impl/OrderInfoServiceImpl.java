package com.ccqstark.smallcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccqstark.smallcloud.dao.CartMapper;
import com.ccqstark.smallcloud.dao.OrderInfoMapper;
import com.ccqstark.smallcloud.dao.ReceiverMapper;
import com.ccqstark.smallcloud.dto.OrderToPayInfo;
import com.ccqstark.smallcloud.model.*;
import com.ccqstark.smallcloud.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderContentServiceImpl orderContentService;
    @Autowired
    private ReceiverMapper receiverMapper;
    @Autowired
    private CommodityServiceImpl commodityService;
    @Autowired
    private CartServiceImpl cartService;

    /**
     * 订单确认
     */
    @Override
    public String confirmOrder(int receiverId, int userId) {

        // 生存订单号uuid
        String orderId = IdUtil.simpleUUID();

        // 新建一个order
        orderInfoMapper.insert(new OrderInfo(orderId, receiverId, "-", BigDecimal.valueOf(0), null, 0));

        // 把当前的购物车选中的商品加入订单关系表
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<Cart>()
                .eq("user_id", userId)
                .eq("selected", 1)
                .eq("to_order", 0);
        List<Cart> cartList = cartMapper.selectList(queryWrapper);

        List<OrderContent> orderContentList = new ArrayList<>();
        for (Cart cart : cartList) {
            orderContentList.add(new OrderContent(orderId, cart.getCartId(), userId));
        }

        orderContentService.saveBatch(orderContentList);

        // 更新to_order
        UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<Cart>()
                .set("to_order", 1)
                .eq("selected", 1)
                .eq("to_order", 0);
        cartMapper.update(null, updateWrapper);

        return orderId;
    }

    /**
     * 获取订单详情
     */
    @Override
    public OrderToPayInfo getOrderInfo(String orderId){

        OrderToPayInfo orderToPayInfo = new OrderToPayInfo();
        orderToPayInfo.setOrderId(orderId);

        // 收货信息
        OrderInfo orderInfo = getById(orderId);
        int receiverId = orderInfo.getReceiverId();
        Receiver receiver = receiverMapper.selectById(receiverId);
        orderToPayInfo.setAddress(receiver.toString());

        // 商品信息
        List<OrderContent> orderContentList = orderContentService.getBaseMapper().selectList(new QueryWrapper<OrderContent>().eq("order_id", orderId));
        List<Integer> cartIdList = orderContentList.stream()
                .map(OrderContent::getCartId).distinct()
                .collect(Collectors.toList());

        // 获取codId
        List<Cart> cartList = cartService.listByIds(cartIdList);
        List<Integer> codIdList = cartList.stream()
                .map(Cart::getCodId).distinct()
                .collect(Collectors.toList());
        // 获取商品信息
        List<Commodity> commodityList = commodityService.listByIds(codIdList);
        orderToPayInfo.setCommodityList(commodityList);

        return orderToPayInfo;
    }

    /**
     * 获得订单列表
     */
    @Override
    public List<OrderToPayInfo> getOrderList(int userId){

        List<OrderContent> orderContentList = orderContentService.list(new QueryWrapper<OrderContent>().eq("user_id",userId));
        // 获取orderId
        List<String> orderIdList = orderContentList.stream()
                .map(OrderContent::getOrderId).distinct()
                .collect(Collectors.toList());

        List<OrderToPayInfo> orderToPayInfoList = new ArrayList<>();
        for (String orderId : orderIdList){
            orderToPayInfoList.add(this.getOrderInfo(orderId));
        }

        return orderToPayInfoList;
    }


}
