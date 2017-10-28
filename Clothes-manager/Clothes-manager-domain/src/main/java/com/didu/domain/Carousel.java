package com.didu.domain;

/**
 * Created by Administrator on 2017/10/26.
 */
public class Carousel {
    private int id;
    private String name;
    private String url;

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

    public Carousel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Carousel(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Carousel() {
        super();
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
