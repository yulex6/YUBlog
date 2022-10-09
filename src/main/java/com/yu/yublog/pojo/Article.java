package com.yu.yublog.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: zl-yu
 * @Date: 2022/9/17 12:21
 * @Description: TODO
 */
@ApiModel(description = "文章数据库实体")
@Data
@NoArgsConstructor
public class Article implements Serializable {
    @ApiModelProperty("发表人ID")
    @NotNull
    private String userID;

    @ApiModelProperty("发表人名称")
    @NotNull
    private String username;

    @ApiModelProperty("文章标题")
    @NotNull
    private String title;

    @ApiModelProperty("文章描述")
    @NotNull
    private String desc;

    @ApiModelProperty("文章内容服务器相对地址")
    @NotNull
    private String contentUrl;



    @ApiModelProperty("发表时间")
    @NotNull
    private LocalDateTime created;
}
