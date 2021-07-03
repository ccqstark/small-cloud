package com.ccqstark.smallcloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Coupon对象", description="")
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "券id")
    @TableId(value = "coupon_id", type = IdType.AUTO)
    private Integer couponId;

    @ApiModelProperty(value = "优惠券名称")
    private String couponName;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "额度")
    private String value;

    @ApiModelProperty(value = "过期时间")
    private LocalDateTime expirTime;


}
