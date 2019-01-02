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
 * 账户表
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    /**
     * 账户id
     */
    @TableId(value = "account_id", type = IdType.AUTO)
    private String accountId;
    /**
     * 账户使用者id
     */
    private String ownerId;
    /**
     * 账户类型  0-个人  1-商家
     */
    private Integer ownerType;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 状态：1 正常 2冻结 -1删除
     */
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;


    @Override
    protected Serializable pkVal() {
        return this.accountId;
    }

}
