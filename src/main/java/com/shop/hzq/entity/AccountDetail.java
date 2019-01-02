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
 * 订单详情表
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AccountDetail extends Model<AccountDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 账户流水明细ID
     */
    @TableId(value = "account_detail_id", type = IdType.AUTO)
    private String accountDetailId;
    /**
     * 拥有者id
     */
    private String ownerId;
    /**
     * 拥有者类型：1、用户 2、商家
     */
    private String ownerType;
    /**
     * 账户ID
     */
    private String accountId;
    /**
     * 剩余多少
     */
    private BigDecimal balance;
    /**
     * 收入积分(当款项为支出时，收入为null)
     */
    private BigDecimal income;
    /**
     * 支出积分(当款项为收入时，支出为null)
     */
    private BigDecimal payment;
    /**
     * 描述：（您获得xxx规则的奖励，金额是xxx）
     */
    private String described;
    /**
     * 流水类型：1、退款   2、余额支付  3、微信支付  4、支付宝支付  5、提现  6、提现成功  7、提现失败
     */
    private Integer type;
    /**
     * 1、待发放  2、已发放
     */
    private Integer giveOutType;
    /**
     * 状态：-1、删除 1、正常
     */
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;


    @Override
    protected Serializable pkVal() {
        return this.accountDetailId;
    }

}
