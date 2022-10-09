package com.yu.yublog.mapper;

import com.yu.yublog.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 12:33
 * @Description: ArticleMapper
 */
@Mapper
public interface ArticleMapper {

    @Insert("insert into yublog.article(user_id, username,title, description, content_url,created) values(#{article.userID},#{article.username},#{article.title},#{article.desc},#{article.contentUrl},#{article.created})")
    int insertArt(@Param("article")Article article);

    @Select("select * from yublog.article where title like CONCAT('%',#{title},'%');")
    @Results({
            @Result(property = "userID",column = "user_id"),
            @Result(property = "desc",column = "description"),
            @Result(property = "contentUrl",column = "content_url")
    })
    Article queryArtByTitle(@Param("title") String title);

    @Select("select * from yublog.article;")
    @Results({
            @Result(property = "userID",column = "user_id"),
            @Result(property = "desc",column = "description"),
            @Result(property = "contentUrl",column = "content_url")
    })
    List<Article> queryAllArt();
}
