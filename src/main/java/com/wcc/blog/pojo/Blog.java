package com.wcc.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    private Long id;  //主键
    private String title;  //标题
    private String content;  //内容
    private String firstPicture;  //首图地址
    private String flag;  //标记（原则，转载...）
    private Integer views;  //浏览次数
    private Boolean apperciation;  //是否开启打赏
    private Boolean shareStatement;  //是否开启版权
    private Boolean commentabled;  //是否开启评论
    private Boolean published;  //是否发布（保存草稿）
    private Boolean recommened;  // 是否推荐
    private Date createTime;  //创建时间
    private Date updateTime;  //更新时间
    private Boolean isDelete;
    private Long typeId;
    private Type type;  //所属分类
    private Long userId;
    private User user;  //所属用户
    private List<Comment> comments;  //相关评论
    private String tagIds;
    private List<Tag> tags;  //相关标签
    private String description; //博客描述，用于首页展示

    public void init(){
        this.tagIds = tagsToIds(this.getTags());
    }
    private String tagsToIds(List<Tag> tags){
        if (!tags.isEmpty()){
            StringBuffer ids = new StringBuffer();
            boolean f=false;
            for (Tag tag : tags) {
                if (f){
                    ids.append(",");
                }else {
                    f = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }

}
