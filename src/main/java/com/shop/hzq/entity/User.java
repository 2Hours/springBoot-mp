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
 * 用户表
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private String userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 头像相对路径
     */
    private String portraitUrl;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 性别：1、男 2、女 
     */
    private Integer sex;
    /**
     * 消费金额总和
     */
    private BigDecimal money;
    /**
     * 用户类型：1、会员 2、平台  3、商家
     */
    private String userType;
    /**
     * 注册时间
     */
    private LocalDateTime registerTime;
    /**
     * 是否禁用：1、是  2、否
     */
    private Integer enables;
    /**
     * 状态：-1、删除 1、正常
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


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
