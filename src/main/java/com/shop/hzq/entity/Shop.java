package com.shop.hzq.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商家
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shop extends Model<Shop> {

    private static final long serialVersionUID = 1L;

    /**
     * 商家Id
     */
    @TableId(value = "shop_id", type = IdType.AUTO)
    private String shopId;
    /**
     * 商家管理人的用户Id
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
     * 地址
     */
    private String address;
    /**
     * 商家名称
     */
    private String shopName;
    /**
     * 头像相对路径
     */
    private String portraitUrl;
    /**
     * 评价人数
     */
    private Integer evaluateCount;
    /**
     * 评分数量 5分
     */
    private Integer evaluateScore;
    /**
     * 浏览数量
     */
    private Integer seeCount;
    /**
     * 订单总额
     */
    private Double orderTotal;
    /**
     * 订单数量
     */
    private Integer orderCount;
    /**
     * 收藏数量
     */
    private Integer collectCount;
    /**
     * 商家介绍
     */
    private String content;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 营业开始时间
     */
    private LocalTime startTime;
    /**
     * 营业结束时间
     */
    private LocalTime endTime;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 商家营业状态：1、营业中   2、休息中
     */
    private Integer workStatus;
    /**
     * 审核状态：1、待审核  2、审核通过  3、审核不通过
     */
    private Integer examineStatus;
    /**
     * 是否禁用：1、是  2、否
     */
    private Integer enables;
    /**
     * 状态：-1、删除 1、正常 2、初始化商家
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
     * 法人姓名
     */
    private String corpName;
    /**
     * 法人身份证
     */
    private String corpIdentity;
    /**
     * 法人联系电话
     */
    private String corpMobile;
    /**
     * 企业性质：1、企业商户 2、个体工商户  3、个人商户
     */
    private Integer businessType;
    /**
     * 邮箱
     */
    private String email;
    /**
     * （法人）身份证有效期
     */

    @Override
    protected Serializable pkVal() {
        return this.shopId;
    }

}
