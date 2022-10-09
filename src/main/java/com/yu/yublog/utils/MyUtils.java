package com.yu.yublog.utils;

import com.yu.yublog.pojo.Article;
import com.yu.yublog.pojo.Article_re;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 19:38
 * @Description: TODO
 */
public class MyUtils {
    //后期修改为从配置文件读取
    private static final String prefix = "D:\\study\\bigPro\\YUBlog\\pages\\";

    /**
     * 根据md文件相对路径获取文件字符串形式
     * @param path 传入的md文件相对类路径地址
     * @return 返回md文件字符串形式
     * @throws IOException 抛出异常由上一层处理
     */
    public static String articleReader(String path) throws IOException {
        path = prefix+path;
        // 新建一个 BufferedInputStream 对象
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            // 读取文件的内容并复制到 String 对象中
        byte[] bytes = bufferedInputStream.readAllBytes();
        bufferedInputStream.close();
        return new String(bytes);
    }

    /**
     * 将前端传来的文章内容写入md文件
     * @param article 前端传来的文章对象
     * @return 返回md文件相对路径
     * @throws IOException
     */
    public static String articleWriter(Article_re article) throws IOException {
        String contentUrl =article.getTitle()+".md";
        String path = prefix + contentUrl;
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(article.getContent());
        writer.close();
        return contentUrl;
    }

    /**
     * ArticleList类型 转换为 Article_reList类型
     * @param articles 查询到的文章列表
     * @return List<Article_re>
     * @throws IOException
     */
    public static List<Article_re> artListToReList(List<Article> articles) throws IOException {
        if(articles.isEmpty())
            return new ArrayList<>(0);
        else {
            List<Article_re> articles_re = new ArrayList<>();
            for(Article art : articles){
                Article_re re = new Article_re();
                re.setUserID(art.getUserID());
                re.setTitle(art.getTitle());
                re.setContent(articleReader(art.getContentUrl()));
                re.setDesc(art.getDesc());
                re.setCreated(art.getCreated());
                re.setUsername(art.getUsername());
                articles_re.add(re);
            }
            return articles_re;
        }
    }

    /**
     * Article_re类型 转换为 Article类型
     * @param article_re 前端传来的文章对象
     * @return 返回数据库文章实体对象
     * @throws IOException
     */
    public static Article reArtToArt(Article_re article_re) throws IOException {
        Article article = new Article();
        article.setUserID(article_re.getUserID());
        article.setUsername(article_re.getUsername());
        article.setTitle(article_re.getTitle());
        article.setDesc(article_re.getDesc());
        article.setContentUrl(articleWriter(article_re));
        article.setCreated(article_re.getCreated());
        return  article;
    }

    public static Article_re artToArt_re(Article article) throws IOException {
        Article_re article_re = new Article_re();
        article_re.setUsername(article.getUsername());
        article_re.setUserID(article.getUserID());
        article_re.setTitle(article.getTitle());
        article_re.setDesc(article.getDesc());
        article_re.setCreated(article.getCreated());
        article_re.setContent(articleReader(article.getContentUrl()));
        return article_re;
    }
}
