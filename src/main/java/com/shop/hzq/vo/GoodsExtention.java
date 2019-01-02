package com.shop.hzq.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.shop.hzq.entity.Goods;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsExtention{

    private Goods goods;
    private String url;

}
