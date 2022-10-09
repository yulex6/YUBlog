package com.yu.yublog.controller;

import com.yu.yublog.common.lang.Code;
import com.yu.yublog.common.lang.ResponseResult;
import com.yu.yublog.pojo.Article_re;
import com.yu.yublog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Api(tags = "文章管理")
@RestController
@RequestMapping("/common/page")
public class ArticleCommonController {
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @ApiOperation(value = "获取所有文章")
    @GetMapping("/all")
    public ResponseResult<List<Article_re>> getArticles() throws IOException {
        ResponseResult<List<Article_re>> result = articleService.getAllArts(Code.SUCCESS);
        return  result;
    }
    @ApiOperation(value = "根据title查询文章")
    @GetMapping("/getPage/{title}")
    public ResponseResult<Article_re> getArtByTitle( @PathVariable String title) throws IOException {
        ResponseResult<Article_re> res = articleService.getArtByTitle(title);
        return res;
    }
}
