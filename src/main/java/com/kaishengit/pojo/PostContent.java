package com.kaishengit.pojo;

/**
 * Created by 蔡林红 on 2017/11/28.
 */
public class PostContent {

    private Integer id;
    private  String content;
    private Post post;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
