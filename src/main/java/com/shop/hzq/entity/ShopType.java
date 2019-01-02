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
 * 商店类型表
 * </p>
 *
 * @author hzq
 * @since 2018-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ShopType extends Model<ShopType> {

    private static final long serialVersionUID = 1L;

    /**
     * 商店类别Id
     */
    @TableId(value = "shop_type_id", type = IdType.AUTO)
    private String shopTypeId;
    /**
     * 门店Id
     */
    private String shopId;
    /**
     * 门店类型
     */
    private Integer shopType;
    private String shopTypeName;
    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.shopTypeId;
    }

}
