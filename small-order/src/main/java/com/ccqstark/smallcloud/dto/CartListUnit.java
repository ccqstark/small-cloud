package com.ccqstark.smallcloud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartListUnit {

    @ApiModelProperty(value = "购物车id")
    private Integer cartId;

    @ApiModelProperty(value = "商品id")
    private Integer codId;

    @ApiModelProperty(value = "商品名称")
    private String codName;

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "购买数量")
    private int buyNumber;

    @ApiModelProperty(value = "小计")
    private BigDecimal littleSum;

    @ApiModelProperty(value = "是否已选择")
    private Integer selected;

}
