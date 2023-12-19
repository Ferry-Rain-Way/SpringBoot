package com.power;

import com.power.pojo.Article;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class Lesson04JdbcTemplateApplicationTests {


    @Resource
    JdbcTemplate jdbcTemplate;
    @Test
    void testJdbcTemplate(){
        String sql = "select count(*) as ct from article ";
        Long count = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

    @Test
    void testQuery() {
// ？作为占位符
        String sql = "select * from article where id= ? ";
    //BeanPropertyRowMapper 将查询结果集，列名与属性名称匹配，名称完全匹配或驼峰
    // 此处没办法使用Record,此处是需要无参构造的,而Record不提供无参构造
    Article article = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Article.class), 1 );
        System.out.println("查询到的文章 = " + article);
    }

}
