package com.example.mybatis;

import com.example.mybatis.bean.Article;
import com.example.mybatis.bean.Comment;
import com.example.mybatis.mapper.ArticleMapper;
import com.example.mybatis.mapper.CommentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void contextLoads() {
    }


    @Test
    void findByIdWithAnno() {
        Comment comment = commentMapper.findById(1);
        System.out.println(comment);
    }

    @Test
    void insertWithAnno() {
        Comment comment = new Comment();
        comment.setContent("very good");
        comment.setAuthor("kingRobin");
        comment.setaId(2);
        int result = commentMapper.insertComment(comment);

        System.out.println(result);
    }

    @Test
    void updateWithAnno() {
        Comment comment = new Comment();
        comment.setContent("good good good");
        comment.setId(6);

        int result = commentMapper.updateComment(comment);

        System.out.println(result);
    }

    @Test
    void deleteWithAnno() {
        int result = commentMapper.deleteComment(6);

        System.out.println(result);
    }

    @Test
    void selectArticle() {
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }

    @Test
    void updateArticle() {
        Article article = new Article();
        article.setContent("66666766");
        article.setId(2);
        int result = articleMapper.updateArticle(article);

        System.out.println(result);
    }

    @Test
    void findById() {
        Article article = articleMapper.findById(1);
        System.out.println(article);
    }
}
