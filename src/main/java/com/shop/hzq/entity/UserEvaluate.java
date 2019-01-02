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
 * 用户评价表
 * </p>
 *
 * @author hzq
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserEvaluate extends Model<UserEvaluate> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户评价ID
     */
    @TableId(value = "user_evaluate_id", type = IdType.AUTO)
    private String userEvaluateId;
    /**
     * 业务Id
     */
    private String businessId;
    /**
     * 业务类型
     */
    private Integer businessType;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 评分数量 5分
     */
    private Integer evaluateNum;
    /**
     * 评价内容
     */
    private String evaluateContent;
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
        return this.userEvaluateId;
    }

}
