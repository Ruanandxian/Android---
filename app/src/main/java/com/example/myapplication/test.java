package com.example.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class test {

    //不能用int
    @Id(autoincrement = true)
    private Long id;
    //名称
    @Unique
    private String name;
    //网址
    @Property(nameInDb = "url")
    private String url;
    //icon名字
    private String icon;
    //子item的内容
    private String item_content;
    //子item的url
    private String item_url;
    @Generated(hash = 1660172587)
    public test(Long id, String name, String url, String icon, String item_content,
            String item_url) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.item_content = item_content;
        this.item_url = item_url;
    }
    @Generated(hash = 1102163179)
    public test() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getIcon() {
        return this.icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getItem_content() {
        return this.item_content;
    }
    public void setItem_content(String item_content) {
        this.item_content = item_content;
    }
    public String getItem_url() {
        return this.item_url;
    }
    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

}