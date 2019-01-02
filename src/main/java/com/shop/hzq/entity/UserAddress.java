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
 * 用户收货地址表
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAddress extends Model<UserAddress> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户收货ID
     */
    @TableId(value = "user_address_id", type = IdType.AUTO)
    private String userAddressId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 省份地区ID
     */
    private String provinceId;
    /**
     * 省份地区名称
     */
    private String provinceName;
    /**
     * 城市地区ID
     */
    private String cityId;
    /**
     * 城市地区名称
     */
    private String cityName;
    /**
     * 区县地区ID
     */
    private String areaId;
    /**
     * 区县地区名称
     */
    private String areaName;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 联系人手机
     */
    private String mobile;
    /**
     * 地址
     */
    private String address;
    /**
     * 是否默认 1、是  2、 否
     */
    private Integer isDefault;
    /**
     * 邮政编码
     */
    private String postalCode;
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
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;


    @Override
    protected Serializable pkVal() {
        return this.userAddressId;
    }

}
