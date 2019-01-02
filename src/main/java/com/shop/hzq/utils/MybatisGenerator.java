package com.shop.hzq.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class MybatisGenerator {


        public static void main(String[] args) {
            //1. 全局配置
            GlobalConfig config = new GlobalConfig();
            config.setActiveRecord(true) // 是否支持AR模式
                    .setAuthor("hzq") // 作者
                    .setOutputDir(System.getProperty("user.dir")+"/src/main/java") // 生成路径
                    .setFileOverride(true)  // 文件覆盖
                    .setIdType(IdType.AUTO) // 主键策略
                    .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                    .setBaseResultMap(true)//生成基本的resultMap
                    .setBaseColumnList(true);//生成基本的SQL片段

            //2. 数据源配置
            DataSourceConfig dsConfig  = new DataSourceConfig();
            dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                    .setDriverName("com.mysql.cj.jdbc.Driver")
                    .setUrl("jdbc:mysql://localhost:3306/platform?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8")
                    .setUsername("root")
                    .setPassword("123456");

            //3. 策略配置globalConfiguration中
            StrategyConfig stConfig = new StrategyConfig();
            stConfig.setCapitalMode(true) //全局大写命名
                    .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                    .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                    .setRestControllerStyle(true)
                    .setInclude("sys_config")
                    .setEntityLombokModel(true);

            //4. 包名策略配置
            PackageConfig pkConfig = new PackageConfig();
            pkConfig.setParent("com.shop.hzq")
                    .setMapper("mapper")//dao
                    .setService("service")//servcie
                    .setServiceImpl("service.impl")
                    .setController("controller")//controller
                    .setEntity("entity");

            //自定义生成的Mapper.xml文件
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };
            List<FileOutConfig> focList = new ArrayList<>();
            focList.add(new FileOutConfig("/templates/mapper.xml.vm"){
                public String outputFile(TableInfo tableInfo) {
                    return System.getProperty("user.dir") + "/src/main/resources/mapper/"
                            + tableInfo.getEntityName() + "Mapper.xml";
                }
            });
            cfg.setFileOutConfigList(focList);

            //5. 整合配置
            AutoGenerator ag = new AutoGenerator();
            ag.setGlobalConfig(config)
                    .setDataSource(dsConfig)
                    .setStrategy(stConfig)
                    .setCfg(cfg)
                    .setTemplate(new TemplateConfig().setXml(null))
                    .setPackageInfo(pkConfig);

            //6. 执行
            ag.execute();
    }
 
}