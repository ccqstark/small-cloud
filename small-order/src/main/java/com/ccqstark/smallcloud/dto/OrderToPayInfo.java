package com.ccqstark.smallcloud.dto;

import com.ccqstark.smallcloud.model.Commodity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderToPayInfo {

    @ApiModelProperty("订单号")
    private String orderId;

    @ApiModelProperty("收货信息")
    private String address;

    @ApiModelProperty("商品信息")
    private List<Commodity> commodityList;

}
