package com.yu.yublog.dao;

import com.yu.yublog.mapper.ArticleMapper;
import com.yu.yublog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 16:50
 * @Description: TODO
 */
@Repository
public class ArticleDapImpl implements ArticleDao{
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public int insertArt(Article article) {
        return articleMapper.insertArt(article);
    }

    @Override
    public Article queryArtByTitle(String title) {
        return articleMapper.queryArtByTitle(title);
    }

    @Override
    public List<Article> queryAllArt() {
        return articleMapper.queryAllArt();
    }
}
