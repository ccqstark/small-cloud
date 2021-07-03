package com.ccqstark.smallcloud.model;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="OrderInfo对象", description="")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String orderId;

    @ApiModelProperty(value = "收货者id")
    private int receiverId;

    @ApiModelProperty(value = "支付手段")
    private String payMethod;

    @ApiModelProperty(value = "总付款金额")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "支付时间")
    private LocalDateTime payTime;

    @ApiModelProperty(value = "订单状态")
    private int status;


}
