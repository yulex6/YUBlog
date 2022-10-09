package com.yu.yublog.dao;

import com.yu.yublog.pojo.Article;

import java.util.List;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 16:44
 * @Description: TODO
 */
public interface ArticleDao {
    int insertArt(Article article);
    Article queryArtByTitle(String title);
    List<Article> queryAllArt();
}
