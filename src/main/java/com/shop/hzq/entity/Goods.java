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
 * 商品表
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods extends Model<Goods> {

    private static final long serialVersionUID = 1L;

    /**
     * 商品表id
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private String goodsId;
    /**
     * 门店id
     */
    private String shopId;
    /**
     * 商品编号
     */
    private String sn;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品描述
     */
    private String described;
    /**
     * 总销量
     */
    private Integer salesVolume;
    /**
     * 月销量
     */
    private Integer monthVolume;
    /**
     * 总库存
     */
    private Integer inventory;
    /**
     * 门店价格
     */
    private String shopPrice;
    /**
     * 浏览数量
     */
    private Integer seeCount;
    /**
     * 是否上架：1 是 -1否
     */
    private Integer onSale;
    /**
     * 是否虚拟商品 1、是  -1、否
     */
    private Integer isReal;
    /**
     * 状态 1.正常  -1、删除
     */
    private Integer status;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;
    /**
     * 分类id
     */
    private Integer classId;


    @Override
    protected Serializable pkVal() {
        return this.goodsId;
    }

}
