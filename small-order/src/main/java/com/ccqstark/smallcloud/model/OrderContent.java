package com.ccqstark.smallcloud.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@ApiModel(value="OrderContent对象", description="")
public class OrderContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "购物车中的一种商品")
    private Integer cartId;

    @ApiModelProperty(value = "所属用户")
    private Integer userId;

}
