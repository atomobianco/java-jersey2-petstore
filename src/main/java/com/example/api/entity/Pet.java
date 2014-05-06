package com.example.api.entity;

import java.util.ArrayList;
import java.util.List;

public class Pet extends Entity {

    private Category category;
    private String name;
    private List<String> photoUrls = new ArrayList<String>();
    private List<Tag> tags = new ArrayList<Tag>();
    private String status;

    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<String> getPhotoUrls() {return photoUrls;}
    public void setPhotoUrls(List<String> photoUrls) {this.photoUrls = photoUrls;}

    public List<Tag> getTags() {return tags;}
    public void setTags(List<Tag> tags) {this.tags = tags;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

}
