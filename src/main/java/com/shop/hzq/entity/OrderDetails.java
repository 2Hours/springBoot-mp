package com.shop.hzq.entity;

import java.math.BigDecimal;

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
 * 订单详情
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetails extends Model<OrderDetails> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_details_id", type = IdType.AUTO)
    private String orderDetailsId;
    private String orderId;
    private String goodsId;
    /**
     * 商品封面图
     */
    private String path;
    /**
     * 商品名
     */
    private String name;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 门店价格
     */
    private BigDecimal shopPrice;
    /**
     * 总价格
     */
    private BigDecimal totalPrice;
    /**
     * 实际付款
     */
    private BigDecimal actualPrice;
    /**
     * 类型  1、商品  2、服务
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
        return this.orderDetailsId;
    }

}
