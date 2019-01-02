package com.shop.hzq.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.hzq.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shop.hzq.vo.GoodsExtention;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    Map<String,Object> searchResult(String keyword);

    IPage<GoodsExtention> getIndexItemByType(Page page,Integer type);
}
