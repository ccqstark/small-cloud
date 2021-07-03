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
@ApiModel(value="Evaluate对象", description="")
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评价id")
    @TableId(value = "evaluate_id", type = IdType.AUTO)
    private Integer evaluateId;

    @ApiModelProperty(value = "对应商品")
    private Integer codId;

    @ApiModelProperty(value = "评价用户")
    private Integer userId;

    @ApiModelProperty(value = "评价内容")
    private String content;

    @ApiModelProperty(value = "评价时间")
    private LocalDateTime time;


}
