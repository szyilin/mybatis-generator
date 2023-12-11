package cn.szyilin.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generator {
    public static void main(String[] args) {
        // 数据库配置
        String url = "jdbc:mysql://localhost:3306/classroom?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"; // 注意修改数据库名
        String username = "root";
        String password = "123456";

        // 要生成的表，all 代表所有表，指定多个表使用 "," 分割
        String listTable = "all";

        // 基本信息
        String author = "szyilin"; // 作者
        String parent = "cn.szyilin"; // 父包名

        FastAutoGenerator.create(url, username, password)
                // 全局配置
                .globalConfig((scanner, builder) -> builder
                        .author(author) // 作者名
                        .outputDir(System.getProperty("user.dir") + "/src/main/java") // 内容输出路径
                        .commentDate("yyyy-MM-dd hh:mm:ss") // 注释日期
                        .dateType(DateType.TIME_PACK) // 定义实体类中日期类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
                        .enableSwagger() // 开启 swagger 模式
                        .disableOpenDir() // 生成结束后禁止打开，输出目录（默认打开）
                        .fileOverride() // 覆盖之前文件
                )

                // 包配置
                .packageConfig((scanner, builder) -> builder
                        .parent(parent) // 父包名
                        .entity("entity")   // pojo 实体类包名
                        .service("service") // Service 包名
                        .serviceImpl("service.impl") // ***ServiceImpl 包名
                        .mapper("mapper")   // Mapper 包名
                        .xml("mapper.xml")  // Mapper XML 包名
                        .controller("controller") // Controller 包名
                        //配置 mapper.xml 路径信息：项目的 resources 目录下
                        .pathInfo(Collections.singletonMap(OutputFile.mapper.xml, System.getProperty("user.dir") + "/src/main/resources/mapper"))
                )

                // 策略配置
                .strategyConfig((scanner, builder) -> builder
                        .addInclude(getTables(listTable)) // 需要生成的表
                        .enableCapitalMode() // 开启大写命名
                        .enableSkipView() // 创建实体类的时候跳过视图

                        // Controller 策略配置
                        .controllerBuilder()
                        .enableRestStyle()
                        .enableHyphenStyle()
                        .formatFileName("%sController") // 格式化 Controller 类文件名称，%s进行匹配表名，如 UserController

                        // service 策略配置
                        .serviceBuilder()
                        .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                        .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl

                        // 实体类策略配置
                        .entityBuilder()
                        .enableLombok() // 开启 Lombok
                        .enableChainModel() // 开启链式模型
                        .enableTableFieldAnnotation() // 开启生成实体时生成字段注解
                        .addTableFills(
                                new Column("create_time", FieldFill.INSERT),
                                new Column("change_date", FieldFill.INSERT_UPDATE)
                        ) // 自动填充字段，填充策略
                        .build()

                        // Mapper 策略配置
                        .mapperBuilder()
                        .superClass(BaseMapper.class) // 设置父类
                        .enableBaseResultMap() // 启用 BaseResultMap 生成
                        .enableBaseColumnList() // 启用 BaseColumnList
                        .formatMapperFileName("%sMapper") //格式化 mapper 文件名称
                        .enableMapperAnnotation() // 开启 @Mapper 注解
                        .formatXmlFileName("%sXml") //格式化Xml文件名称
                        .formatMapperFileName("%sMapper")   //格式化Mapper文件名称

                )

                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */
                .templateEngine(new FreemarkerTemplateEngine())
                .execute(); // 执行
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}