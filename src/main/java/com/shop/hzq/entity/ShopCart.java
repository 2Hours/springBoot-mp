package com.shop.hzq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商城购物车
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopCart extends Model<ShopCart> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "shop_cart_id", type = IdType.AUTO)
    private String shopCartId;
    /**
     * 门店id
     */
    private String shopId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 数量
     */
    private Integer num;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private Integer status;


    @Override
    protected Serializable pkVal() {
        return this.shopCartId;
    }

}
