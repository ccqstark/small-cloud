package com.ccqstark.smallcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ccqstark.smallcloud.dto.CartListUnit;
import com.ccqstark.smallcloud.model.Cart;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Repository
public interface CartMapper extends BaseMapper<Cart> {

    List<CartListUnit> getCartList(@Param("user_id") int userId);

    List<CartListUnit> getCartSelectedList(@Param("user_id") int userId);

}
