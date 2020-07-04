package com.example.mybatis.mapper;

import com.example.mybatis.bean.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleMapper {

    public Article selectArticle(Integer id);

    public int updateArticle(Article article);

    public Article findById(Integer id);
}
