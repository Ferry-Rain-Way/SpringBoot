package com.power;

import com.power.mapper.ArticleMapple;
import com.power.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class MybatisTests {

	@Autowired(required=true)
	private ArticleMapple articleMapple;


	@Test
	void testSelectById() {
		Article article = articleMapple.queryArticleById(1);
		System.out.println(article);
	}

	@Test
	void testProvider(){
		Article article = new Article();
		article.setTitle("什么时候用微服务");
		article.setSummary("微服务优缺点");
		article.setUserId(219);
		article.setReadCount(560);
		article.setCreateTime(LocalDateTime.now());
		article.setUpdateTime(LocalDateTime.now());

		articleMapple.insertArticle(article);
	}


}
