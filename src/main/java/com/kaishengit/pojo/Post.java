package com.kaishengit.pojo;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class Post {
    private Integer id;
    private String  title;
    private  PostContent postContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostContent getPostContent() {
        return postContent;
    }

    public void setPostContent(PostContent postContent) {
        this.postContent = postContent;
    }
}
