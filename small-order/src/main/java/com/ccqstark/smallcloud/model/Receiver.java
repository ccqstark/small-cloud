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
@ApiModel(value = "Receiver对象", description = "")
public class Receiver implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收货者id")
    @TableId(type = IdType.AUTO)
    private Integer receiverId;

    @ApiModelProperty(value = "对应用户")
    private Integer userId;

    @ApiModelProperty(value = "收货人姓名")
    private String receiverName;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "详细地址")
    private String detail;

    @ApiModelProperty(value = "邮编")
    private String postcode;

    @Override
    public String toString() {
        return receiverName + " | " +
                phone + " | " +
                province + " | " +
                city + " | " +
                area + " | " +
                detail + " | " +
                postcode;
    }
}
