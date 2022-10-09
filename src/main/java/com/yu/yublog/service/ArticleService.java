package com.yu.yublog.service;

import com.yu.yublog.common.lang.Code;
import com.yu.yublog.common.lang.ResponseResult;
import com.yu.yublog.dao.ArticleDao;
import com.yu.yublog.pojo.Article;
import com.yu.yublog.pojo.Article_re;
import com.yu.yublog.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 16:59
 * @Description: TODO
 */
@Service
public class ArticleService {

    private ArticleDao articleDao;

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    /**
     * 获取所有文章
     * @param code 响应码
     * @return 返回包含data和响应信息的对象
     * @throws IOException
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public ResponseResult<List<Article_re>> getAllArts(Code code) throws IOException {
        List<Article> articles = articleDao.queryAllArt();
        List<Article_re> data = MyUtils.artListToReList(articles);
        ResponseResult<List<Article_re>> result = new ResponseResult<>(code, data);
        return result;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public ResponseResult<Article_re>  getArtByTitle(String title) throws IOException {
        Article article = articleDao.queryArtByTitle(title);
        if (article == null){
            return new ResponseResult<>(Code.FAIL);
        }
        Article_re article_re = MyUtils.artToArt_re(article);
        return new ResponseResult<>(Code.SUCCESS,article_re);
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public ResponseResult addArt(Article_re article_re) throws IOException {
        Article art = MyUtils.reArtToArt(article_re);
        int i = articleDao.insertArt(art);
        if(i != 1){
           return ResponseResult.failure(Code.FAIL);
        }
        return  ResponseResult.success();
    }
}
