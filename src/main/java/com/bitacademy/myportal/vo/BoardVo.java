package com.bitacademy.myportal.vo;

import java.sql.Date;

public class BoardVo {
    Long no;
    String title;
    String content;
    Long hit;
    Date reg_date;
    Long user_no;
    String user_name;

    public BoardVo() {
        super();
    }

    public BoardVo(Long no, String title, String content, Long hit, Date reg_date, Long user_no, String user_name) {
        this.no = no;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.reg_date = reg_date;
        this.user_no = user_no;
        this.user_name = user_name;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getHit() {
        return hit;
    }

    public void setHit(Long hit) {
        this.hit = hit;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Long getUser_no() {
        return user_no;
    }

    public void setUser_no(Long user_no) {
        this.user_no = user_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", hit=" + hit +
                ", reg_date=" + reg_date +
                ", user_no=" + user_no +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
