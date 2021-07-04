package com.ccqstark.smallcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ccqstark.smallcloud.dao.CommodityMapper;
import com.ccqstark.smallcloud.model.Commodity;
import com.ccqstark.smallcloud.service.ICommodityService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ccqstark
 * @since 2021-05-26
 */
@Service
@DubboService
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

}
