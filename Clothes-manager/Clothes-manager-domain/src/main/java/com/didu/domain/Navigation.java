package com.didu.domain;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Navigation {
    private int id;
    private String name;
    private String url;
    private String text;

    public Navigation(int id, String name, String url, String text) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.text = text;
    }

    public Navigation() {
        super();
    }

    public Navigation(String name, String url, String text) {
        this.name = name;
        this.url = url;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Navigation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
