package com.power.mapper;

import com.power.pojo.Article;
import com.power.provider.ArticleSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface  ArticleMapple {

    //查询
    @Select("""
            select id,user_id,title , summary , read_count ,create_time ,update_time
            from article where id = #{articleId}
            """)
    @ResultMap("ArticleMapper")
    //注意:此处要么给类起别名,要么在application.properties文件中开启驼峰转换
    //又如果属性与对应的sql列名需要匹配,但是不符合驼峰转换的,使用结果映射
    Article queryArticleById(@Param("articleId") Integer  id);

    //插入
    @InsertProvider(type = ArticleSql.class ,method = "InsertArticle")
    void insertArticle(Article article);

}
