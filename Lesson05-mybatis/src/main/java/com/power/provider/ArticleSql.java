package com.power.provider;

public class ArticleSql {
    //查找
    public static String InsertArticle(){
        return """
                    insert into
                    article(user_id,title,summary,read_count,create_time,update_time) 
                    values(#{userId},#{title},#{summary},#{readCount},#{createTime},#{updateTime})
                    """;
    }
}
