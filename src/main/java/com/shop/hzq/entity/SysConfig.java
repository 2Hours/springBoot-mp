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
 * 系统配置表
 * </p>
 *
 * @author hzq
 * @since 2018-12-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysConfig extends Model<SysConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 系统配置Id
     */
    @TableId(value = "sys_config_id", type = IdType.AUTO)
    private String sysConfigId;
    /**
     * 配置类型
     */
    private Integer configType;
    /**
     * 配置名
     */
    private String configName;
    /**
     * 配置范围
     */
    private String configScope;
    private LocalDateTime createTime;
    /**
     * 关联表Id
     */
    private String relationId;


    @Override
    protected Serializable pkVal() {
        return this.sysConfigId;
    }

}
