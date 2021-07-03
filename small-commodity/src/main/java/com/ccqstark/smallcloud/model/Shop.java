package com.ccqstark.smallcloud.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Shop对象", description="")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "店铺id")
    @TableId(value = "shop_id", type = IdType.AUTO)
    private Integer shopId;

    @ApiModelProperty(value = "店主id")
    private Integer userId;

    @ApiModelProperty(value = "店铺名")
    private String shopName;


}
