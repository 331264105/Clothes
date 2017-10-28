package com.didu.domain;

/**
 * Created by Administrator on 2017/10/27.
 */
public class Hypermarket {
    private int id;
    private String url;
    private String title;
    private String time;
    private String location;
    private String describ;
    private String price;
    private String grade;
    private String remark;
    private int pai;
    private String property;
    private String classify;

    public Hypermarket(int id, String url, String title, String time, String location, String describ, String price, String grade, String remark, int pai, String property, String classify) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.time = time;
        this.location = location;
        this.describ = describ;
        this.price = price;
        this.grade = grade;
        this.remark = remark;
        this.pai = pai;
        this.property = property;
        this.classify = classify;
    }

    public Hypermarket(String url, String title, String time, String location, String describ, String price, String grade, String remark, int pai, String property, String classify) {
        this.url = url;
        this.title = title;
        this.time = time;
        this.location = location;
        this.describ = describ;
        this.price = price;
        this.grade = grade;
        this.remark = remark;
        this.pai = pai;
        this.property = property;
        this.classify = classify;
    }

    public Hypermarket() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    @Override
    public String toString() {
        return "Hypermarket{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", describ='" + describ + '\'' +
                ", price='" + price + '\'' +
                ", grade='" + grade + '\'' +
                ", remark='" + remark + '\'' +
                ", pai=" + pai +
                ", property='" + property + '\'' +
                ", classify='" + classify + '\'' +
                '}';
    }
}
