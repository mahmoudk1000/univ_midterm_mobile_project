package com.example.vierapps;

public class Post {
    String name;
    String desc;
    String image;

    public Post() {
    }

    public Post(String name, String desc, String image) {
        this.name = name;
        desc = desc;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
