package com.shop.hzq.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Collections extends Model<Collections> {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏表id
     */
    private String collectionId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商家id
     */
    private String shopId;
    /**
     * 类型：1、商品  2、商家
     */
    private Integer type;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
