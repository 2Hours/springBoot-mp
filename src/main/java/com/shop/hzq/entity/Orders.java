package com.shop.hzq.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orders extends Model<Orders> {

    private static final long serialVersionUID = 1L;
    public static final Integer normal = 1;
    public static final Integer cancel = 0;
    public static final Integer delete = -1;
    public static final Integer enable = -1;
    public static final Integer unpaid = 1;
    public static final Integer paid = 2;
    public static final Integer finished = 3;

    /**
     * 订单Id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private String orderId;
    /**
     * 商家Id
     */
    @NotNull
    private String shopId;
    /**
     * 用户ID
     */
    @NotNull
    private String userId;
    /**
     * 订单编号
     */
    private String sn;
    /**
     * 应付款
     */
    private BigDecimal originalPrice;
    /**
     * 实际付款
     */
    private BigDecimal actualPrice;
    /**
     * 订单状态有： -1.已失效，1.待付款，2.已付款，3.交易完成
     */
    private Integer orderStatus;
    /**
     * 是否已评价 0 否 1 是 
     */
    private Integer isEvaluate;
    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime payTime;
    /**
     * 支付类型： 1、微信扫码  2、支付宝扫码
     */
    private Integer payType;
    /**
     * 状态：-1、删除 1、正常
     */
    private Integer status;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 配送方式：1、到店自取  2、选择配送
     */
    private Integer acquireGoodsType;
    /**
     * 用户快递地址
     */
    private String userAddressId;
    /**
     * 支付状态 0成功 1 等待支付结果 2支付失败
     */
    private Integer payStatus;
    /**
     * 下单手机号
     */
    private String userMobile;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
