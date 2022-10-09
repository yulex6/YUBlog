package com.yu.yublog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @Author: zl-yu
 * @Date: 2022/9/22 14:13
 * @Description: TODO
 */
@ApiModel(description = "文章返回实体")
@Data
@NoArgsConstructor
public class Article_re {
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


    @ApiModelProperty("文章内容")
    @NotNull
    private String content;

    @ApiModelProperty("发表时间")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;
}
